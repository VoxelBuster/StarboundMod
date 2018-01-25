package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class ModAPI {
    public class PotionIds {
        public static final int SPEED = 1, SLOWNESS = 2, HASTE = 3, MINING_FATUGUE = 4, STRENGTH = 5, HEALING = 6,
                DAMAGE = 7, JUMP_BOOST = 8, NAUSEA = 9, REGENERATION = 10, RESISTANCE = 11, FIRE_RESIST = 12,
                WATER_BREATHING = 13, INVISIBLITY = 14, BLINDNESS = 15, NIGHT_VISION = 16, HUNGER = 17, WEAKNESS = 18,
                POISON = 19, WITHER = 20, HEALTH_BOOST = 21, ABSORPTION = 22, SATURATION = 23, GLOWING = 24,
                LEVITATION = 25, LUCK = 26, BAD_LUCK = 27;
    }

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
