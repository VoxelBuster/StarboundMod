package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;

public class ItemPixel extends ModItem {
    private String name;

    public String getName() {
        return name;
    }

    public ItemPixel() {
        this.name = "pixel";
        this.setRegistryName("pixel");
        this.setUnlocalizedName("pixel");
        this.setCreativeTab(StarboundMod.creativeTab);
    }
}
