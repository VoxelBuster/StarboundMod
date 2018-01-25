package io.github.voxelbuster.sbmod.common.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;

public class ShipDimension extends World {
    protected ShipDimension(WorldInfo info, Profiler profilerIn) {
        super(null, info, new WorldProviderShipWorld(), profilerIn, true);
        this.chunkProvider = this.createChunkProvider();
    }

    @Override
    protected IChunkProvider createChunkProvider() {
        return new ChunkProviderVoid(this);
    }

    @Override
    protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
        return false;
    }

    @Override
    public void onEntityAdded(Entity entity) {
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).setGameType(GameType.ADVENTURE);
            entity.move(null, 0, 10, 0);
        }
    }

    @Override
    public void onEntityRemoved(Entity entity) {
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).setGameType(GameType.SURVIVAL);
        }
    }
}
