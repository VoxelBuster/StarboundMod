package io.github.voxelbuster.sbmod.common.item;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.ModAPI;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class ItemManipulator extends ItemTool {
    public static final Set<Block> effectiveBlocks = new HashSet<>();

    public int level = 0;

    static {
        effectiveBlocks.addAll(ModAPI.getEffectiveBlocksForType("pickaxe"));
        effectiveBlocks.addAll(ModAPI.getEffectiveBlocksForType("axe"));
        effectiveBlocks.addAll(ModAPI.getEffectiveBlocksForType("spade"));
        effectiveBlocks.add(Blocks.WEB);
        effectiveBlocks.add(Blocks.LEAVES);
    }

    protected ItemManipulator(Set<Block> effectiveBlocksIn) {
        super(0, 1f,
                EnumHelper.addToolMaterial("manipulator", 1, -1, 5f, 0f, 0),
                effectiveBlocks);
        this.setCreativeTab(StarboundMod.creativeTab).setRegistryName("manipulator").setUnlocalizedName("mainpulator");
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        this.setHarvestLevel("pickaxe", level + 1);
        this.setHarvestLevel("axe", level + 1);
        this.setHarvestLevel("spade", level + 1);
        this.efficiencyOnProperMaterial = 5f * (level + 1f);
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    public static int modulesNeededForUpgrade(ItemStack stack) {
        return (int) (8 * Math.pow(2, stack.getItem().getNBTShareTag(stack).getInteger("level")));
    }

    @Nullable
    @Override
    public NBTTagCompound getNBTShareTag(ItemStack stack) {
        NBTTagCompound nbt = super.getNBTShareTag(stack);
        nbt.setInteger("level", 0);
        return super.getNBTShareTag(stack);
    }

    public void upgrade(ItemStack stack) {
        NBTTagCompound nbt = stack.getItem().getNBTShareTag(stack);
        nbt.setInteger("level", nbt.getInteger("level") + 1);
        level++;
        stack.getItem().updateItemStackNBT(nbt);
    }
}
