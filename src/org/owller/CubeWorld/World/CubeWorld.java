package org.owller.CubeWorld.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.owller.CubeWorld.Entity.CubeEntity;
import org.owller.CubeWorld.Entity.CubePlayer;
import org.owller.CubeWorld.Server.CubeServer;

public class CubeWorld {
    private String name;
    private int seed;
    private CubeServer server;
    
    private List<CubePlayer> players;
    private List<CubeEntity> entities;
    
    public CubeWorld(String name, CubeServer server) {
        this(name, new Random().nextInt(Integer.MAX_VALUE - (Integer.MAX_VALUE / 2)), server);
    }
    
    public CubeWorld(String name, int seed, CubeServer server) {
        this.name = name;
        this.seed = seed;
        this.server = server;
        
        this.players = new ArrayList<CubePlayer>();
        this.entities = new ArrayList<CubeEntity>();
        
        this.server.getLogger().debug("Loaded World " + name + ". Seed: " + seed);
    }
    
    public String getName() {return this.name;}
    public int getSeed() {return this.seed;}
    public CubeServer getServer() {return this.server;}
    
    public void addEntity(CubeEntity entitiy) {this.entities.add(entitiy);}
    public void addPlayer(CubePlayer entitiy) {this.players.add(entitiy);}
}
