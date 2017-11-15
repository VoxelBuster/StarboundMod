package io.github.voxelbuster.sbmod.common.world.teleporter;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterGeneric extends Teleporter {
    private final World targetWorld;

    public TeleporterGeneric(WorldServer worldServer) {
        super(worldServer);
        this.targetWorld = worldServer;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        entityIn.setLocationAndAngles(0, 70, 0, rotationYaw, 0);
    }
}
