package org.owller.CubeWorld;

import org.owller.CubeWorld.Logging.CubeLogger;
import org.owller.CubeWorld.Server.CubeServer;

public class Owller {
    public static final String SERVER_VERSION = "00.03";
    
    private static CubeServer server;
    
    public static void main(String[] args) {
        server = new CubeServer();
        server.start();
    }
    
    public static CubeServer getServer() { return server; }
    public static CubeLogger getLogger() { return server.getLogger(); }
    
    public static void stopServer() {
        server.stop();
    }
}
