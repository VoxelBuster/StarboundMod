package io.github.voxelbuster.sbmod.common.world;

import net.minecraft.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;

public class OutpostDimension extends World {

    protected OutpostDimension(WorldInfo info, Profiler profilerIn) {
        super(null, info, new WorldProviderOutpost(), profilerIn, true);
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
}
