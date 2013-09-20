package org.owller.CubeWorld.Server.Network.Packet.Server;

import org.owller.CubeWorld.Entity.CubeEntity;
import org.owller.CubeWorld.Server.Network.Packet.CubePacket;
import org.owller.CubeWorld.Server.Network.Packet.CubePacketType;
import org.owller.CubeWorld.World.CubeWorld;

public class CubeWorldSeedPacket extends CubePacketType {
    public CubeWorldSeedPacket() {
        super((byte) 15, "World Seed");
    }

    public CubePacket makePacket(CubeEntity entity) {
        return makePacket(entity.getWorld());
    }
    
    public CubePacket makePacket(CubeWorld world) {
        CubePacket p = new CubePacket(CubePacketType.MAP_SEED);
        p.getData().addInt(world.getSeed());
        return p;
    }
}
