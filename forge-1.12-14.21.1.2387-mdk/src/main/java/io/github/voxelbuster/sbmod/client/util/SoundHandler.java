package io.github.voxelbuster.sbmod.client.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;

public class SoundHandler {

    private static int size = 0;

    public static final String[] music_ids = {
            "atlas",
            "casiopeia",
            "cygnus_x1",
            "epsilon_indi",
            "eridanus-supervoid",
            "europa",
            "glacial_horizon",
            "haiku",
            "horsehead_nebula",
            "hymn",
            "jupiter",
            "kluex",
            "magellanic",
            "mercury",
            "mira",
            "procyon",
            "psyche",
            "stellar_formation",
            "tranquility",
            "ultramarine",
            "vast_suns",
            "via_aurora"
    };

    public static final ArrayList<SoundEvent> musics = new ArrayList<>();

    public static void init() {
        size = SoundEvent.REGISTRY.getKeys().size();
        for (String id : music_ids) {
            musics.add(register(id));
        }
    }

    public static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(StarboundMod.MODID + ":" + name);
        SoundEvent event = new SoundEvent(location);

        SoundEvent.REGISTRY.register(size, location, event);
        size++;
        return event;
    }

}
