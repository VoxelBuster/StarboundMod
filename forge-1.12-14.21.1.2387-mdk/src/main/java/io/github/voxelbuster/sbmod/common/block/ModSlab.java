package io.github.voxelbuster.sbmod.common.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ModSlab extends BlockSlab {
    protected ModSlab(Material material) {
        super(material);
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return getUnlocalizedName();
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumBlockHalf.BOTTOM;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (!this.isDouble()) {
            return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        } else {
            return this.getDefaultState();
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if (!this.isDouble()) {
            return 0;
        } else {
            return state.getValue(HALF).ordinal() + 1;
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HALF);
    }
}
