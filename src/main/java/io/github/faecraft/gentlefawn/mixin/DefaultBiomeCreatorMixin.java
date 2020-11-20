package io.github.faecraft.gentlefawn.mixin;

import io.github.faecraft.gentlefawn.register.Entities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultBiomeCreator.class)
public abstract class DefaultBiomeCreatorMixin {
    @Inject(at = @At("HEAD"), method = "createForest")
    private static void createForest(float depth, float scale, boolean bl, SpawnSettings.Builder builder, CallbackInfoReturnable<Biome> cir) {
        addSpawns(builder);
    }

    @ModifyVariable(
            method = "createBirchForest",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private static SpawnSettings.Builder createBirchForest(SpawnSettings.Builder builder) {
        return addSpawns(builder);
    }

    @ModifyVariable(
            method = "createDarkForest",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private static SpawnSettings.Builder createDarkForest(SpawnSettings.Builder builder) {
        return addSpawns(builder);
    }

    @ModifyVariable(
            method = "createTaiga",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private static SpawnSettings.Builder createTaiga(SpawnSettings.Builder builder, float depth, float scale, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (depth == 0.45F) {
            return addSpawns(builder);
        }

        return builder;
    }

    @ModifyVariable(
            method = "createMountains",
            at = @At(value = "STORE", ordinal = 0),
            ordinal = 0
    )
    private static SpawnSettings.Builder createMountains(SpawnSettings.Builder builder, float depth, float scale, ConfiguredSurfaceBuilder<TernarySurfaceConfig> surfaceBuilder, boolean extraTrees) {
        if (extraTrees) {
            return addSpawns(builder);
        }

        return builder;
    }

    private static SpawnSettings.Builder addSpawns(SpawnSettings.Builder builder) {
        return builder.spawn(
                SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(
                        Entities.INSTANCE.getDEER(),
                        8,
                        4,
                        4
                )
        );
    }
}
