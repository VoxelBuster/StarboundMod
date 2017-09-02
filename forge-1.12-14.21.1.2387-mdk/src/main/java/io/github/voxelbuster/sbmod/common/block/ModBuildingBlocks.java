package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.core.Core;

import java.util.ArrayList;

public class ModBuildingBlocks {
    public static ArrayList<Block> blockSet = new ArrayList<>();
    public static Block ancientstone, gateportal, meteoriteblock, ancientbrick;
    public static CoreCrystal corecrystal;

    public static void addAll() {
        blockSet.add(new ModBlock(Material.ROCK, "metoriteblock").setHardness(10f).setResistance(30f).setUnlocalizedName("meteoriteblock")
        .setRegistryName(new ResourceLocation(StarboundMod.MODID, "meteoriteblock")).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.ROCK, "ancientstone").setHardness(10f).setResistance(30f).setUnlocalizedName("ancientstone")
                .setRegistryName(new ResourceLocation(StarboundMod.MODID, "ancientstone")).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new CoreCrystal());
        blockSet.add(new GatePortalBlock());
        blockSet.add(new ModBlock(Material.ROCK, "ancientbrick").setHardness(10f).setResistance(30f).setUnlocalizedName("ancientbrick")
                .setRegistryName(new ResourceLocation(StarboundMod.MODID, "ancientbrick")).setCreativeTab(StarboundMod.creativeTab));

        meteoriteblock = blockSet.get(0);
        ancientstone = blockSet.get(1);
        corecrystal = (CoreCrystal) blockSet.get(2);
        gateportal = blockSet.get(3);
        ancientbrick = blockSet.get(4);
    }
}
