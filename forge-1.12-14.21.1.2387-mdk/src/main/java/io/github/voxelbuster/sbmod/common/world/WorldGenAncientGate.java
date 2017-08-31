package io.github.voxelbuster.sbmod.common.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

import java.util.Random;

public class WorldGenAncientGate extends WorldGenDesertWells {
    public WorldGenAncientGate() {
        super();
    }

    public boolean generate(World world, Random rand, BlockPos pos) {
        return false;
    }
}
