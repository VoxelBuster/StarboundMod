package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public class BiomeAncientGarden extends Biome {

    private static BiomeProperties properties = new Biome.BiomeProperties("ancientgarden");

    static {
        properties.setBaseBiome("plains");
        properties.setTemperature(0.7f);
        properties.setRainfall(0f);
        properties.setHeightVariation(0.00001f);
    }

    public BiomeAncientGarden() {
        super(properties);
        this.setRegistryName(new ResourceLocation(StarboundMod.MODID, "ancientgarden"));
        decorator.treesPerChunk = 1;
        decorator.flowersPerChunk = 64;
        decorator.clayPerChunk = 0;
        decorator.sandPatchesPerChunk = 0;
        decorator.grassPerChunk = 64;
        decorator.reedsPerChunk = 2;
    }
}
