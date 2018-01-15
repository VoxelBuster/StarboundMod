package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class ModStairs extends BlockStairs {
    protected ModStairs(IBlockState modelState, PlatformVariant variant) {
        super(modelState);
        this.setCreativeTab(StarboundMod.creativeTab);
        switch (variant) {
            case OUTPOST:
                this.setUnlocalizedName("outpoststairs").setRegistryName("outpoststairs").setHardness(10f)
                        .setHardness(30f).setHarvestLevel("pickaxe", 1);
                this.useNeighborBrightness = true;
                break;
        }
    }
}
