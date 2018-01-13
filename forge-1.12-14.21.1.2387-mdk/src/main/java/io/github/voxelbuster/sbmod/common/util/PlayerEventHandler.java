package io.github.voxelbuster.sbmod.common.util;

import io.github.voxelbuster.sbmod.client.inventory.PixelsInventoryOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class PlayerEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerPickupItem(PlayerEvent.ItemPickupEvent event) {
        if (event.player.inventory.hasItemStack(new ItemStack(RegisterUtil.pixel))) {
            int index = event.player.inventory.getSlotFor(new ItemStack(RegisterUtil.pixel));
            ItemStack stack = event.player.inventory.getStackInSlot(index);
            NBTTagCompound nbt = event.player.getEntityData();
            nbt.setInteger("pixels", nbt.getInteger("pixels") + stack.getCount());
            event.player.inventory.setInventorySlotContents(index, new ItemStack(Items.AIR, 0));
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        EntityPlayerSP currentPlayer = Minecraft.getMinecraft().player;
        if (player == null || currentPlayer == null) return;
        if (player.getEntityId() == currentPlayer.getEntityId() && player.getEntityData().hasKey("pixels")) {
            PixelsInventoryOverlay.pixels = player.getEntityData().getInteger("pixels"); // update pixels overlay
        }
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        EntityLivingBase player = event.getEntityLiving();
        NBTTagCompound nbt = player.getEntityData();
        if (nbt.hasKey("pixels")) {
            player.dropItem(RegisterUtil.pixel, nbt.getInteger("pixels") / 2);
            nbt.setInteger("pixels", 0);
        }
    }
}
