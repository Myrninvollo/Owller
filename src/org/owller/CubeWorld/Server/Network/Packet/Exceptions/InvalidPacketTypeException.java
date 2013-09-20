package org.owller.CubeWorld.Server.Network.Packet.Exceptions;

public class InvalidPacketTypeException extends Exception {
    private byte id;
    
    public InvalidPacketTypeException(byte id) {
        super("There is no Packet with the ID \"" + id + "\"");
        this.id = id;
    }
    
    public byte getID() {return this.id;}
}
