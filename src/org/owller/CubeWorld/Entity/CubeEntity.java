package org.owller.CubeWorld.Entity;

import org.owller.CubeWorld.World.CubeLocation;
import org.owller.CubeWorld.World.CubeVector;

public class CubeEntity {
    private static final byte HOSTILE_LEVEL_HOSTILE = -127;
    private static final byte HOSTILE_LEVEL_FRIENDLY = -124;
    private static final byte HOSTILE_LEVEL_PET = -123;
    
    private static long nextID = Long.MIN_VALUE;
    
    private static long requestNewID() {
        nextID++;
        return nextID;
    }
    
    //Instance
    private long id;
    private CubeLocation location;
    private CubeVector velocity;
    private CubeVector altVelocity;
    private CubeVector acceleration;
    
    private CubeEntityType type;
    
    private float viewport;
    
    private float hp;
    private float mp;
    
    private int xp;
    
    //Entity Appearance
    private CubeEntityAppearance appearance;
    
    public CubeEntity() {
        this.id = CubeEntity.requestNewID();
        
        this.type = CubeEntityType.ELF_MALE;
        
        this.location = new CubeLocation();
        this.velocity = new CubeVector();
        this.altVelocity = new CubeVector();
        this.acceleration = new CubeVector();
        
        this.viewport = 0.0f;
        
        this.hp = 1.0f;
        this.mp = 1.0f;
    }
    
    public long getID() {return this.id;}
    public CubeLocation getLocation() {return this.location;}
    public CubeVector getVelocity() {return this.velocity;}
    public CubeVector getAlterVelocity() {return this.altVelocity;}
    public CubeVector getAcceleration() {return this.acceleration;}
    public float getViewport() {return this.viewport;}
    public CubeEntityType getType() {return this.type;}
    public CubeEntityAppearance getAppearance() {return this.appearance;}
    public float getHealth() {return this.hp;}
    public float getMana() {return this.mp;}
    public int getXP() {return this.xp;}
    public int getLevel() {return this.getXP() / 100;}
    
    //Returns how 'e' See's 'this'
    public byte getHostileLevel(CubeEntity e) {
        if(e == null) return CubeEntity.HOSTILE_LEVEL_HOSTILE;
        return 0x0;
    }
}
