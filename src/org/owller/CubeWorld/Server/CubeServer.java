package org.owller.CubeWorld.Server;

import org.owller.CubeWorld.Logging.CubeLogger;
import org.owller.CubeWorld.Server.Threads.CubeServerThread;

public class CubeServer {
    private CubeLogger logger;
    private CubeSocketServer socketServer;
    private CubeServerThread serverThread;
    
    private int maxPlayers;
    
    public CubeServer() {
        this.logger = new CubeLogger();
        this.socketServer = new CubeSocketServer(this, 12345);
        this.serverThread = new CubeServerThread(this);
        
        this.maxPlayers = 10;
    }
    
    public CubeLogger getLogger() { return this.logger; }
    public CubeSocketServer getSocketServer() {return this.socketServer;}
    public CubeServerThread getServerThread() {return this.serverThread;}
    public int getMaxPlayers() {return this.maxPlayers;}
    public int getOnlinePlayers() {return 0;}
    
    public void setMaxPlayers(int max) {this.maxPlayers = max;}
    
    public boolean isServerFull() {return this.getOnlinePlayers() >= this.getMaxPlayers();}

    public void stop() {
        this.socketServer.stop();
        this.serverThread.stopThread();
    }
    
    public void start() {
        getLogger().info("Starting Server.");
        this.socketServer.start();
        this.serverThread.startThread();
        getLogger().info("Started Server!");
    }
}
