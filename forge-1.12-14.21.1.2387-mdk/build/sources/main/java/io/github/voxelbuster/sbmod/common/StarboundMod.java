package io.github.voxelbuster.sbmod.common;

import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import io.github.voxelbuster.sbmod.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StarboundMod.MODID, version = StarboundMod.VERSION)
public class StarboundMod {
    public static final String MODID = "starboundmod";
    public static final String VERSION = "1.0.0";

    public static final StarboundModCreativeTab creativeTab = new StarboundModCreativeTab();

    @SidedProxy(serverSide = "io.github.voxelbuster.sbmod.proxy.CommonProxy", clientSide = "io.github.voxelbuster.sbmod.proxy.ClientProxy")
    public static CommonProxy commonProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RegisterUtil());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }
}