package io.github.voxelbuster.sbmod.proxy;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    public ClientProxy() {
        super();
    }

    public void registerItemRender(Item item, int i, String name) {
        ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(name));
    }
}
