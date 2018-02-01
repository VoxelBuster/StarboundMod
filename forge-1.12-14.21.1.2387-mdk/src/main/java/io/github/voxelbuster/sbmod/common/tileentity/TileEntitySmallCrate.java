package io.github.voxelbuster.sbmod.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntitySmallCrate extends TileEntityChest {

    public TileEntitySmallCrate()
    {
        super();
    }

    @Override
    public boolean canRenderBreaking()
    {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return 36;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public String getGuiID() {
        return "minecraft:crateSmall";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerChest(playerInventory, this, playerIn);
    }
}
