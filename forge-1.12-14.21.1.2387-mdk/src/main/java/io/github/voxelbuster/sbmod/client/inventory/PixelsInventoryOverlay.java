package io.github.voxelbuster.sbmod.client.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class PixelsInventoryOverlay extends GuiScreen {
    public static int pixels = 0;

    public PixelsInventoryOverlay() {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.player != null) {
            this.drawString(mc.fontRenderer, "Pixels: " + pixels,
                    0, 10, 0x777700);
        }
    }

    @SubscribeEvent
    public static void renderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) return;
        new PixelsInventoryOverlay();
    }
}
