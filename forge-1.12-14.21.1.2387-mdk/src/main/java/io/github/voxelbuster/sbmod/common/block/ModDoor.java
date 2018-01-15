package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModDoor extends BlockDoor {

    enum DoorVariant {
        OUTPOST
    }

    protected ModDoor(Material materialIn, DoorVariant variant) {
        super(materialIn);
        this.setCreativeTab(StarboundMod.creativeTab);
        switch (variant) {
            case OUTPOST:
                this.setUnlocalizedName("outpostdoor").setRegistryName("outpostdoor").setHardness(10f)
                        .setHardness(30f).setHarvestLevel("pickaxe", 1);
                this.useNeighborBrightness = true;
                break;
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        EnumFacing direction = placer.getAdjustedHorizontalFacing();
        worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, direction).withProperty(HALF, EnumDoorHalf.LOWER).withProperty(OPEN, false));
        worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(FACING, direction).withProperty(HALF,EnumDoorHalf.UPPER).withProperty(OPEN, false));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.getBlockState(pos).getValue(HALF) == EnumDoorHalf.LOWER) {
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).cycleProperty(OPEN));
            worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos.up()).cycleProperty(OPEN));
        } else {
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).cycleProperty(OPEN));
            worldIn.setBlockState(pos.down(), worldIn.getBlockState(pos.down()).cycleProperty(OPEN));
        }
        return true;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (!isOpen(source, pos)) {
            return FULL_BLOCK_AABB;
        } else {
            return super.getBoundingBox(state, source, pos);
        }
    }
}
