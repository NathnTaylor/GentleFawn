package rocks.sakira.gentlefawn;

import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rocks.sakira.gentlefawn.client.renderer.RenderDeer;
import rocks.sakira.gentlefawn.entity.EntityDeer;
import rocks.sakira.gentlefawn.init.DeerRegistry;
import rocks.sakira.gentlefawn.register.Entities;
import rocks.sakira.gentlefawn.register.Items;
import rocks.sakira.gentlefawn.utils.ConfigurationHandler;

@Mod(value = GentleFawn.MOD_ID)
public class GentleFawn {
    public static final String MOD_ID = "gentlefawn";

    public GentleFawn() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setupCommon);
        eventBus.addListener(this::setupClient);

        Entities.REGISTER.register(eventBus);
        Items.REGISTER.register(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
    }

    public void setupCommon(final FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(
                Entities.DEER_ENTITY.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                EntityDeer::canAnimalSpawn
        );

        DeerRegistry.addSpawn();
    }

    public void setupClient(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                Entities.DEER_ENTITY.get(),
                RenderDeer::new
        );
    }
}
