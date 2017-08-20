package io.github.voxelbuster.sbmod.common.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by galen on 8/18/2017.
 */
public class ModBlock extends Block {
    private String name;

    public ModBlock(Material materialIn) {
        super(materialIn);
    }

    public String getName() {
        return name;
    }
}
