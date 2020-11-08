package io.github.faecraft.gentlefawn.entity.deer

import io.github.faecraft.gentlefawn.Common.MOD_ID
import io.github.faecraft.gentlefawn.entity.DeerEntity
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class DeerEntityRenderer(entityRenderDispatcher: EntityRenderDispatcher?) :
    MobEntityRenderer<DeerEntity, DeerModel>(entityRenderDispatcher, DeerModel(), 0.6f) {

    override fun setupTransforms(
        entity: DeerEntity,
        matrices: MatrixStack,
        animationProgress: Float,
        bodyYaw: Float,
        tickDelta: Float
    ) {
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta)

        if (entity.isBaby) {
            matrices.scale(0.66F, 0.66F, 0.66F)
        }
    }

    override fun getTexture(entity: DeerEntity): Identifier = when {
        entity.isBaby -> Identifier(MOD_ID, "textures/entity/deer/fawn.png")

        else -> Identifier(MOD_ID, "textures/entity/deer/${entity.getDeerType()}.png")
    }
}
