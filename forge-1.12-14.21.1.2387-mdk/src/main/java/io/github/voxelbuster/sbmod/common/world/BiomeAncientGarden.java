package io.github.voxelbuster.sbmod.common.world;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public class BiomeAncientGarden extends Biome {
    ArrayList<SpawnListEntry> spawnableMonsterList = new ArrayList<>();

    public BiomeAncientGarden(BiomeProperties properties) {
        super(properties);
        this.setRegistryName(StarboundMod.MODID, "ancientgarden");
    }

    @Override
    public boolean isHighHumidity() {
        return true;
    }

    @Override
    public boolean canRain() {
        return false;
    }

    @Override
    public boolean isMutation() {
        return true;
    }

    @Override
    public List<SpawnListEntry> getSpawnableList(EnumCreatureType type) {
        switch (type) {
            case AMBIENT:
                return this.spawnableCreatureList;
            case WATER_CREATURE:
                return this.spawnableWaterCreatureList;
            case MONSTER:
                return this.spawnableMonsterList;
            case CREATURE:
                return this.spawnableCreatureList;
        }
        return null;
    }
}
