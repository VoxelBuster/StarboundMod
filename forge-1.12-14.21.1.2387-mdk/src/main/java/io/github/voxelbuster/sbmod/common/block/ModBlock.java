package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlock extends Block {
    private String name;

    public ModBlock(Material materialIn, String name) {
        super(materialIn);
        setName(name);
        defaultInit();
    }

    public ModBlock(Material materialIn) {
        super(materialIn);
        defaultInit();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void defaultInit() {
        setCreativeTab(StarboundMod.creativeTab);
        setHardness(10f);
        setResistance(30f);
    }
}
