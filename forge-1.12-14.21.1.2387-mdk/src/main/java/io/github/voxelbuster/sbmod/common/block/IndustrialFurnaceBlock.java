package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.util.ModBlock;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * Created by galen on 8/28/2017.
 */
public class IndustrialFurnaceBlock extends ModBlock {
    public IndustrialFurnaceBlock(Material materialIn) {
         super(materialIn);
         this.setCreativeTab(StarboundMod.creativeTab);
         this.setRegistryName("industrialfurnace");
         this.setUnlocalizedName("industrialfurnace");
         this.setHarvestLevel("pickaxe", 1);
         this.setHardness(10f);
         this.setResistance(30f);
         this.setLightLevel((float) 7 / 15);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

}
