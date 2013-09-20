package org.owller.CubeWorld.Entity;

import java.util.BitSet;

public class CubeEntityData {
    public static CubeEntityData make(CubeEntity entity) {
        return new CubeEntityData(entity);
    }
    
    //Instance
    private CubeEntity entity;
    
    private CubeEntityData(CubeEntity entity) {
        
        
        this.entity = entity;
    }
}
