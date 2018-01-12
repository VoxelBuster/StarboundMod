package io.github.voxelbuster.sbmod.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockHealingWater extends BlockFluidClassic {
    public BlockHealingWater(Fluid fluid, Material material) {
        super(fluid, material);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {
            EntityLivingBase ent = (EntityLivingBase) entityIn;
            if (!ent.isPotionActive(Potion.getPotionById(10))) {
                ent.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 90, 1));
            }
        }
    }
}
