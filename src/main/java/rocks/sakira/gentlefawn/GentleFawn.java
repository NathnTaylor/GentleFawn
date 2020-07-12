package rocks.sakira.gentlefawn;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.sakira.gentlefawn.client.renderer.RenderDeer;
import rocks.sakira.gentlefawn.entity.EntityDeer;
import rocks.sakira.gentlefawn.init.DeerRegistry;
import rocks.sakira.gentlefawn.register.Blocks;
import rocks.sakira.gentlefawn.register.Entities;
import rocks.sakira.gentlefawn.register.Items;
import rocks.sakira.gentlefawn.utils.ConfigurationHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

@Mod(value = GentleFawn.MOD_ID)
public class GentleFawn {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gentlefawn";

    public GentleFawn() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.register(this);

        Blocks.REGISTER.register(eventBus);
        Entities.REGISTER.register(eventBus);
        Items.REGISTER.register(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationHandler.spec);
    }

    @SubscribeEvent
    public void setupCommon(final FMLCommonSetupEvent event) throws IllegalAccessException, NoSuchFieldException {
        EntitySpawnPlacementRegistry.register(
                Entities.DEER_ENTITY.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                EntityDeer::canAnimalSpawn
        );

        DeerRegistry.addSpawn();

        // This block is pretty hacky, but I can't think of a better way to do this.
        // This is likely to break between major Forge versions.
        Field f;

        try {
            // Attempt to grab a reference to the validBlocks set and make it available.
            f = TileEntityType.SKULL.getClass().getDeclaredField("field_223046_I");
        } catch (NoSuchFieldException e) {
            // We may be in a development environment
            f = TileEntityType.SKULL.getClass().getDeclaredField("validBlocks");
        }

        try {
            f.setAccessible(true);  // Bypass `private` access modifier.

            // Create a list based on the current allowed blocks set, so we can add ours.
            Set<Block> allowedBlocks = (Set<Block>) f.get(TileEntityType.SKULL);
            ArrayList<Block> blocks = new ArrayList<>(allowedBlocks);

            // Add our blocks to the list.
            blocks.add(Blocks.DOE_HEAD.get());
            blocks.add(Blocks.DOE_WALL_HEAD.get());
            blocks.add(Blocks.BUCK_HEAD.get());
            blocks.add(Blocks.BUCK_WALL_HEAD.get());

            // Copy our blocks into a set, as required by TileEntityType.
            Set<Block> allAllowedBlocks = ImmutableSet.copyOf(blocks);

            // Finally, update the reference within the SKULL TileEntityType to the set we just made.
            f.set(TileEntityType.SKULL, allAllowedBlocks);
        } catch (IllegalAccessException e) {
            // If it didn't work, we should log the problem and then re-throw the exception.
            // If this fails, skulls won't work - it's better to crash the game than allow it
            // to run with broken blocks or tile entities.
            LOGGER.error("Failed to set up allowable skull block types", e);
            throw e;
        }
    }

    @SubscribeEvent
    public void setupClient(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                Entities.DEER_ENTITY.get(),
                RenderDeer::new
        );
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void setupItemColours(final ColorHandlerEvent.Item event) {
        event.getItemColors().register((itemColor, itemsIn) ->
                Items.DEER_SPAWN_EGG.get().getColor(itemsIn),
                Items.DEER_SPAWN_EGG.get()
        );
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void clientSetup(final FMLClientSetupEvent event) throws NoSuchFieldException, IllegalAccessException {
        ClientOnlySetup.setupSkullRenderer();
    }
}
