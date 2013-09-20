package org.owller.CubeWorld.Server.Network.Packet;

import org.owller.CubeWorld.Arrays.CubeByteArray;
import org.owller.CubeWorld.Entity.CubeEntity;
import org.owller.CubeWorld.Entity.CubePlayer;
import org.owller.CubeWorld.Owller;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketException;
import org.owller.CubeWorld.Server.Network.Packet.Server.CubePlayerJoinPacket;

public class CubePacket {
    public static CubePacket getServerVersionPacket() {
        String v = Owller.SERVER_VERSION.replace(".", "");
        
        char[] parts = v.toCharArray();
        
        byte[] version = new byte[parts.length];
        for(int i = 0; i < parts.length; i++) {
            version[i] = Byte.parseByte(parts[i] + "");
        }
        
        return new CubePacket(CubePacketType.VERSION_EXCHANGE, version);
    }
    
    public static CubePacket makeServerFullPacket() {
        return new CubePacket(CubePacketType.SERVER_FULL);
    }
    
    public static CubePacket makePacket(CubePacketType type, byte[] data) {
        return new CubePacket(type, data);
    }
    
    public static CubePacket makePacket(CubePacketType type, CubeEntity entity) throws InvalidPacketException {
        if(type.equals(CubePacketType.PLAYER_JOIN)) {
            return ((CubePlayerJoinPacket) type).makePacket((CubePlayer) entity);
        }
        
        throw new InvalidPacketException(type);
    }
    
    //Instance
    private CubePacketType type;
    private CubeByteArray data;
    
    public CubePacket(CubePacketType type) {this(type, new byte[0]);}
    
    public CubePacket(CubePacketType type, byte[] data) {
        this.type = type;
        this.data = new CubeByteArray(type.getPacketID());
        this.data.addData(data);
    }
    
    public CubePacketType getType() {return this.type;}
    public CubeByteArray getData() {return this.data;}
    
    @Override
    public String toString() {
        String s = "[" + this.type.getPacketID();
        
        for(byte b : this.getData().getByteArray()) {
            s += ", " + b;
        }
        
        s += "]";
        
        return s;
    }
}
