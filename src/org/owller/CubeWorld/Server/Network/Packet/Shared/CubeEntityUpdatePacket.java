package org.owller.CubeWorld.Server.Network.Packet.Shared;

import java.util.BitSet;
import org.owller.CubeWorld.Arrays.CubeByteArray;
import org.owller.CubeWorld.Entity.CubeEntity;
import org.owller.CubeWorld.World.CubeVector;

public class CubeEntityUpdatePacket {
    public static CubeByteArray makeEntityUpdateByteArray(CubeEntity entity) {
        BitSet bs = new BitSet(64);
        bs.set(0, 64, false);
        bs.set(0, 16, true);
        return makeEntityUpdateByteArray(entity, bs, null);
    }
    
    public static CubeByteArray makeEntityUpdateByteArray(CubeEntity entity, BitSet bs, CubeEntity target) {
        CubeByteArray cba = new CubeByteArray();
        
        cba.addLong(entity.getID());
        
        cba.addBitSet(bs);
        
        //Now Add
        if(bs.get(0)) {
            //Send Location (Long Vector)
            cba.addLong(entity.getLocation().getLongX());
            cba.addLong(entity.getLocation().getLongY());
            cba.addLong(entity.getLocation().getLongZ());
        }
        
        if(bs.get(1)) {
            //Send Orientation (3*Float)
            cba.addFloat(entity.getLocation().getFloatRoll());
            cba.addFloat(entity.getLocation().getFloatPitch());
            cba.addFloat(entity.getLocation().getFloatYaw());
        }
        
        if(bs.get(2)) {
            //Send Velocity (Float Vector)
            cba.addFloat(entity.getVelocity().getFloatX());
            cba.addFloat(entity.getVelocity().getFloatY());
            cba.addFloat(entity.getVelocity().getFloatZ());
        }
        
        if(bs.get(3)) {
            //Send Acceleration (Float Vector)
            cba.addFloat(entity.getAcceleration().getFloatX());
            cba.addFloat(entity.getAcceleration().getFloatY());
            cba.addFloat(entity.getAcceleration().getFloatZ());
        }
        
        if(bs.get(4)) {
            //Send Alter Velocity(?) (Float Vector)
            cba.addFloat(entity.getAlterVelocity().getFloatX());
            cba.addFloat(entity.getAlterVelocity().getFloatY());
            cba.addFloat(entity.getAlterVelocity().getFloatZ());
        }
        
        if(bs.get(5)) {
            //Send Entity Viewport Pitch(?) (Float)
            cba.addFloat(entity.getViewport());
        }
        
        if(bs.get(6)) {
            //TODO: Add Physics Flag(?) (Unsigned Int)
            cba.addInt(Integer.MIN_VALUE + 1);
        }
        
        if(bs.get(7)) {
            //Send Hostile Relation to Player (Unsigned Byte)
            cba.addByte((byte) (Byte.MIN_VALUE + entity.getHostileLevel(target)));
        }
        
        if(bs.get(8)) {
            //Send Entity Type ID (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE - entity.getType().getID());
        }
        
        if(bs.get(9)) {
            //TODO: Add Send Current "Mode" (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(10)) {
            //TODO: Add Mode Start Type (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(11)) {
            //TODO: Add Hit Counter (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(12)) {
            //TODO: Add Last Hit Time (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(13)) {
            //TODO: Add Send Appearance (Struct)
            cba.addData(new byte[1327185]);
        }
        
        if(bs.get(14)) {
            //TODO: Add Entity Flags (Unsigned Byte)*2
            cba.addByte(Byte.MIN_VALUE);
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(15)) {
            //TODO: Add Last Roll Time (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(16)) {
            //TODO: Add Stun Time (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(17)) {
            //TODO: Add Speed Time(?) (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(18)) {
            //TODO: Add Make Blue Time(?) (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(19)) {
            //TODO: Add Speed Up Time(?) (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(20)) {
            //TODO: Add Show Patch Time(?) (Float)
            cba.addFloat(0L);
        }
        
        if(bs.get(21)) {
            //TODO: Add Class Type (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(22)) {
            //TODO: Add Specialization(?) (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(23)) {
            //TODO: Add Charged MP(?) (Float)
            cba.addFloat(0.0f);
        }
        
        if(bs.get(24)) {
            //Send Unused Value (Unsigned Integer)*3
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(25)) {
            //Send Unused Value (Unsigned Integer)*3
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(26)) {
            //TODO: Add Ray Hit (Float Vector)
            CubeVector v = new CubeVector();
            cba.addFloat(v.getFloatX());
            cba.addFloat(v.getFloatY());
            cba.addFloat(v.getFloatZ());
        }
        
        if(bs.get(27)) {
            //Send HP (Float)
            cba.addFloat(entity.getHealth());
        }
        
        if(bs.get(28)) {
            //Send MP (Float)
            cba.addFloat(entity.getMana());
        }
        
        if(bs.get(29)) {
            //TODO: Add Block Power(?) (Float)
            cba.addFloat(0.0f);
        }
        
        if(bs.get(30)) {
            //TODO: Add Send Multipliers (Float)*5
            //Max HP, Shoot Speed, Damage, Armor, Resistance
            cba.addFloat(0.0f);
            cba.addFloat(0.0f);
            cba.addFloat(0.0f);
            cba.addFloat(0.0f);
            cba.addFloat(0.0f);
        }
        
        if(bs.get(31)) {
            //Send Unused (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(32)) {
            //Send Unused (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(33)) {
            //Send Level (Unsigned Integer);
            cba.addInt(Integer.MIN_VALUE - entity.getLevel());
        }
        
        if(bs.get(34)) {
            //Send Current XP (Unsigned Integer);
            cba.addInt(Integer.MIN_VALUE - entity.getXP());
        }
        
        if(bs.get(35)) {
            //TODO: Add Send Owner Entity ID(FOR PETS) (Unsigned Long)
            cba.addLong(0L);
        }
        
        if(bs.get(36)) {
            //Two Unused ints(?) (Unsigned Integer)*2
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(37)) {
            //TODO: Add Power Base(?) (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(38)) {
            //Add Unused Integer(?) (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(39)) {
            //Add Unused Integer(?) (Unsigned Integer)*3
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(40)) {
            //TODO: Add Spawn Location (Long Vector)
            cba.addLong(0L);
            cba.addLong(0L);
            cba.addLong(0L);
        }
        
        if(bs.get(41)) {
            //Unused Integer(?) (Unsigned Integer)*3
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(42)) {
            //Add Unused Byte(?) (Unsigned Byte)
            cba.addByte(Byte.MIN_VALUE);
        }
        
        if(bs.get(43)) {
            //TODO: Add Consumables (Struct)
           cba.addData(new byte[1220]);
        }
        
        if(bs.get(44)) {
            //TODO: Add Equipment (Struct)
            cba.addData(new byte[15860]);
        }
        
        if(bs.get(45)) {
            //TODO: Write Entity Name (Unsigned Char)*12
            String name = "123456789012";
            cba.addString(name);
        }
        
        if(bs.get(46)) {
            //TODO: Add Skills (Unsigned Int)*12
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
            cba.addInt(Integer.MIN_VALUE);
        }
        
        if(bs.get(47)) {
            //Add Mana Cubes(?) (Unsigned Integer)
            cba.addInt(Integer.MIN_VALUE);
        }
        
        return cba;
    }
}
