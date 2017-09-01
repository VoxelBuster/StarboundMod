package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.block.ModFluids;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOilPool extends WorldGenLakes implements IWorldGenerator{
    public WorldGenOilPool() {
        super(ModFluids.oilblock);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.getBiome(new BlockPos(chunkX * 16,64 , chunkZ * 16)) == Biomes.DESERT || world.getBiome(new BlockPos(chunkX * 16, 64, chunkZ * 16)) == Biomes.MUTATED_DESERT
             || world.getBiome(new BlockPos(chunkX * 16, 64, chunkZ * 16)) == Biomes.JUNGLE  || world.getBiome(new BlockPos(chunkX * 16, 64, chunkZ * 16)) == Biomes.PLAINS) {
            if (random.nextInt(40) == 25) super.generate(world, random, new BlockPos(chunkX * 16 - random.nextInt(16), random.nextInt(90), chunkZ * 16 - random.nextInt(16)));
        }
    }
}
