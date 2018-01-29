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
import org.lwjgl.Sys;

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

    public ItemManipulator() {
        super(0, 1f,
                EnumHelper.addToolMaterial("manipulator", 1, -1, 5f, 0f, 0),
                effectiveBlocks);
        this.setCreativeTab(StarboundMod.creativeTab).setRegistryName("manipulator").setUnlocalizedName("manipulator");
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
        if (nbt == null) {
            nbt = new NBTTagCompound();
        }
        System.out.println(stack);
        System.out.println(nbt);
        if (!nbt.hasKey("level")) {
            nbt.setInteger("level", 0);
        }
        updateItemStackNBT(nbt);
        stack.setTagCompound(nbt);
        return nbt;
    }

    public void upgrade(ItemStack stack) {
        NBTTagCompound nbt = stack.getItem().getNBTShareTag(stack);
        nbt.setInteger("level", nbt.getInteger("level") + 1);
        level++;
        updateItemStackNBT(nbt);
        stack.setTagCompound(nbt);
    }
}
