package org.owller.CubeWorld.Entity;

import org.owller.CubeWorld.Server.Network.CubeSocketManager;

public class CubePlayer extends CubeEntity {
    private CubeSocketManager manager;
    
    public CubePlayer(CubeSocketManager manager) {
        this.manager = manager;
    }
    
    public CubeSocketManager getSocketManager() {return this.manager;}
}
