package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class ModAPI {
    public static Set<Block> getEffectiveBlocksForType(String toolType) {
        HashSet<Block> effectiveBlocks = new HashSet<>();
        for (Block b : ForgeRegistries.BLOCKS.getValues()) {
            if (b.isToolEffective(toolType, b.getDefaultState())) {
                effectiveBlocks.add(b);
            }
        }
        return effectiveBlocks;
    }

    public static EnumFacing getNeighborSide(BlockPos pos1, BlockPos neighbor) {
        int deltaz = 0, deltax = 0, deltay = 0;
        if (pos1.getZ() < neighbor.getZ()) {
            deltaz = 1;
        } else if (pos1.getZ() > neighbor.getZ()) {
            deltaz = -1;
        }
        if (pos1.getX() < neighbor.getX()) {
            deltax = 1;
        } else if (pos1.getX() > neighbor.getX()) {
            deltax = -1;
        }
        if (pos1.getY() < neighbor.getY()) {
            deltay = 1;
        } else if (pos1.getY() > pos1.getY()) {
            deltay = -1;
        }

        if (deltaz == 1 && deltax == 0 && deltay == 0) return EnumFacing.SOUTH;
        else if (deltaz == -1 && deltax == 0 && deltay == 0) return EnumFacing.NORTH;
        else if (deltax == 1 && deltaz == 0 && deltay == 0) return EnumFacing.EAST;
        else if (deltax == -1 && deltaz == 0 && deltay == 0) return EnumFacing.WEST;
        else if (deltax == 0 && deltaz == 0 && deltay == 1) return EnumFacing.UP;
        else if (deltax == 0 && deltaz == 0 && deltay == -1) return EnumFacing.DOWN;
        else return null;
    }
}
