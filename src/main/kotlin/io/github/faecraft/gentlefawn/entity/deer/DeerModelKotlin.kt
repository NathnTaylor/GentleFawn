package io.github.faecraft.gentlefawn.entity.deer

import io.github.faecraft.gentlefawn.entity.DeerEntity
import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.MathHelper

class DeerModelKotlin() : EntityModel<DeerEntity>() {
    var horns = ModelPart(this)
    var head = ModelPart(this)
    var neck = ModelPart(this)

    val bone1 = ModelPart(this)
    var bone2 = ModelPart(this)
    var bone3 = ModelPart(this)
    var bone4 = ModelPart(this)
    var bone5 = ModelPart(this)
    var bone6 = ModelPart(this)

    val earLeft = ModelPart(this)
    val earRight = ModelPart(this)

    var body = ModelPart(this)

    var leg1 = ModelPart(this)
    var leg2 = ModelPart(this)
    var leg3 = ModelPart(this)
    var leg4 = ModelPart(this)

    var tail = ModelPart(this)

    init {
        textureWidth = 64;
        textureHeight = 64;

        head.addChild(horns)
        head.addChild(earLeft)
        head.addChild(earRight)

        horns.addChild(bone1)
        horns.addChild(bone2)
        horns.addChild(bone3)
        horns.addChild(bone4)
        horns.addChild(bone5)
        horns.addChild(bone6)

        setAngles(neck, -0.6981f, 0.0f, 0.0f)
        setAngles(body, 1.5708f, 0.0f, 0.0f)
        setAngles(tail, 0.4363f, 0.0f, 0.0f)

        setAngles(bone3, 0.0f, -0.2618f, 0.0f)
        setAngles(bone4, 0.0f, 0.2618f, 0.0f)
        setAngles(bone5, 0.0f, -0.4363f, 0.0f)
        setAngles(bone6, 0.0f, 0.5236f, 0.0f)

        setAngles(earLeft, 0.0f, 0.0f, -0.9599f)
        setAngles(earRight, 0.0f, 0.0f, 0.9599f)

        neck.setPivot(0.0f, 8.0f, -4.0f)
        neck.setTextureOffset(25, 10)
            .addCuboid(-2.0f, -2.7827f, -8.284f, 4.0f, 5.0f, 9.0f, 0.0f, true)

        head.setPivot(0.0f, 2.25f, -10.0f)
        head.setTextureOffset(1, 1)
            .addCuboid(-3.0f, -3.25f, -4.0f, 6.0f, 6.0f, 6.0f, 0.0f, true)
        head.setTextureOffset(26, 1)
            .addCuboid(-2.0f, -1.25f, -8.0f, 4.0f, 4.0f, 4.0f, 0.0f, true)

        horns.setPivot(0.0f, -3.25f, 1.0f)

        bone1.setPivot(-2.0f, -2.75f, -0.5f)
        bone1.setTextureOffset(43, 15)
            .addCuboid(0.196f, 0.75f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone1.setTextureOffset(43, 5)
            .addCuboid(0.2f, -2.25f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, false)

        bone2.setPivot(2.0f, -2.75f, -0.5f)
        bone2.setTextureOffset(43, 5)
            .addCuboid(-1.196f, -2.25f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone2.setTextureOffset(43, 15)
            .addCuboid(-1.196f, 0.75f, 0.0f, 1.0f, 2.0f, 0.0f, 0.0f, false)

        bone3.setPivot(-4.1143f, -5.7857f, -0.9f)
        bone3.setTextureOffset(43, 1)
            .addCuboid(0.3343f, -5.2143f, -0.21f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(43, 7)
            .addCuboid(-0.6657f, -4.2143f, -0.21f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(43, 5)
            .addCuboid(-0.6657f, -0.2143f, -0.21f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(43, 7)
            .addCuboid(0.3343f, -1.2143f, -0.21f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(46, 5)
            .addCuboid(0.3343f, 0.7857f, -0.21f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(43, 14)
            .addCuboid(1.3343f, 1.7857f, -0.21f, 1.0f, 3.0f, 0.0f, 0.0f, false)
        bone3.setTextureOffset(43, 10)
            .addCuboid(-0.6657f, 2.7857f, -0.21f, 2.0f, 1.0f, 0.0f, 0.0f, false)

        bone4.setPivot(4.1143f, -5.7857f, -0.8f)
        bone4.setTextureOffset(43, 1)
            .addCuboid(-1.3103f, -5.2143f, -0.31f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(43, 7)
            .addCuboid(-0.3103f, -4.2143f, -0.31f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(43, 5)
            .addCuboid(-0.3103f, -0.2143f, -0.31f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(43, 7)
            .addCuboid(-1.3103f, -1.2143f, -0.31f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(46, 5)
            .addCuboid(-1.3103f, 0.7857f, -0.31f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(43, 14)
            .addCuboid(-2.3103f, 1.7857f, -0.31f, 1.0f, 3.0f, 0.0f, 0.0f, false)
        bone4.setTextureOffset(43, 12)
            .addCuboid(-1.3103f, 2.7857f, -0.31f, 2.0f, 1.0f, 0.0f, 0.0f, false)

        bone5.setPivot(-6.575f, -6.375f, -1.8f)
        bone5.setTextureOffset(43, 10)
            .addCuboid(-0.085f, 1.375f, -0.32f, 2.0f, 1.0f, 0.0f, 0.0f, false)
        bone5.setTextureOffset(43, 1)
            .addCuboid(-0.085f, -2.625f, -0.32f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone5.setTextureOffset(43, 3)
            .addCuboid(-1.085f, 0.375f, -0.32f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone5.setTextureOffset(43, 7)
            .addCuboid(0.915f, -1.625f, -0.32f, 1.0f, 2.0f, 0.0f, 0.0f, false)

        bone6.setPivot(6.4f, -6.7f, -1.8f)
        bone6.setTextureOffset(43, 12)
            .addCuboid(-1.74f, 1.7f, -0.4f, 2.0f, 1.0f, 0.0f, 0.0f, false)
        bone6.setTextureOffset(43, 7)
            .addCuboid(-1.74f, -1.3f, -0.4f, 1.0f, 2.0f, 0.0f, 0.0f, false)
        bone6.setTextureOffset(43, 1)
            .addCuboid(-0.74f, -2.3f, -0.4f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone6.setTextureOffset(43, 3)
            .addCuboid(0.26f, 0.7f, -0.4f, 1.0f, 1.0f, 0.0f, 0.0f, false)
        bone6.setTextureOffset(76, 19)
            .addCuboid(-1.8062f, -1.3f, -0.35f, 1.0f, 0.0f, 0.0f, 0.0f, false)

        earLeft.setPivot(-3.5f, -3.25f, 0.5f)
        earLeft.setTextureOffset(1, 14)
            .addCuboid(-1.5f, -3.0f, -0.5f, 3.0f, 6.0f, 1.0f, 0.0f, true)

        earRight.setPivot(3.5f, -3.25f, 0.5f)
        earRight.setTextureOffset(1, 14)
            .addCuboid(-1.5f, -3.0f, -0.5f, 3.0f, 6.0f, 1.0f, 0.0f, true)

        body.setPivot(0.0f, 8.1667f, 0.0f)
        body.setTextureOffset(28, 26)
            .addCuboid(-4.0f, -8.1667f, -4.0f, 8.0f, 18.0f, 7.0f, 0.0f, true)

        leg1.setPivot(2.6f, 10.0f, -6.5f)
        leg1.setTextureOffset(1, 43)
            .addCuboid(-1.5f, -1.0f, -1.5f, 3.0f, 15.0f, 3.0f, 0.0f, true)

        leg2.setPivot(-2.6f, 10.0f, -6.5f)
        leg2.setTextureOffset(14, 43)
            .addCuboid(-1.5f, -1.0f, -1.5f, 3.0f, 15.0f, 3.0f, 0.0f, true)

        leg3.setPivot(2.6f, 10.0f, 7.5f)
        leg3.setTextureOffset(14, 24)
            .addCuboid(-1.5f, -1.0f, -1.5f, 3.0f, 15.0f, 3.0f, 0.0f, true)

        leg4.setPivot(-2.6f, 10.0f, 7.5f)
        leg4.setTextureOffset(1, 24)
            .addCuboid(-1.5f, -1.0f, -1.5f, 3.0f, 15.0f, 3.0f, 0.0f, true)

        tail.setPivot(0.0f, 9.0f, 10.0f)
        tail.setTextureOffset(10, 14)
            .addCuboid(-1.0f, -3.0f, -1.0f, 2.0f, 6.0f, 2.0f, 0.0f, false)
    }

    override fun render(
        matrices: MatrixStack?,
        vertices: VertexConsumer?,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        head.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        neck.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        leg1.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        leg2.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        leg3.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        leg4.render(matrices, vertices, light, overlay, red, green, blue, alpha)
        tail.render(matrices, vertices, light, overlay, red, green, blue, alpha)
    }

    override fun setAngles(
        entity: DeerEntity?,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {
        head.pitch = headPitch * 0.017453292f
        head.yaw = headYaw * 0.017453292f

        body.pitch = (Math.PI / 2f).toFloat()

        leg1.pitch = MathHelper.cos(limbAngle * 0.8f) * 1.4f * limbDistance
        leg2.pitch = MathHelper.cos(limbAngle * 0.8f + Math.PI.toFloat()) * 1.4f * limbDistance
        leg3.pitch = MathHelper.cos(limbAngle * 0.8f + Math.PI.toFloat()) * 1.4f * limbDistance
        leg4.pitch = MathHelper.cos(limbAngle * 0.8f) * 1.4f * limbDistance

    }

    private fun setAngles(part: ModelPart, pitch: Float, yaw: Float, roll: Float) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        part.pitch = pitch
        part.yaw = yaw
        part.roll = roll
    }
}
