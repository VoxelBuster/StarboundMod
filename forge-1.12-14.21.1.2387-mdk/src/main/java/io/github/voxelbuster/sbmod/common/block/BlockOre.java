package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;
import io.github.voxelbuster.sbmod.common.util.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOre extends ModBlock {
    private String name;

    public BlockOre(Material material, MaterialVariant variant) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copperoreblock");
            this.setUnlocalizedName("copperoreblock");
            this.name = "copperoreblock";
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solariumoreblock");
            this.setUnlocalizedName("solariumoreblock");
            this.name = "solariumoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silveroreblock");
            this.setUnlocalizedName("silveroreblock");
            this.name = "silveroreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titaniumoreblock");
            this.setUnlocalizedName("titaniumoreblock");
            this.name = "titaniumoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungstenoreblock");
            this.setUnlocalizedName("tungstenoreblock");
            this.name = "tungstenoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteeloreblock");
            this.setUnlocalizedName("durasteeloreblock");
            this.name = "durasteeloreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisaltoreblock");
            this.setUnlocalizedName("aegisaltoreblock");
            this.name = "aegisaltoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "feroziumoreblock");
            this.setUnlocalizedName("feroziumoreblock");
            this.name = "feroziumoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violiumoreblock");
            this.setUnlocalizedName("violiumoreblock");
            this.name = "violiumoreblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericblockore");
        }
    }
}
