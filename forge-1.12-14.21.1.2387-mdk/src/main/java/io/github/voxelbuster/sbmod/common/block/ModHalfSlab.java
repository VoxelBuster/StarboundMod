package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.material.Material;

public class ModHalfSlab extends ModSlab {
    protected ModHalfSlab(PlatformVariant variant, Material material) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        switch (variant) {
            case OUTPOST:
                this.setUnlocalizedName("outpostslab").setRegistryName("outpostslab").setHardness(10f)
                        .setHardness(30f).setHarvestLevel("pickaxe", 1);
                break;
        }
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
