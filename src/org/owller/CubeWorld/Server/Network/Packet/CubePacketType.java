package org.owller.CubeWorld.Server.Network.Packet;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketException;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketTypeException;
import org.owller.CubeWorld.Server.Network.Packet.Server.CubePlayerJoinPacket;
import org.owller.CubeWorld.Server.Network.Packet.Shared.CubeVersionExchangePacket;

public class CubePacketType {
    private static final List<CubePacketType> PACKETS = new ArrayList<CubePacketType>();
    
    //Packet IDs
    public static final CubePacketType PLAYER_JOIN = new CubePlayerJoinPacket();
    public static final CubePacketType VERSION_EXCHANGE = new CubeVersionExchangePacket();
    public static final CubePacketType SERVER_FULL = new CubePacketType((byte) 18, "Server Full");
    
    //Static
    public static CubePacketType getByID(byte id) throws InvalidPacketTypeException {
        for(CubePacketType packet : PACKETS) {
            if(!packet.compare(id)) continue;
            return packet;
        }
        
        throw new InvalidPacketTypeException(id);
    }
    
    //Instance
    private byte id;
    private String name;
    
    public CubePacketType(byte packet, String name) {this.id = packet; this.name = name; PACKETS.add(this);}
    
    public byte getPacketID() {return this.id;}
    public String getName() {return this.name;}
    public boolean compare(byte id) {return (this.id == id);}

    public CubePacket decode(DataInputStream is) throws InvalidPacketException, IOException {
        throw new InvalidPacketException(this);
    }
}
