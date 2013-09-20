package org.owller.CubeWorld.Server.Threads;

import org.owller.CubeWorld.Owller;
import org.owller.CubeWorld.Server.CubeServer;

public class CubeServerThread extends CubeThread {
    private CubeServer server;
    
    public CubeServerThread(CubeServer server) {
        this.server = server;
    }
    
    public CubeServer getServer() {return this.server;}
    
    @Override
    public void run() {
        //Check that server is bound
        while(this.getServer().getSocketServer() == null) {}
        while(this.getServer().getSocketServer().getSocketServer() == null) {}
        
        if(!this.getServer().getSocketServer().getSocketServer().isBound()) {
            this.getServer().getLogger().warn(" ## Failed to Bind Server! Check another server isn't running ## ");
            Owller.stopServer();
        }
        
        while(true) {
        }
    }
}
