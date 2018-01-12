package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModMeleeWeapons extends ItemSword {

    private String name;

    private static ToolMaterial getToolMaterial(String name) {
        if (name.equals("tungsten_hammer")) return EnumHelper.addToolMaterial("tungsten_hammer", 1, 512, 4f, 12f, 14);
        else return null;
    }

    public static Item[] itemSet = new Item[]{
            new ModMeleeWeapons(getToolMaterial("tungsten_hammer")).setName("tungsten_hammer")
    };

    public String getName() {
        return name;
    }

    public Item setName(String s) {
        this.name = s;
        this.setRegistryName(s);
        return this.setUnlocalizedName(s);
    }

    public ModMeleeWeapons(ToolMaterial material) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
    }
}
