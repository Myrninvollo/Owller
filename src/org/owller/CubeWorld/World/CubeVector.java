package org.owller.CubeWorld.World;

public class CubeVector {
    private double x;
    private double y;
    private double z;
    
    public CubeVector() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
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
}
