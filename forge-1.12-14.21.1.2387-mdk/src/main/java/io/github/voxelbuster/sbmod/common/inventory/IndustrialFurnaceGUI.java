package io.github.voxelbuster.sbmod.common.inventory;

import io.github.voxelbuster.sbmod.common.tileentity.IndustrialFurnaceTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by galen on 8/28/2017.
 */
public class IndustrialFurnaceGUI extends GuiContainer {

    private static final ResourceLocation background = new ResourceLocation("minecraft", "textures/gui/container/furnace.png");

    private final int WIDTH = 175;
    private final int HEIGHT = 165;

    public IndustrialFurnaceGUI(IndustrialFurnaceTileEntity tileEntity, ContainerIndustrialFurnace container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
