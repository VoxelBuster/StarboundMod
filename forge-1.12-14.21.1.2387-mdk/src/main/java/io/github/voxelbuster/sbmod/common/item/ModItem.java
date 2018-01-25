package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.Item;

public abstract class ModItem extends Item {
    private String name;

    public ModItem(String name) {
        setName(name);
        defaultInit();
    }

    public ModItem() {
        defaultInit();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void defaultInit() {
        setCreativeTab(StarboundMod.creativeTab);
        setMaxStackSize(64);
    }
}
