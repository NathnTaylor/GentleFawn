package io.github.faecraft.gentlefawn.block.model

import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.SkullEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.Quaternion

class DoeHeadModelKotlin() : SkullEntityModel() {
    private val head = ModelPart(this)
    private val ear1 = ModelPart(this)
    private val ear2 = ModelPart(this)

    init {
        textureWidth = 72
        textureHeight = 84

        head.addChild(ear1)
        head.addChild(ear2)

        setAngles(ear1, 0.0F, 0.0F, -1.0472F)
        setAngles(ear2, 0.0F, 0.0F, 1.0472F)

        head.setPivot(0.0F, 16.0F, 0.0F)
        head.setTextureOffset(24, 36)
            .addCuboid(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true)
        head.setTextureOffset(0, 0)
            .addCuboid(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true)

        ear1.setPivot(-11.5F, -1.0F, 5.5F)
        ear1.setTextureOffset(0, 57)
            .addCuboid(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true)

        ear2.setPivot(11.5F, -10.0F, 5.5F)
        ear2.setTextureOffset(0, 36)
            .addCuboid(-4.5f, -9.0f, -1.5f, 9.0f, 18.0f, 3.0f, 0.0f, true)
    }

    override fun render(
        matrices: MatrixStack,
        vertices: VertexConsumer,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        matrices.push()

        matrices.translate(0.0, -0.75, 0.0)
        matrices.scale(0.5F, 0.5F, 0.5F)
        matrices.multiply(Quaternion(0.0F, 180.0F, 0.0F, true))

        head.render(matrices, vertices, light, overlay, red, green, blue, alpha)

        matrices.pop()
    }

    override fun method_2821(f: Float, g: Float, h: Float) {
        head.yaw = (g + 180) * (Math.PI / 180F).toFloat()
        head.pitch = h * (Math.PI / 180F).toFloat()
    }

    private fun setAngles(part: ModelPart, pitch: Float, yaw: Float, roll: Float) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        part.pitch = pitch
        part.yaw = yaw
        part.roll = roll
    }
}
