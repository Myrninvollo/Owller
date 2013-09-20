package org.owller.CubeWorld.Server.Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.owller.CubeWorld.Entity.CubePlayer;
import org.owller.CubeWorld.Logging.CubeLogger;
import org.owller.CubeWorld.Owller;
import org.owller.CubeWorld.Server.Network.Packet.CubePacket;
import org.owller.CubeWorld.Server.Network.Packet.CubePacketType;
import org.owller.CubeWorld.Server.Network.CubeSocketCloseReason;
import org.owller.CubeWorld.Server.Network.CubeSocketManager;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketException;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketTypeException;

public class CubeSocketThread extends CubeThread {
    private CubeSocketManager manager;
    
    public CubeSocketThread(CubeSocketManager manager) {
        this.manager = manager;
    }
    
    public CubeSocketManager getManager() {return this.manager;}
    public CubeLogger getLogger() {return this.manager.getServer().getServer().getLogger();}
    
    @Override
    public void run() {
        while(this.getManager() != null && this.getManager().getSocket() != null && 
                this.getManager().getSocket().isConnected() && !this.getManager().getSocket().isInputShutdown()) {
            getLogger().info("Checking for Packets...");
            try {
                DataInputStream is = new DataInputStream(this.manager.getSocket().getInputStream());
                byte id = is.readByte();
                getLogger().debug("Client Sent byte: " + id);
                CubePacketType packetType = CubePacketType.getByID(id);
                CubePacket packet = packetType.decode(is);
                this.recievePacket(packet);
            } catch(IOException e) {
                if(e.getMessage().equals("Socket is closed")) break;
                getLogger().debug("Caught Exception: " + e.getMessage());
                continue;
            } catch (InvalidPacketTypeException e) {
                getLogger().debug("Caught Exception: " + e.getMessage());
                continue;
            } catch(InvalidPacketException e) {
                getLogger().debug("Caught Exception: " + e.getMessage());
                continue;
            }
        }
        
        if(this.manager != null) this.manager.closeSocket(CubeSocketCloseReason.LOST_CONNECTION);
    }
    
    public void recievePacket(CubePacket packet) throws InvalidPacketTypeException, InvalidPacketException {
        if(packet == null) return;
        
        getLogger().debug("Got: " + packet.toString());
        
        //Start Packet Logic
        if(packet.getType().equals(CubePacketType.VERSION_EXCHANGE)) {
            //Client has Sent the version of their game
            this.getManager().setVersion(packet.getData().getByteArray());
            
            //Check for Update Issues
            if(this.getManager().getClientVersion() == null || 
                    !this.getManager().getClientVersion().equals(Owller.SERVER_VERSION)) {
                this.sendPacket(CubePacket.getServerVersionPacket());
                this.manager.closeSocket(CubeSocketCloseReason.OUTDATED);
                return;
            }
            
            //Check if Server is Full (MIGHT FIX LATER WITH OVERRIDE FOR ADMINS)
            if(this.getManager().getServer().getServer().isServerFull() && !this.getManager().isConnnected()) {
                this.sendPacket(CubePacket.makeServerFullPacket());
                this.manager.closeSocket(CubeSocketCloseReason.SERVER_FULL);
                return;
            }
            
            if(this.getManager().isConnnected()) return;
            
            //Player is Trying to Join, let's get started.
            CubePlayer player = new CubePlayer(this.manager);
            CubePacket playerJoin = CubePacket.makePacket(CubePacketType.PLAYER_JOIN, player);
            if(this.sendPacket(playerJoin)) {
                getLogger().debug("Sent!");
            } else {
                getLogger().debug("Failed to Send!");
            }
        }
    }
    
    public boolean sendPacket(CubePacket packet) {
        try {
            this.trySendPacket(packet);
            return true;
        } catch (IOException e) {return false;}
    }
    
    public void trySendPacket(CubePacket packet) throws IOException {
        //getLogger().debug("Sending: " + packet.toString());
        DataOutputStream os = new DataOutputStream(this.manager.getSocket().getOutputStream());
        getLogger().debug("Writing Packet...");
        os.write(packet.getData().getByteArray());
        getLogger().debug("Flushing Packet...");
        os.flush();
        getLogger().debug("Flushed!");
    }
}
