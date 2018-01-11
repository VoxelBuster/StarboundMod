package io.github.voxelbuster.sbmod.common;

import io.github.voxelbuster.sbmod.common.block.ModFluids;
import io.github.voxelbuster.sbmod.client.util.GuiHandler;
import io.github.voxelbuster.sbmod.common.util.RegisterUtil;
import io.github.voxelbuster.sbmod.common.world.WorldUtil;
import io.github.voxelbuster.sbmod.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = StarboundMod.MODID, version = StarboundMod.VERSION)
public class StarboundMod {
    public static final String MODID = "starboundmod";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(MODID)
    public static StarboundMod instance;

    public static final StarboundModCreativeTab creativeTab = new StarboundModCreativeTab();

    @SidedProxy(serverSide = "io.github.voxelbuster.sbmod.proxy.CommonProxy", clientSide = "io.github.voxelbuster.sbmod.proxy.ClientProxy")
    public static CommonProxy commonProxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(RegisterUtil.class);
        MinecraftForge.TERRAIN_GEN_BUS.register(WorldUtil.class);
        MinecraftForge.EVENT_BUS.register(ModFluids.class);
        ModFluids.registerFluids();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        RegisterUtil.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        RegisterUtil.registerWorldGen();
        commonProxy.init(event, this);
    }
}
