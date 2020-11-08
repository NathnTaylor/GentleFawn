package io.github.faecraft.gentlefawn

import io.github.faecraft.gentlefawn.Common.MOD_ID
import io.github.faecraft.gentlefawn.block.model.BuckHeadModel
import io.github.faecraft.gentlefawn.block.model.DoeHeadModel
import io.github.faecraft.gentlefawn.entity.deer.DeerEntityRenderer
import io.github.faecraft.gentlefawn.enum.DeerSkullType
import io.github.faecraft.gentlefawn.mixin.SkullBlockEntityRendererMixin
import io.github.faecraft.gentlefawn.register.Entities
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager

object Client : ClientModInitializer {
    private val logger = LogManager.getLogger(this::class.java)

    override fun onInitializeClient() {
        setupRenderers()
        setupSkulls()
    }

    private fun setupRenderers() {
        EntityRendererRegistry.INSTANCE.register(Entities.DEER) { dispatcher, _ ->
            DeerEntityRenderer(dispatcher)
        }
    }

    private fun setupSkulls() {
        val models = SkullBlockEntityRendererMixin.getModels().toMutableMap()

        models[DeerSkullType.BUCK] = BuckHeadModel()
        models[DeerSkullType.DOE] = DoeHeadModel()

        SkullBlockEntityRendererMixin.setModels(models.toMap())

        val textures = SkullBlockEntityRendererMixin.getTextures().toMutableMap()

        textures[DeerSkullType.BUCK] = Identifier(MOD_ID, "textures/blocks/deer_head.png")
        textures[DeerSkullType.DOE] = Identifier(MOD_ID, "textures/blocks/deer_head.png")

        SkullBlockEntityRendererMixin.setTextures(textures.toMap())
    }
}
