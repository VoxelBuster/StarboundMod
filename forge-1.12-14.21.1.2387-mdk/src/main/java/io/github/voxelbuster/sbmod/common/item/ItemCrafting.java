package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.Item;

public class ItemCrafting extends Item {
    public static Item[] itemSet = {
            new ItemCrafting().setName("upgrade_kit"),
            new ItemCrafting().setName("manipulator_upgrade"),
            new ItemCrafting().setName("tech_card")
    };

    private String name;

    public String getName() {
        return name;
    }

    public Item setName(String s) {
        this.name = s;
        this.setRegistryName(s);
        return this.setUnlocalizedName(s);
    }

    public ItemCrafting() {
        this.setCreativeTab(StarboundMod.creativeTab);
    }
}
