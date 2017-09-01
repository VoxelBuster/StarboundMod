package io.github.voxelbuster.sbmod.proxy;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public CommonProxy() {
    }

    public void init(FMLInitializationEvent event, StarboundMod parent) {
        //NetworkRegistry.INSTANCE.registerGuiHandler(StarboundMod.instance, new GuiHandler());
    }

    public void registerItemRender(Item item, int i, String s) {}


    public void preInit(FMLPreInitializationEvent event) {
    }
}
