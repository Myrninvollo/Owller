package org.owller.CubeWorld.Server.Network.Packet.Shared;

import java.io.DataInputStream;
import java.io.IOException;
import org.owller.CubeWorld.Server.Network.Packet.CubePacket;
import org.owller.CubeWorld.Server.Network.Packet.CubePacketType;
import org.owller.CubeWorld.Server.Network.Packet.Exceptions.InvalidPacketException;

public class CubeVersionExchangePacket extends CubePacketType {
    public CubeVersionExchangePacket() {
        super((byte) 17, "Version Exchange");
    }
    
    @Override
    public CubePacket decode(DataInputStream is) throws InvalidPacketException, IOException {
        byte[] data = new byte[7];
        is.readFully(data);
        
        CubePacket packet = new CubePacket(this, data);
        return packet;
    }
}
