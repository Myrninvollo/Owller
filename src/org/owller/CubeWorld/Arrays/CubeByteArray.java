package org.owller.CubeWorld.Arrays;

import java.nio.ByteBuffer;
import java.util.BitSet;

public class CubeByteArray {
    byte[] array;
    
    public CubeByteArray() {
        this(new byte[0]);
    }
    
    public CubeByteArray(byte[] array) {
        this.array = array;
    }
    
    public byte[] getByteArray() {
        return this.array;
    }
    
    public void addData(byte[] data) {
        byte[] newData = new byte[this.array.length + data.length];
        System.arraycopy(this.array, 0, newData, 0, this.array.length);
        System.arraycopy(data, 0, newData, this.array.length, data.length);
        
        this.array = newData;
    }

    public void addData(int i) {
        this.addData(ByteBuffer.allocate(4).putInt(i).array());
    }
    
    public void addData(long l) {
        this.addData(ByteBuffer.allocate(8).putLong(l).array());
    }
    
    public void addData(float f) {
        this.addData(ByteBuffer.allocate(4).putFloat(f).array());
    }
    
    public void addData(CubeByteArray a) {
        this.addData(a.getByteArray());
    }
    
    public void addData(BitSet bits) {
        long value = 0L;
        for (int i = 0; i < bits.length(); ++i) {
          value += bits.get(i) ? (1L << i) : 0L;
        }
        
        System.out.println("Adding " + value);
        
        this.addData(value);
    }
}
