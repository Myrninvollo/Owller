package org.owller.CubeWorld.Server.Network.Packet.Exceptions;

import org.owller.CubeWorld.Server.Network.Packet.CubePacketType;

public class InvalidPacketException extends Exception {
    private CubePacketType type;
    
    public InvalidPacketException(CubePacketType type) {
        super("Invalid Packet was formed.");
        this.type = type;
    }
    
    public CubePacketType getType() {return this.type;}
}
