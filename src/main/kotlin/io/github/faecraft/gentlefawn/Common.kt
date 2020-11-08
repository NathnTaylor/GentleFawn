package io.github.faecraft.gentlefawn

import io.github.faecraft.gentlefawn.mixin.BlockEntityTypeAccessor
import io.github.faecraft.gentlefawn.mixin.SpawnRestrictionMixin
import io.github.faecraft.gentlefawn.register.Blocks
import io.github.faecraft.gentlefawn.register.Entities
import io.github.faecraft.gentlefawn.register.Items
import io.github.faecraft.gentlefawn.register.Sounds
import net.fabricmc.api.ModInitializer
import net.minecraft.entity.SpawnRestriction
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.world.Heightmap
import org.apache.logging.log4j.LogManager

object Common : ModInitializer {
    const val MOD_ID = "gentlefawn"

    private val logger = LogManager.getLogger(this::class.java)

    override fun onInitialize() {
        Items.register()
        Sounds.register()
        Blocks.register()
        Entities.registerAttributes()

        registerSpawnRestrictions()
    }

    fun registerSpawnRestrictions() {
        SpawnRestrictionMixin.register(
            Entities.DEER,
            SpawnRestriction.Location.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            AnimalEntity::isValidNaturalSpawn
        )
    }
}
