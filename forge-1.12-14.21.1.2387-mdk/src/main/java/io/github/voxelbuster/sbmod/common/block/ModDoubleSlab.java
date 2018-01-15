package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.material.Material;

public class ModDoubleSlab extends ModSlab {
    protected ModDoubleSlab(PlatformVariant variant, Material material) {
        super(material);
        this.setCreativeTab(StarboundMod.creativeTab);
        switch (variant) {
            case OUTPOST:
                this.setUnlocalizedName("outpostdoubleslab").setRegistryName("outpostdoubleslab").setHardness(10f)
                        .setHardness(30f).setHarvestLevel("pickaxe", 1);
                break;
        }
    }

    @Override
    public boolean isDouble() {
        return true;
    }
}
