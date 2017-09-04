package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.common.inventory.IndustrialFurnaceGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == IndustrialFurnaceGUI.GUIID)
            return new IndustrialFurnaceGUI.GuiContainerMod(world, x, y, z, player);
        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == IndustrialFurnaceGUI.GUIID)
            return new IndustrialFurnaceGUI.GuiWindow(world, x, y, z, player);
        return null;
    }
}
