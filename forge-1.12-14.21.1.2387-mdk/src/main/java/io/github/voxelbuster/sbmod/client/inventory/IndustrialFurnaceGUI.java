package io.github.voxelbuster.sbmod.client.inventory;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.IndustrialFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class IndustrialFurnaceGUI {

    public static IInventory inherited;

    public static int GUIID = 1;

    public static class GuiContainerMod extends Container {

        private final TileEntity ent;
        World world = null;
        EntityPlayer entity = null;
        int i, j, k;

        public static final int INPUT = 0, FUEL = 1, OUTPUT = 2;

        public GuiContainerMod(World world, int i, int j, int k, EntityPlayer player) {

            this.world = world;
            this.entity = player;
            this.i = i;
            this.j = j;
            this.k = k;

            this.ent = world.getTileEntity(new BlockPos(i, j, k));
            if (ent != null && (ent instanceof IndustrialFurnace.TileEntityCustom))
                inherited = (IInventory) ent;
            else
                inherited = new InventoryBasic("", true, 9);

            this.addSlotToContainer(new Slot(inherited, 0, 55, 16) {
                public void onSlotChanged() {
                    super.onSlotChanged();
                    if (getHasStack()) {
                        EntityPlayer entity = Minecraft.getMinecraft().player;
                        int i = (int) entity.posX;
                        int j = (int) entity.posY;
                        int k = (int) entity.posZ;
                        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                        World world = server.worlds[0];

                    }
                }
            });
            this.addSlotToContainer(new Slot(inherited, 1, 55, 52) {
                public void onSlotChanged() {
                    super.onSlotChanged();
                    if (getHasStack()) {
                        EntityPlayer entity = Minecraft.getMinecraft().player;
                        int i = (int) entity.posX;
                        int j = (int) entity.posY;
                        int k = (int) entity.posZ;
                        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
                        World world = server.worlds[0];

                    }
                }
            });
            this.addSlotToContainer(new Slot(inherited, 2, 114, 34) {
                public boolean isItemValid(ItemStack stack) {
                    return false;
                }

            });
            bindPlayerInventory(player.inventory);

        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
            return new ItemStack(Blocks.AIR, 0); // Not dealing with that
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
            return true;
        }

        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
            int i;
            int j;

            for (i = 0; i < 3; ++i) {
                for (j = 0; j < 9; ++j) {
                    this.addSlotToContainer(new Slot(inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
                }
            }

            for (i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
            }
        }

        public void onContainerClosed(EntityPlayer playerIn) {
            super.onContainerClosed(playerIn);
        }

    }

    public static class GuiWindow extends GuiContainer {

        int i = 0;
        int j = 0;
        int k = 0;
        EntityPlayer entity = null;
        private TileEntity te;

        public GuiWindow(World world, int i, int j, int k, EntityPlayer entity, IndustrialFurnace.TileEntityCustom parent) {
            super(new GuiContainerMod(world, i, j, k, entity));
            this.i = i;
            this.j = j;
            this.k = k;
            this.entity = entity;
            this.xSize = 176;
            this.ySize = 166;
            this.te = parent;
        }

        private static final ResourceLocation texture = new ResourceLocation(StarboundMod.MODID, "textures/gui/industrialfurnacegui.png");

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
            this.fontRenderer.drawString("Industrial Furnace", (3), (3), 0x000000);
            int posX = (this.width) / 2 - 30;
            int posY = (this.height) / 2 - 45;
            int arrowX = (this.width) / 2 - 8;
            int arrowY = (this.height) / 2 - 47;
            int burnPx = (int) (((float) ((IndustrialFurnace.TileEntityCustom) te).getCurrentItemBurnTime() / 5000) * 14);
            int cookPx = (int) (((IndustrialFurnace.TileEntityCustom) te).getCookTime() / ((IndustrialFurnace.TileEntityCustom) te).getTotalCookTime() * 23);
            this.drawTexturedModalRect(posX, posY + (14 - burnPx), 176, 0, 13, burnPx);
            this.drawTexturedModalRect(arrowX + (23 - cookPx), arrowY, 175, 14, cookPx, 16);
        }

        public void onGuiClosed() {
            super.onGuiClosed();
            Keyboard.enableRepeatEvents(false);
        }

        public void initGui() {
            super.initGui();
            this.guiLeft = (this.width - 176) / 2;
            this.guiTop = (this.height - 166) / 2;
            Keyboard.enableRepeatEvents(true);
            this.buttonList.clear();
            int posX = (this.width) / 2;
            int posY = (this.height) / 2;

        }

        public boolean doesGuiPauseGame() {
            return false;
        }

    }

}

