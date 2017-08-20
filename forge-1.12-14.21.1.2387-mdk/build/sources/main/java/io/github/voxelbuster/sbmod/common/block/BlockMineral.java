package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;
import io.github.voxelbuster.sbmod.common.util.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMineral extends ModBlock {
    private String name;

    public BlockMineral(Material material, MaterialVariant variant) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copperblock");
            this.setUnlocalizedName("copperblock");
            this.name = "copperblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("copper_bar", "inventory"));
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solariumblock");
            this.setUnlocalizedName("solariumblock");
            this.name = "solariumblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silverblock");
            this.setUnlocalizedName("silverblock");
            this.name = "silverblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titaniumblock");
            this.setUnlocalizedName("titaniumblock");
            this.name = "titaniumblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungstenblock");
            this.setUnlocalizedName("tungstenblock");
            this.name = "tungstenblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteelblock");
            this.setUnlocalizedName("durasteelblock");
            this.name = "durasteelblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisaltblock");
            this.setUnlocalizedName("aegisaltblock");
            this.name = "aegisaltblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "feroziumblock");
            this.setUnlocalizedName("feroziumblock");
            this.name = "feroziumblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violiumblock");
            this.setUnlocalizedName("violiumblock");
            this.name = "violiumblock";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericblockmineral");
        }
    }
}
