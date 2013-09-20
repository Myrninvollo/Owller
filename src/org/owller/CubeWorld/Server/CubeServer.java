package org.owller.CubeWorld.Server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.owller.CubeWorld.Logging.CubeLogger;
import org.owller.CubeWorld.Server.Threads.CubeServerThread;
import org.owller.CubeWorld.World.CubeWorld;

public class CubeServer {
    private CubeLogger logger;
    private CubeSocketServer socketServer;
    private CubeServerThread serverThread;
    
    private int maxPlayers;
    
    private List<CubeWorld> worlds;
    
    public CubeServer() {
        this.logger = new CubeLogger();
        this.socketServer = new CubeSocketServer(this, 12345);
        this.serverThread = new CubeServerThread(this);
        
        this.maxPlayers = 10;
        
        this.worlds = new ArrayList<CubeWorld>();
        
        //DEBUG: Load a DEBUG World
        CubeWorld debugWorld = new CubeWorld("DEBUG", this);
        this.worlds.add(debugWorld);
    }
    
    public CubeLogger getLogger() { return this.logger; }
    public CubeSocketServer getSocketServer() {return this.socketServer;}
    public CubeServerThread getServerThread() {return this.serverThread;}
    public int getMaxPlayers() {return this.maxPlayers;}
    public int getOnlinePlayers() {return 0;}
    public Set<CubeWorld> getWorlds() {return new HashSet<CubeWorld>(this.worlds);}
    
    public void setMaxPlayers(int max) {this.maxPlayers = max;}
    
    public boolean isServerFull() {return this.getOnlinePlayers() >= this.getMaxPlayers();}

    public void stop() {
        this.socketServer.stop();
        this.serverThread.stopThread();
    }
    
    public void start() {
        getLogger().info("Starting Server.");
        if(!this.socketServer.start()) return;
        this.serverThread.startThread();
        getLogger().info("Started Server!");
    }

    public CubeWorld getDefaultWorld() {
        //TODO: Allow For Default world to be set.
        return this.worlds.get(0);
    }
}
