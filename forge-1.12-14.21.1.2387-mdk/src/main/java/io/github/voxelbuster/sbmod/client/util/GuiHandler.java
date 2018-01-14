package io.github.voxelbuster.sbmod.client.util;

import io.github.voxelbuster.sbmod.common.block.AtomicFurnace;
import io.github.voxelbuster.sbmod.common.block.IndustrialFurnace;
import io.github.voxelbuster.sbmod.client.inventory.AtomicFurnaceGUI;
import io.github.voxelbuster.sbmod.client.inventory.IndustrialFurnaceGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == IndustrialFurnaceGUI.GUIID)
            return new IndustrialFurnaceGUI.GuiContainerMod(world, x, y, z, player);
        else if (id == AtomicFurnaceGUI.GUIID)
            return new AtomicFurnaceGUI.GuiContainerMod(world, x, y, z, player);
        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == IndustrialFurnaceGUI.GUIID)
            return new IndustrialFurnaceGUI.GuiWindow(world, x, y, z, player, (IndustrialFurnace.TileEntityCustom) world.getTileEntity(new BlockPos(x, y , z)));
        else if (id == AtomicFurnaceGUI.GUIID)
            return new AtomicFurnaceGUI.GuiWindow(world, x, y, z, player, (AtomicFurnace.TileEntityCustom) world.getTileEntity(new BlockPos(x, y , z)));
        return null;
    }
}
