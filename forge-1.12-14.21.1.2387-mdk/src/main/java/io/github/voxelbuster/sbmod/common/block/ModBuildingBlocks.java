package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class ModBuildingBlocks {
    public static ArrayList<Block> blockSet = new ArrayList<>();
    public static Block ancientstone;
    public static Block gateportal;

    public static void addAll() {
        blockSet.add(new ModBlock(Material.ROCK, "metoriteblock").setHardness(10f).setResistance(30f).setUnlocalizedName("meteoriteblock")
        .setRegistryName(new ResourceLocation(StarboundMod.MODID, "meteoriteblock")).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.ROCK, "ancientstone").setHardness(10f).setResistance(30f).setUnlocalizedName("ancientstone")
                .setRegistryName(new ResourceLocation(StarboundMod.MODID, "ancientstone")).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new CoreCrystal());
        blockSet.add(new GatePortalBlock());

        ancientstone = blockSet.get(1);
        gateportal = blockSet.get(3);
    }
}
