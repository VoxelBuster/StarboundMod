package io.github.voxelbuster.sbmod.common;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StarboundModCreativeTab extends CreativeTabs {

    public StarboundModCreativeTab() {
        super(StarboundMod.MODID);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.NETHER_STAR);
    }
}
