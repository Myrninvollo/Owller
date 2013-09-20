package org.owller.CubeWorld.Server.Threads;

import java.io.IOException;
import java.net.Socket;
import org.owller.CubeWorld.Owller;
import org.owller.CubeWorld.Server.CubeSocketServer;

public class CubeSocketServerThread extends CubeThread {
    
    private CubeSocketServer socketServer;
    
    public CubeSocketServerThread(CubeSocketServer socketServer) {
        this.socketServer = socketServer;
    }
    
    public CubeSocketServer getSocketServer() {return this.socketServer;}
    
    @Override
    public void run() {
        while(this.socketServer.getSocketServer() == null) {}
        while(true) {
            try {
                this.handleSocket();
            } catch(IOException e) {
                continue;
            }
        }
    }
    
    private void handleSocket() throws IOException {
        Owller.getLogger().debug("Checking for Socket...");
        Socket connection = this.socketServer.getSocketServer().accept();
        this.socketServer.handleSocket(connection);
        Owller.getLogger().debug("Got Socket!");
    }
}
