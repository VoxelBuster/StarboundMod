package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends Block {
    private MaterialVariant materialVariant;
    private Item dropItem;

    public BlockOre(Material material, MaterialVariant variant) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        this.materialVariant = variant;
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copperoreblock");
            this.setUnlocalizedName("copperoreblock");
            this.setHarvestLevel("pickaxe", 1);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.copper_ore;
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solariumoreblock");
            this.setUnlocalizedName("solariumoreblock");
            this.setHarvestLevel("pickaxe", 3);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.solarium_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silveroreblock");
            this.setUnlocalizedName("silveroreblock");
            this.setHarvestLevel("pickaxe", 1);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.silver_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titaniumoreblock");
            this.setUnlocalizedName("titaniumoreblock");
            this.setHarvestLevel("pickaxe", 2);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.titanium_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungstenoreblock");
            this.setUnlocalizedName("tungstenoreblock");
            this.setHarvestLevel("pickaxe", 2);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteeloreblock");
            this.setUnlocalizedName("durasteeloreblock");
            this.setHarvestLevel("pickaxe", 2);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.durasteel_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisaltoreblock");
            this.setUnlocalizedName("aegisaltoreblock");
            this.setHarvestLevel("pickaxe", 3);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.aegisalt_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "feroziumoreblock");
            this.setUnlocalizedName("feroziumoreblock");
            this.setHarvestLevel("pickaxe", 3);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.ferozium_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violiumoreblock");
            this.setUnlocalizedName("violiumoreblock");
            this.setHarvestLevel("pickaxe", 3);
            this.setHardness(10.0f);
            this.setResistance(15.0f);
            this.dropItem = RegisterUtil.violium_ore;
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericblockore");
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return dropItem;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return random.nextInt(3 + fortune);
    }
}
