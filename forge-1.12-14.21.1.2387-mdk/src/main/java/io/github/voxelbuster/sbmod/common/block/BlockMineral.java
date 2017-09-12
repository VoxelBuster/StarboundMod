package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMineral extends Block {
    private String name;

    public BlockMineral(Material material, MaterialVariant variant) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copperblock");
            this.setUnlocalizedName("copperblock");
            this.name = "copperblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solariumblock");
            this.setUnlocalizedName("solariumblock");
            this.name = "solariumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silverblock");
            this.setUnlocalizedName("silverblock");
            this.name = "silverblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titaniumblock");
            this.setUnlocalizedName("titaniumblock");
            this.name = "titaniumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungstenblock");
            this.setUnlocalizedName("tungstenblock");
            this.name = "tungstenblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteelblock");
            this.setUnlocalizedName("durasteelblock");
            this.name = "durasteelblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisaltblock");
            this.setUnlocalizedName("aegisaltblock");
            this.name = "aegisaltblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "feroziumblock");
            this.setUnlocalizedName("feroziumblock");
            this.name = "feroziumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violiumblock");
            this.setUnlocalizedName("violiumblock");
            this.name = "violiumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.URANIUM) {
            this.setRegistryName(StarboundMod.MODID, "uraniumblock");
            this.setUnlocalizedName("uraniumblock");
            this.name = "uraniumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.PLUTONIUM) {
            this.setRegistryName(StarboundMod.MODID, "plutoniumblock");
            this.setUnlocalizedName("plutoniumblock");
            this.name = "plutoniumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.PLATINUM) {
            this.setRegistryName(StarboundMod.MODID, "platinumblock");
            this.setUnlocalizedName("platinumblock");
            this.name = "platinumblock";
            this.setHardness(10.0f);
            this.setResistance(15.0f);
        } else if (variant == MaterialVariant.DIAMOND) {
            this.setRegistryName(StarboundMod.MODID, "flawlessdiablock");
            this.setUnlocalizedName("flawlessdiablock");
            this.name = "flawlessdiablock";
            this.setHardness(15.0f);
            this.setResistance(50.0f);
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericblockmineral");
        }
    }
}
