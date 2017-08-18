package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.MaterialVariant;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.item.Item;

public class ItemMineral extends ModItem {
    private String name;

    public String getName() {
        return name;
    }

    public ItemMineral(MaterialVariant variant) {
        this.setCreativeTab(StarboundMod.creativeTab);
        if (variant == MaterialVariant.COPPER) {
            this.setRegistryName(StarboundMod.MODID, "copper");
            this.setUnlocalizedName("copper");
            this.name = "copper";
        }
        else if (variant == MaterialVariant.SOLARIUM) {
            this.setRegistryName(StarboundMod.MODID, "solarium");
            this.setUnlocalizedName("solarium");
            this.name = "solarium";
        } else if (variant == MaterialVariant.SILVER) {
            this.setRegistryName(StarboundMod.MODID, "silver");
            this.setUnlocalizedName("silver");
            this.name = "silver";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TITANIUM) {
            this.setRegistryName(StarboundMod.MODID, "titanium");
            this.setUnlocalizedName("titanium");
            this.name = "titanium";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.TUNGSTEN) {
            this.setRegistryName(StarboundMod.MODID, "tungsten");
            this.setUnlocalizedName("tungsten");
            this.name = "tungsten";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.DURASTEEL) {
            this.setRegistryName(StarboundMod.MODID, "durasteel");
            this.setUnlocalizedName("durasteel");
            this.name = "durasteel";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.AEGISALT) {
            this.setRegistryName(StarboundMod.MODID, "aegisalt");
            this.setUnlocalizedName("aegisalt");
            this.name = "aegisalt";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.FEROZIUM) {
            this.setRegistryName(StarboundMod.MODID, "ferozium");
            this.setUnlocalizedName("ferozium");
            this.name = "ferozium";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.VIOLIUM) {
            this.setRegistryName(StarboundMod.MODID, "violium");
            this.setUnlocalizedName("violium");
            this.name = "violium";
            //ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("solarium_star", "inventory"));
        } else if (variant == MaterialVariant.SUPERMATTER) {
            this.setRegistryName(StarboundMod.MODID, "supermatter");
            this.setUnlocalizedName("supermatter");
            this.name = "supermatter";
        } else {
            this.setRegistryName(StarboundMod.MODID, "genericitemmineral");
        }
    }
}
