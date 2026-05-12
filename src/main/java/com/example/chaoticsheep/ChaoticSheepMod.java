package com.example.chaoticsheep;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

/**
 * Chaotic Sheep Mod - Spawns a wither with 1% chance when you kill a sheep
 */
@Mod("chaoticsheep")
public class ChaoticSheepMod {
    public static final String MOD_ID = "chaoticsheep";

    public ChaoticSheepMod(IEventBus modEventBus) {
        // Register mod event handlers
        modEventBus.addListener(this::commonSetup);

        // Register to the forge event bus for gameplay events
        NeoForge.EVENT_BUS.register(new SheepDeathEventHandler());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code if needed
    }
}
