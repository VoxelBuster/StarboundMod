package io.github.voxelbuster.sbmod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
