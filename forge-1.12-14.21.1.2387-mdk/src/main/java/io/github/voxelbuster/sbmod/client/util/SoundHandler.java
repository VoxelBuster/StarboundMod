package io.github.voxelbuster.sbmod.client.util;

import io.github.voxelbuster.sbmod.common.StarboundMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber
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

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        size = 0;
        IForgeRegistry<SoundEvent> registry = event.getRegistry();
        for (String id : music_ids) {
            musics.add(register(id, registry));
        }
    }

    public static SoundEvent register(String name, IForgeRegistry<SoundEvent> registry) {
        ResourceLocation location = new ResourceLocation(StarboundMod.MODID, name);
        SoundEvent event = new SoundEvent(location).setRegistryName(name);
        registry.register(event);
        size++;
        return event;
    }

}
