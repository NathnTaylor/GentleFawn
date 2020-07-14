package rocks.sakira.gentlefawn.register;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.entity.EntityDeer;

public class Entities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, GentleFawn.MOD_ID);

    public static final RegistryObject<EntityType<EntityDeer>> DEER_ENTITY = REGISTER.register(
            "deer",

            () -> EntityType.Builder
                    .create(EntityDeer::new, EntityClassification.CREATURE)
                    .size(0.9F, 1.9F)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .build("deer")
    );

    @SubscribeEvent
    public static void registerEntities(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(
                DEER_ENTITY.get(),

                AnimalEntity.func_233666_p_()
                        .func_233815_a_(Attributes.field_233818_a_, 8.0D)  // Max health
                        .func_233815_a_(Attributes.field_233821_d_, 0.16D)  // Movement speed
                        .func_233813_a_()
        );
    }
}
