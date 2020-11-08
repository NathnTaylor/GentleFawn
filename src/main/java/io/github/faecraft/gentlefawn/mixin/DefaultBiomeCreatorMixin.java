package io.github.faecraft.gentlefawn.mixin;

import io.github.faecraft.gentlefawn.register.Entities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(DefaultBiomeCreator.class)
public class DefaultBiomeCreatorMixin {
    @ModifyVariable(
            method = "createForest",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private static SpawnSettings.Builder createSwamp(SpawnSettings.Builder builder) {
        return builder.spawn(
                SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(
                        Entities.INSTANCE.getDEER(),
                        15,
                        5,
                        12
                )
        );
    }
}
