package org.owller.CubeWorld.Server.Network;

public class CubeSocketCloseReason {
    public static final CubeSocketCloseReason OUTDATED = new CubeSocketCloseReason("Outdated");
    public static final CubeSocketCloseReason SERVER_FULL = new CubeSocketCloseReason("Server Full");
    public static final CubeSocketCloseReason LOST_CONNECTION = new CubeSocketCloseReason("Lost Connection");
    public static final CubeSocketCloseReason INVALID_PACKET = new CubeSocketCloseReason("Invalid Packet");
    
    private String reason;
    
    public CubeSocketCloseReason(String reason) {this.reason = reason;}
    
    public String getReason() {return this.reason;}
}
