package io.github.voxelbuster.sbmod.proxy;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public CommonProxy() {
    }

    public void init(FMLInitializationEvent event, StarboundMod parent) {
        NetworkRegistry.INSTANCE.registerGuiHandler(parent, new GuiProxy());
    }

    public void registerItemRender(Item item, int i, String s) {}


}
