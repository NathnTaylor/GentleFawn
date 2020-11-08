package io.github.faecraft.gentlefawn.mixin;

import io.github.faecraft.gentlefawn.register.Entities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultBiomeCreator.class)
public abstract class DefaultBiomeCreatorMixin {
    @Inject(at = @At("HEAD"), method = "createForest")
    private static void createForest(float depth, float scale, boolean bl, SpawnSettings.Builder builder, CallbackInfoReturnable<Biome> cir) {
        builder.spawn(
                SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(
                        Entities.INSTANCE.getDEER(),
                        30,
                        2,
                        7
                )
        );
    }
}
