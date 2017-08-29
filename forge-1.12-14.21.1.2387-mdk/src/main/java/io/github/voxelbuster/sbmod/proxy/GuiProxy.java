package io.github.voxelbuster.sbmod.proxy;

import io.github.voxelbuster.sbmod.common.inventory.ContainerIndustrialFurnace;
import io.github.voxelbuster.sbmod.common.inventory.IndustrialFurnaceGUI;
import io.github.voxelbuster.sbmod.common.tileentity.IndustrialFurnaceTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof IndustrialFurnaceTileEntity) {
            return new ContainerIndustrialFurnace(player.inventory, (IndustrialFurnaceTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof IndustrialFurnaceTileEntity) {
            IndustrialFurnaceTileEntity containerTileEntity = (IndustrialFurnaceTileEntity) te;
            return new IndustrialFurnaceGUI(containerTileEntity, new ContainerIndustrialFurnace(player.inventory, containerTileEntity));
        }
        return null;
    }
}
