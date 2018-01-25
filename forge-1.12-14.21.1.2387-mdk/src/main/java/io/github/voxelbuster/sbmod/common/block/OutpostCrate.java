package io.github.voxelbuster.sbmod.common.block;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.BlockChest;
import net.minecraft.block.SoundType;

public class OutpostCrate extends BlockChest {
    private String name;

    public OutpostCrate() {
        super(Type.BASIC);
        defaultInit();
        setName("outpostcratesmall");
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
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 1);
    }
}
