package io.github.faecraft.gentlefawn.register

import io.github.faecraft.gentlefawn.Common.MOD_ID
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Sounds {
    val BUCK_SOUND = createSoundEvent("entity.deer.buck")
    val DOE_SOUND = createSoundEvent("entity.deer.doe")

    val FAWN_SOUND = createSoundEvent("entity.deer.fawn")

    private fun createSoundEvent(path: String) = SoundEvent(Identifier(MOD_ID, path))

    fun register() {
        register(BUCK_SOUND, "entity.deer.buck")
        register(DOE_SOUND, "entity.deer.doe")

        register(FAWN_SOUND, "entity.deer.fawn")
    }

    private fun register(sound: SoundEvent, id: String) {
        Registry.register(Registry.SOUND_EVENT, Identifier(MOD_ID, id), sound)
    }
}
