package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = StarboundMod.MODID)
public class WorldUtil {
    public static final BiomeAncientGarden ancientGarden = new BiomeAncientGarden();

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.register(ancientGarden);

        BiomeDictionary.addTypes(ancientGarden, BiomeDictionary.Type.FOREST);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ancientGarden, 1000));
        BiomeManager.addSpawnBiome(ancientGarden);
        BiomeProvider.allowedBiomes.add(ancientGarden);
    }
}
