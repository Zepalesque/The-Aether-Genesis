package com.aetherteam.aether_genesis.client.event.listener;

import com.aetherteam.aether_genesis.client.event.hook.GenesisAudioHooks;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber({Dist.CLIENT})
public class GenesisAudioListener {
    public GenesisAudioListener() {
    }

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        SoundInstance sound = event.getOriginalSound();
        if (GenesisAudioHooks.shouldCancelSound(sound)) {
            event.setSound(null);
        }

    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            GenesisAudioHooks.tick();
        }

    }

    @SubscribeEvent
    public static void onPlayerRespawn(ClientPlayerNetworkEvent.Clone event) {
        GenesisAudioHooks.stop();
    }

}
