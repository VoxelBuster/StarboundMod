package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;

public class ItemOre extends ModItem {
    private String name;

    public String getName() {
        return name;
    }

    public ItemOre(MaterialVariant variant) {
        this.setCreativeTab(StarboundMod.creativeTab);
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copperore");
            this.setUnlocalizedName("copperore");
            this.name = "copperore";
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solariumore");
            this.setUnlocalizedName("solariumore");
            this.name = "solariumore";
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silverore");
            this.setUnlocalizedName("silverore");
            this.name = "silverore";
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titaniumore");
            this.setUnlocalizedName("titaniumore");
            this.name = "titaniumore";
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungstenore");
            this.setUnlocalizedName("tungstenore");
            this.name = "tungstenore";
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteelore");
            this.setUnlocalizedName("durasteelore");
            this.name = "durasteelore";
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisaltore");
            this.setUnlocalizedName("aegisaltore");
            this.name = "aegisaltore";
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "feroziumore");
            this.setUnlocalizedName("feroziumore");
            this.name = "feroziumore";
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violiumore");
            this.setUnlocalizedName("violiumore");
            this.name = "violiumore";
        } else if (variant == MaterialVariant.COREFRAGMENT) {
            this.setRegistryName(StarboundMod.MODID, "corefragmentore");
            this.setUnlocalizedName("corefragmentore");
            this.name = "corefragmentore";
        } else if (variant == MaterialVariant.URANIUM) {
            this.setRegistryName(StarboundMod.MODID, "uraniumore");
            this.setUnlocalizedName("uraniumore");
            this.name = "uraniumore";
        } else if (variant == MaterialVariant.PLUTONIUM) {
            this.setRegistryName(StarboundMod.MODID, "plutoniumore");
            this.setUnlocalizedName("plutoniumore");
            this.name = "plutoniumore";
        } else if (variant == MaterialVariant.PLATINUM) {
            this.setRegistryName(StarboundMod.MODID, "platinumore");
            this.setUnlocalizedName("platinumore");
            this.name = "platinumore";
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericitemore");
        }
    }
}
