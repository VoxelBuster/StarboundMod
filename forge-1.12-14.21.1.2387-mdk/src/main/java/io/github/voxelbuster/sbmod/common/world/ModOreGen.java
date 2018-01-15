package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModOreGen implements IWorldGenerator {
    private WorldGenerator genCopperOre;
    private WorldGenerator genSilverOre;
    private WorldGenerator genTungstenOre;
    private WorldGenerator genTitaniumOre;
    private WorldGenerator genUraniumOre;
    private WorldGenerator genPlutoniumOre;
    private WorldGenerator genPlatinumOre;
    private WorldGenerator genCoreFragment;

    public ModOreGen() {
        this.genCopperOre = new WorldGenMinable(RegisterUtil.ore_block_copper.getDefaultState(), 12);
        this.genSilverOre = new WorldGenMinable(RegisterUtil.ore_block_silver.getDefaultState(), 10);
        this.genTitaniumOre = new WorldGenMinable(RegisterUtil.ore_block_titanium.getDefaultState(), 16);
        this.genTungstenOre = new WorldGenMinable(RegisterUtil.ore_block_tungsten.getDefaultState(), 8);
        this.genUraniumOre = new WorldGenMinable(RegisterUtil.ore_block_uranium.getDefaultState(), 12);
        this.genPlutoniumOre = new WorldGenMinable(RegisterUtil.ore_block_plutonium.getDefaultState(), 12);
        this.genPlatinumOre = new WorldGenMinable(RegisterUtil.ore_block_platinum.getDefaultState(), 8);
        this.genCoreFragment = new WorldGenMinable(RegisterUtil.ore_block_corefragment.getDefaultState(), 24);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                this.runGenerator(random, genCopperOre, world, chunkX, chunkZ, 2, 5, 60);
                this.runGenerator(random, genSilverOre, world, chunkX, chunkZ, 2, 5, 40);
                this.runGenerator(random, genTitaniumOre, world, chunkX, chunkZ, 4, 5, 70);
                this.runGenerator(random, genTungstenOre, world, chunkX, chunkZ, 1, 5, 20);
                this.runGenerator(random, genUraniumOre, world, chunkX, chunkZ, 2, 0, 40);
                this.runGenerator(random, genPlutoniumOre, world, chunkX, chunkZ, 2, 0, 30);
                this.runGenerator(random, genPlatinumOre, world, chunkX, chunkZ, 1, 5, 20);
                this.runGenerator(random, genCoreFragment, world, chunkX, chunkZ, 1, 0, 12);
                break;
            case -1: //Nether

                break;
            case 1: //End

                break;
        }
    }

    private void runGenerator(Random random, WorldGenerator generator, World world, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDiff);
            int z = chunk_Z * 16 + random.nextInt(16);
            generator.generate(world, random, new BlockPos(x, y, z));
        }
    }
}