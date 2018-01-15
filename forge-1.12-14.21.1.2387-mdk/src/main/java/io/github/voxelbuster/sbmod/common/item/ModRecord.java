package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class ModRecord extends ItemRecord {
    private final SoundEvent sound; // Add game music items

    public ModRecord(String name, SoundEvent sound) {
        super(name, sound);
        this.sound = sound;
        this.setCreativeTab(StarboundMod.creativeTab);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.maxStackSize = 1;

    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }
}
