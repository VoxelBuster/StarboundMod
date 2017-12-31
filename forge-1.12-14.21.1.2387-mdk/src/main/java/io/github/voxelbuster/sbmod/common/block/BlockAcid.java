package io.github.voxelbuster.sbmod.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockAcid extends BlockFluidClassic {
    public BlockAcid(Fluid fluid, Material material) {
        super(fluid, material);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
        if (entityIn instanceof EntityLiving) {
            ((EntityLiving) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(19), 3, 2));
        }
    }
}
