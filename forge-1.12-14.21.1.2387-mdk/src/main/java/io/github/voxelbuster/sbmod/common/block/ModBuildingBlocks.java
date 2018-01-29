package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class ModBuildingBlocks {
    public static ArrayList<Block> blockSet = new ArrayList<>();
    public static Block ancientstone, gateportal;

    public static void addAll() {
        blockSet.add(new ModBlock(Material.ROCK, "metoriteblock").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.ROCK, "ancientstone").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new CoreCrystal());
        blockSet.add(new GatePortalBlock());
        blockSet.add(new ModBlock(Material.ROCK, "ancientbrick").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.IRON, "outpostpanel").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.IRON, "outpostpillar").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new ModBlock(Material.IRON, "outpostsupport").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab));
        blockSet.add(new OutpostLamp());
        blockSet.add(new ModBlock(Material.GLASS, "outpostlight").setHardness(10f).setResistance(30f).setCreativeTab(StarboundMod.creativeTab)
                .setLightLevel(1f));

        for (PlatformVariant variant : PlatformVariant.values()) {
            blockSet.add(new ModHalfSlab(variant, Material.ROCK));
            blockSet.add(new ModDoubleSlab(variant, Material.ROCK));
            blockSet.add(new ModStairs(blockSet.get(7).getDefaultState(), variant));
        }

        for (ModDoor.DoorVariant variant : ModDoor.DoorVariant.values()) {
            blockSet.add(new ModDoor(Material.IRON, variant));
        }

        ancientstone = blockSet.get(1);
        gateportal = blockSet.get(3);
    }
}
