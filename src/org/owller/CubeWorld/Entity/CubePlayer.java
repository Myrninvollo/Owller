package org.owller.CubeWorld.Entity;

import org.owller.CubeWorld.Server.Network.CubeSocketManager;
import org.owller.CubeWorld.World.CubeWorld;

public class CubePlayer extends CubeEntity {
    private CubeSocketManager manager;
    
    public CubePlayer(CubeSocketManager manager, CubeWorld world) {
        super(world);
        this.manager = manager;
        
        world.addPlayer(this);
    }
    
    public CubeSocketManager getSocketManager() {return this.manager;}
}
