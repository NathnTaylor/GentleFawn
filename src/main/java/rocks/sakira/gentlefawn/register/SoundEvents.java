package rocks.sakira.gentlefawn.register;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;

public class SoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GentleFawn.MOD_ID);

    public static final RegistryObject<SoundEvent> BUCK_SOUND = REGISTER.register(
            "entity.deer.buck.sound",

            () -> new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.buck.sound"))
    );

    public static final RegistryObject<SoundEvent> DOE_SOUND = REGISTER.register(
            "entity.deer.doe.sound",

            () -> new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.doe.sound"))
    );

    public static final RegistryObject<SoundEvent> FAWN_SOUND = REGISTER.register(
            "entity.deer.fawn.sound",

            () -> new SoundEvent(new ResourceLocation(GentleFawn.MOD_ID, "entity.deer.fawn.sound"))
    );
}
