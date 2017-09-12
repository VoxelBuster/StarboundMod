package io.github.voxelbuster.sbmod.common.inventory;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import io.github.voxelbuster.sbmod.common.block.IndustrialFurnace;
import io.github.voxelbuster.sbmod.common.item.crafting.IndustrialFurnaceRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
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

            TileEntity ent = world.getTileEntity(new BlockPos(i, j, k));
            if (ent != null && (ent instanceof IndustrialFurnace.TileEntityCustom))
                inherited = (IInventory) ent;
            else
                inherited = new InventoryBasic("", true, 9);

            this.addSlotToContainer(new Slot(inherited, 0, 73, 18) {
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
            this.addSlotToContainer(new Slot(inherited, 1, 73, 50) {
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

        public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
        {
            ItemStack itemstack = null;
            Slot slot = this.inventorySlots.get(par2);

            if (slot != null && slot.getHasStack())
            {
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();

                // If itemstack is in Output stack
                if (par2 == OUTPUT)
                {
                    // try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
                    // so the last slot in the inventory won't get checked if you don't add 1
                    if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+36+1, true))
                    {
                        return null;
                    }

                    slot.onSlotChange(itemstack1, itemstack);
                }
                // itemstack is in player inventory, try to place in appropriate furnace slot
                else if (par2 != FUEL && par2 != INPUT)
                {
                    // if it can be smelted, place in the input slots
                    if (IndustrialFurnaceRecipes.isSmeltable(itemstack1))
                    {
                        // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
                        if (!this.mergeItemStack(itemstack1, INPUT, INPUT+1, false))
                        {
                            return null;
                        }
                    }
                    // if it's an energy source, place in Fuel slot
                    else if (IndustrialFurnace.TileEntityCustom.isItemFuel(itemstack1))
                    {
                        if (!this.mergeItemStack(itemstack1, FUEL, FUEL+1, false))
                        {
                            return null;
                        }
                    }
                    // item in player's inventory, but not in action bar
                    else if (par2 >= OUTPUT+1 && par2 < OUTPUT+28)
                    {
                        // place in action bar
                        if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false))
                        {
                            return null;
                        }
                    }
                    // item in action bar - place in player inventory
                    else if (par2 >= OUTPUT+28 && par2 < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false))
                    {
                        return null;
                    }
                }
                // In one of the infuser slots; try to place in player inventory / action bar
                else if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+37, false))
                {
                    return null;
                }

                if (itemstack1.getCount() == 0)
                {
                    slot.putStack((ItemStack)null);
                }
                else
                {
                    slot.onSlotChanged();
                }

                if (itemstack1.getCount() == itemstack.getCount())
                {
                    return null;
                }

                slot.onTake(par1EntityPlayer, itemstack1);
            }
            return itemstack;
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

        public GuiWindow(World world, int i, int j, int k, EntityPlayer entity) {
            super(new GuiContainerMod(world, i, j, k, entity));
            this.i = i;
            this.j = j;
            this.k = k;
            this.entity = entity;
            this.xSize = 176;
            this.ySize = 166;
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

        protected void mouseClicked(int par1, int par2, int par3) throws java.io.IOException {
            super.mouseClicked(par1, par2, par3);

        }

        public void updateScreen() {
            super.updateScreen();
            int posX = (this.width) / 2;
            int posY = (this.height) / 2;

        }

        @Override
        protected void keyTyped(char par1, int par2) throws java.io.IOException {

            super.keyTyped(par1, par2);

        }

        protected void drawGuiContainerForegroundLayer(int par1, int par2) {
            int posX = (this.width) /2;
            int posY = (this.height) /2;
            this.fontRenderer.drawString("----->", (72), (33), 0xffffff);
            this.fontRenderer.drawString("Industrial Furnace", (3), (3), 0xffffff);

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

        protected void actionPerformed(GuiButton button) {
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            World world = server.worlds[0];

        }

        public boolean doesGuiPauseGame() {
            return false;
        }

    }

}

