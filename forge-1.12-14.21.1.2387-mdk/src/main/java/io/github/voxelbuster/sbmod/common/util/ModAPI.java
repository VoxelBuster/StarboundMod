package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.block.Block;
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
}
