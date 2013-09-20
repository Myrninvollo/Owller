package org.owller.CubeWorld.Server.Network.Packet.Shared;

import java.util.BitSet;
import org.owller.CubeWorld.Arrays.CubeByteArray;
import org.owller.CubeWorld.Entity.CubeEntity;

public class CubeEntityUpdatePacket {
    public static CubeByteArray makeEntityUpdateByteArray(CubeEntity entity) {
        BitSet bs = new BitSet(64);
        bs.set(0, 63, true);
        return makeEntityUpdateByteArray(entity, bs, null);
    }
    
    public static CubeByteArray makeEntityUpdateByteArray(CubeEntity entity, BitSet bs, CubeEntity target) {
        CubeByteArray cba = new CubeByteArray();
        
        cba.addData(entity.getID());
        
        cba.addData(bs);
        
        //Now Add
        if(bs.get(0)) {
            //Send Location (Long Vector)
            cba.addData(entity.getLocation().getLongX());
            cba.addData(entity.getLocation().getLongY());
            cba.addData(entity.getLocation().getLongZ());
        }
        
        if(bs.get(1)) {
            //Send Orientation (3*Float)
            cba.addData(entity.getLocation().getFloatRoll());
            cba.addData(entity.getLocation().getFloatPitch());
            cba.addData(entity.getLocation().getFloatYaw());
        }
        
        if(bs.get(2)) {
            //Send Velocity (Float Vector)
            cba.addData(entity.getVelocity().getFloatX());
            cba.addData(entity.getVelocity().getFloatY());
            cba.addData(entity.getVelocity().getFloatZ());
        }
        
        if(bs.get(3)) {
            //Send Acceleration (Float Vector)
            cba.addData(entity.getAcceleration().getFloatX());
            cba.addData(entity.getAcceleration().getFloatY());
            cba.addData(entity.getAcceleration().getFloatZ());
        }
        
        if(bs.get(4)) {
            //Send "Alter Velocity" (Float Vector)
            cba.addData(entity.getAlterVelocity().getFloatX());
            cba.addData(entity.getAlterVelocity().getFloatY());
            cba.addData(entity.getAlterVelocity().getFloatZ());
        }
        
        if(bs.get(5)) {
            //Send Entity Viewport Pitch (Float)
            cba.addData(entity.getViewport());
        }
        
        if(bs.get(6)) {
            //TODO: Add Physics Flag (Unsigned Int)
            cba.addData(Integer.MIN_VALUE + 1);
        }
        
        if(bs.get(7)) {
            //Send Hostile Relation to Player (Unsigned Byte)
            cba.addData(Byte.MIN_VALUE + entity.getHostileLevel(target));
        }
        
        if(bs.get(8)) {
            //Send Entity Type ID (Unsigned Integer)
            cba.addData(Integer.MIN_VALUE - entity.getType().getID());
        }
        
        if(bs.get(9)) {
            //TODO: Add Send Current "Mode" (Unsigned Byte)
            cba.addData(Byte.MIN_VALUE);
        }
        
        return cba;
    }
}
