package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenAncientGate implements IWorldGenerator {
    public WorldGenAncientGate(){} // This doesn't do anything yet

    public boolean generate(World world, Random rand, BlockPos pos) {
        boolean facingNS = rand.nextBoolean();
        Rotation facing;
        if (facingNS) facing = Rotation.NONE;
        else facing = Rotation.CLOCKWISE_90;
        WorldServer worldServer = (WorldServer) world;
        TemplateManager templateManager = worldServer.getStructureTemplateManager();
        Template gate = templateManager.get(world.getMinecraftServer(), new ResourceLocation(StarboundMod.MODID,"ancientgate"));
        if (gate != null) {
            IBlockState iblockstate = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
            PlacementSettings placementsettings = new PlacementSettings().setMirror(Mirror.NONE)
                    .setRotation(facing).setIgnoreEntities(true).setIgnoreStructureBlock(true);
            int genCheck = rand.nextInt(50);
            if (world.provider.getDimension() == 0 && genCheck == 10 &&
                    (world.getBlockState(pos) == Blocks.GRASS.getDefaultState() || world.getBlockState(pos) == Blocks.DIRT.getDefaultState()) &&
                    world.getBiome(pos).toString().contains("BiomeAncientGarden")) {
                BlockPos correctedPos = new BlockPos(pos.getX(), pos.getY() - 9, pos.getZ());
                gate.addBlocksToWorld(world, correctedPos, placementsettings);
                return true;
            }
        }
        return false;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int y = world.getHeight(chunkX * 16, chunkZ * 16) - 1; // -1 because generally the ancient garden biome has a grass or flower block on top
        this.generate(world, random, new BlockPos(chunkX * 16, y, chunkZ * 16));
    }
}
