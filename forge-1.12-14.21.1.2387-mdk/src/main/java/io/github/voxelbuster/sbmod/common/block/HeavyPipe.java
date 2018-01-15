package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class HeavyPipe extends ModBlock {
    private static final int NORMAL = 0, CORNER = 1, T = 2, QUAD = 3;

    private static IProperty<EnumFacing> facing = PropertyEnum.create("facing", EnumFacing.class);
    public static final IProperty<Integer> variant = PropertyInteger.create("variant", 0, 3);

    public HeavyPipe() {
        super(Material.IRON, "heavypipe");
        this.setUnlocalizedName("heavypipe").setRegistryName("heavypipe").setHardness(10f).setResistance(30f)
                .setCreativeTab(StarboundMod.creativeTab).setHarvestLevel("pickaxe", 1);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, variant, facing);
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(final int meta) {
        return getDefaultState().withProperty(variant, meta).withProperty(facing, EnumFacing.NORTH);
    }

    @Override
    public int getMetaFromState(final IBlockState state) {
        return state.getValue(variant);
    }

    @Override
    public int damageDropped(final IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        for (int i = 0; i <= 3; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    public static IProperty<EnumFacing> getFacing() {
        return facing;
    }

    public static void setFacing(IProperty<EnumFacing> facing) {
        HeavyPipe.facing = facing;
    }
}
