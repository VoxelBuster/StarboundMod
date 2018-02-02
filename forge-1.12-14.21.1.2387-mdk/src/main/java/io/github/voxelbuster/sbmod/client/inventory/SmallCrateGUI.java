package io.github.voxelbuster.sbmod.client.inventory;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.tileentity.TileEntitySmallCrate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class SmallCrateGUI {
    public static int GUIID = 3;

    public static class GuiWindow extends GuiContainer {

        int i = 0;
        int j = 0;
        int k = 0;
        EntityPlayer entity = null;
        private TileEntity te;

        public GuiWindow(World world, int i, int j, int k, EntityPlayer entity, TileEntitySmallCrate parent) {
            super(parent.createContainer(entity.inventory, entity));
            this.i = i;
            this.j = j;
            this.k = k;
            this.entity = entity;
            this.xSize = 176;
            this.ySize = 166;
            this.te = parent;
        }

        private static final ResourceLocation texture = new ResourceLocation(StarboundMod.MODID, "textures/gui/chest.png");

        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
            int posX = (this.width) / 2;
            int posY = (this.height) / 2;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            this.mc.renderEngine.bindTexture(texture);
            int k = (this.width - this.xSize) / 2;
            int l = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

            zLevel = 100.0F;

        }

        protected void drawGuiContainerForegroundLayer(int par1, int par2) {
            this.fontRenderer.drawString("Small Crate", 5, 5, 0x000000);
        }

        public void onGuiClosed() {
            super.onGuiClosed();
            te.markDirty();
            Keyboard.enableRepeatEvents(false);
        }

        public void initGui() {
            super.initGui();
            this.guiLeft = (this.width - 176) / 2;
            this.guiTop = (this.height - 166) / 2;
            Keyboard.enableRepeatEvents(true);
            this.buttonList.clear();
        }

        public boolean doesGuiPauseGame() {
            return false;
        }

    }
}
