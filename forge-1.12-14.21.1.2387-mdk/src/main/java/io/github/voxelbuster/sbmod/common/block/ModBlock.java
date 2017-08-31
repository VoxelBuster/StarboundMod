package io.github.voxelbuster.sbmod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModBlock extends Block {
    private String name;

    public ModBlock(Material materialIn, String name) {
        super(materialIn);
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
