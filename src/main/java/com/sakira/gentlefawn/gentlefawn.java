package com.sakira.gentlefawn;

import com.sakira.gentlefawn.client.renderer.RenderDeer;
import com.sakira.gentlefawn.init.DeerRegistry;
import com.sakira.gentlefawn.utils.ConfigurationHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = gentlefawn.MOD_ID)
public class gentlefawn {
    public static final String MOD_ID = "gentlefawn";

    public gentlefawn() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setupCommon);
        eventBus.addListener(this::setupClient);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
    }

    public void setupCommon(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(DeerRegistry::addSpawn);
    }

    public void setupClient(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(DeerRegistry.DEER, RenderDeer::new);
    }
}