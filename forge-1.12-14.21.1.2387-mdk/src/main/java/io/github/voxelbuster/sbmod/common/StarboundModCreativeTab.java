package io.github.voxelbuster.sbmod.common;


import io.github.voxelbuster.sbmod.common.block.ModFluids;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StarboundModCreativeTab extends CreativeTabs {

    public StarboundModCreativeTab() {
        super(StarboundMod.MODID);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RegisterUtil.supermatter);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> p_78018_1_) {
        p_78018_1_.add(UniversalBucket.getFilledBucket(new UniversalBucket(), ModFluids.acid));
        p_78018_1_.add(UniversalBucket.getFilledBucket(new UniversalBucket(), ModFluids.erichiusfuel));
        p_78018_1_.add(UniversalBucket.getFilledBucket(new UniversalBucket(), ModFluids.oil));
        p_78018_1_.add(UniversalBucket.getFilledBucket(new UniversalBucket(), ModFluids.healingwater));
        super.displayAllRelevantItems(p_78018_1_);
    }
}
