package rocks.sakira.gentlefawn.register;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
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
}
