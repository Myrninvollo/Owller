package org.owller.CubeWorld.Server.Network.Packet.Server;

import org.owller.CubeWorld.Entity.CubePlayer;
import org.owller.CubeWorld.Server.Network.Packet.CubePacket;
import org.owller.CubeWorld.Server.Network.Packet.CubePacketType;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketException;
import org.owller.CubeWorld.Server.Network.Packet.Shared.CubeEntityUpdatePacket;

public class CubePlayerJoinPacket extends CubePacketType {
    private CubePlayer makingPlayer;
    
    public CubePlayerJoinPacket() {
        super((byte) 16, "Player Join");
    }

    public CubePacket makePacket(CubePlayer player) throws InvalidPacketException {
        if(player == null) throw new InvalidPacketException(this);
        if(!(player instanceof CubePlayer))  throw new InvalidPacketException(this);
        
        CubePacket packet = new CubePacket(this);
        packet.getData().addInt(0);
        packet.getData().addLong(player.getID());
        packet.getData().addData(CubeEntityUpdatePacket.makeEntityUpdateByteArray(player));
        return packet;
    }
}
