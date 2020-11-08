package io.github.faecraft.gentlefawn.register

import io.github.faecraft.gentlefawn.Common.MOD_ID
import io.github.faecraft.gentlefawn.entity.DeerEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Entities {
    val DEER = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(MOD_ID, "deer"),

        FabricEntityTypeBuilder
            .create(SpawnGroup.AMBIENT, ::DeerEntity)
            .dimensions(EntityDimensions.changing(0.9F, 1.9F))
            .trackRangeBlocks(64)
            .trackedUpdateRate(1)
            .build()
    )

    fun registerAttributes() {
        FabricDefaultAttributeRegistry.register(
            DEER,
            AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.16)
        )
    }
}
