package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by galen on 8/18/2017.
 */
public abstract class ModBlock extends Block {
    private String name;

    public ModBlock(Material materialIn) {
        super(materialIn);
    }

    public String getName() {
        return name;
    }


}
