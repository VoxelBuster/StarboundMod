package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
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

    /**
     * Method credit to MaxTheMooshroom
     *
     * @param player
     * @param worldIn
     * @param pos
     * @param hand
     * @param facing
     * @param hitX
     * @param hitY
     * @param hitZ
     * @return
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == Blocks.JUKEBOX && !((Boolean) iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue()) {

            ItemStack itemstack = player.getHeldItem(hand);
            ((BlockJukebox) Blocks.JUKEBOX).insertRecord(worldIn, pos, iblockstate, itemstack);
            worldIn.playRecord(pos, sound); // TODO fix playing sound idk why it isnt playing
            itemstack.shrink(1);
            player.addStat(StatList.RECORD_PLAYED);

            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.PASS;
        }
    }
}
