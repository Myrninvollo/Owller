package org.owller.CubeWorld.Entity;

import org.owller.CubeWorld.World.CubeVector;

public class CubeEntityAppearance {
    private char nothing;
    private char nothing2;
    
    private byte hairRed;
    private byte hairGreen;
    private byte hairBlue;
    
    private byte movementFlags;
    private byte entityFlags;
    
    private double scale;
    private double boundingRadius;
    private double boundingHeight;
    
    private short headModel;
    private short hairModel;
    private short handModel;
    private short foodModel;
    private short backModel;
    private short shoulderModel;
    private short wingModel;
    
    private double headScale;
    private double bodyScale;
    private double handScale;
    private double footScale;
    private double shoulderScale;
    private double weaponScale;
    private double backScale;
    private double unknownValue;
    private double wingScale;
    
    private float bodyPitch;
    private float armPitch;
    private float armRoll;
    private float armYaw;
    private float feetPitch;
    private float wingPitch;
    private float backPitch;
    
    private CubeVector bodyOffset;
    private CubeVector headOffset;
    private CubeVector handOffset;
    private CubeVector footOffset;
    private CubeVector backOffset;
    private CubeVector wingOffset;
    
    public CubeEntityAppearance() {
        this.nothing = 0x00;
        this.nothing2 = 0x00;
        this.hairRed = 0x00;
        this.hairGreen = 0x00;
        this.hairBlue = 0x00;
        this.movementFlags = 0x00;
        this.entityFlags = 0x00;
        
        this.scale = 1.0d;
        this.boundingRadius = 1.0d;
        this.boundingHeight = 1.0d;
        
        this.headModel = 0;
        this.hairModel = 0;
        this.handModel = 0;
        this.foodModel = 0;
        this.backModel = 0;
        this.shoulderModel = 0;
        this.wingModel = 0;
        
        this.headScale = 1.0;
        this.bodyScale = 1.0;
        this.handScale = 1.0;
        this.footScale = 1.0;
        this.shoulderScale = 1.0;
        this.weaponScale = 1.0;
        this.backScale = 1.0;
        this.unknownValue = 1.0;
        this.wingScale = 1.0;
        
        this.bodyPitch = 1.0f;
        this.armPitch = 1.0f;
        this.armRoll = 1.0f;
        this.armYaw = 1.0f;
        this.feetPitch = 1.0f;
        this.wingPitch = 1.0f;
        this.backPitch = 1.0f;
        
        this.bodyOffset = new CubeVector();
        this.headOffset = new CubeVector();
        this.handOffset = new CubeVector();
        this.footOffset = new CubeVector();
        this.backOffset = new CubeVector();
        this.wingOffset = new CubeVector();
    }
    
    public char getNothing() {return this.nothing;}
    public char getNothing2() {return this.nothing2;}
    
    public byte getHairRed() {return this.hairRed;}
    public byte getHairGreen() {return this.hairGreen;}
    public byte getHairBlue() {return this.hairBlue;}
    
    public byte getMovementFlags() {return this.movementFlags;}
    public byte getEntityFlags() {return this.entityFlags;}
    
    public double getScale() {return this.scale;}
    public double getBoundingRadius() {return this.boundingRadius;}
    public double getBoundingHeight() {return this.boundingHeight;}
    
    public short getHeadModel() {return this.headModel;}
    public short getHairModel() {return this.hairModel;}
    public short getHandModel() {return this.handModel;}
    public short getFoodModel() {return this.foodModel;}
    public short getBackModel() {return this.backModel;}
    public short getShoulderModel() {return this.shoulderModel;}
    public short getWingModel() {return this.wingModel;}
    
    public double getHeadScale() {return this.headScale;}
    public double getBodyScale() {return this.bodyScale;}
    public double getHandScale() {return this.handScale;}
    public double getFootScale() {return this.footScale;}
    public double getShoulderScale() {return this.shoulderScale;}
    public double getWeaponScale() {return this.weaponScale;}
    public double getBackScale() {return this.backScale;}
    public double getWingScale() {return this.wingScale;}
    
    public double getUnknownValue() {return this.unknownValue;}
    
    public float getBodyPitch() {return this.bodyPitch;}
    public float getFeetPitch() {return this.feetPitch;}
    public float getWingPitch() {return this.wingPitch;}
    public float getBackPitch() {return this.backPitch;}
    
    public float getArmPitch() {return this.armPitch;}
    public float getArmRoll() {return this.armRoll;}
    public float getArmYaw() {return this.armYaw;}
    
    public CubeVector getBodyOffset() {return this.bodyOffset;}
    public CubeVector getHeadOffset() {return this.headOffset;}
    public CubeVector getHandOffset() {return this.handOffset;}
    public CubeVector getFootOffset() {return this.footOffset;}
    public CubeVector getBackOffset() {return this.backOffset;}
    public CubeVector getWingOffset() {return this.wingOffset;}
}
