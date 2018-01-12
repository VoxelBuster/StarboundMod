package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
