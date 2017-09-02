package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.block.ModFluids;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOilPool implements IWorldGenerator {
    private WorldGenLakes oilPool;

    public WorldGenOilPool() {
        this.oilPool = new WorldGenLakes(ModFluids.oilblock);
    }

    private void runGenerator(Random random, WorldGenerator generator, World world, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            if (random.nextInt(15) != 8) return;
            if (world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.DESERT ||
                    world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.JUNGLE ||
                    world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.MUTATED_DESERT ||
                    world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.BEACH ||
                    world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.PLAINS ||
                    world.getBiome(new BlockPos(chunk_X * 16, 64, chunk_Z * 16)) == Biomes.MESA) {
                int x = chunk_X * 16 + random.nextInt(16);
                int y = minHeight + random.nextInt(heightDiff);
                int z = chunk_Z * 16 + random.nextInt(16);
                generator.generate(world, random, new BlockPos(x, y, z));
            }
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                this.runGenerator(random, oilPool, world, chunkX, chunkZ, 1, 40, 90);
                break;
            case -1: //Nether
                break;
            case 1: //End
                break;
        }
    }
}
