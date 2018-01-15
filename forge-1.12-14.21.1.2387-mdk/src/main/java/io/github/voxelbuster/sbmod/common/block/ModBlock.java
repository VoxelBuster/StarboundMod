package io.github.voxelbuster.sbmod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
