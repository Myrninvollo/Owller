package org.owller.CubeWorld.World;

public class CubeLocation {
    private double x;
    private double y;
    private double z;
    
    private double roll;
    private double pitch;
    private double yaw;
    
    private CubeWorld world;
    
    public CubeLocation(CubeWorld world) {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
        
        this.roll = 0.0d;
        this.pitch = 0.0d;
        this.yaw = 0.0d;
        
        this.world = world;
    }
    
    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public double getZ() {return this.z;}

    public long getLongX() {return (long) this.x;}
    public long getLongY() {return (long) this.y;}
    public long getLongZ() {return (long) this.z;}

    public float getFloatX() {return (float) this.x;}
    public float getFloatY() {return (float) this.y;}
    public float getFloatZ() {return (float) this.z;}
    
    public double getRoll() {return this.roll;}
    public double getPitch() {return this.pitch;}
    public double getYaw() {return this.yaw;}
    
    public float getFloatRoll() {return (float) this.roll;}
    public float getFloatPitch() {return (float) this.pitch;}
    public float getFloatYaw() {return (float) this.yaw;}
    
    public CubeWorld getWorld() {return this.world;}
}
