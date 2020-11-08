package io.github.faecraft.gentlefawn.block.model

import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.SkullEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.Quaternion

class BuckHeadModel() : SkullEntityModel() {
    private val head = ModelPart(this)
    private val horns = ModelPart(this)

    private val ear1 = ModelPart(this)
    private val ear2 = ModelPart(this)

    private val part1 = ModelPart(this)
    private val part2 = ModelPart(this)
    private val part3 = ModelPart(this)
    private val part4 = ModelPart(this)
    private val part5 = ModelPart(this)
    private val part6 = ModelPart(this)

    init {
        textureWidth = 72
        textureHeight = 84

        head.addChild(ear1)
        head.addChild(ear2)
        head.addChild(horns)

        horns.addChild(part1)
        horns.addChild(part2)
        horns.addChild(part3)
        horns.addChild(part4)
        horns.addChild(part5)
        horns.addChild(part6)

        setAngles(ear1, 0.0F, 0.0F, -1.0472F)
        setAngles(ear2, 0.0F, 0.0F, 1.0472F)

        setAngles(part3, 0.0F, -0.2618F, 0.0F)
        setAngles(part4, 0.0F, 0.2618F, 0.0F)
        setAngles(part5, 0.0F, -0.4363F, 0.0F)
        setAngles(part6, 0.0F, 0.5236F, 0.0F)

        head.setPivot(0.0F, 16.0F, 0.0F)
        head.setTextureOffset(24, 36)
            .addCuboid(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true)
        head.setTextureOffset(0, 0)
            .addCuboid(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true)

        horns.setPivot(0.0F, -17.0F, 6.0F)

        part1.setPivot(-2.0F, -2.75F, -0.5F)
        part1.setTextureOffset(45, 63)
            .addCuboid(-3.0f, 3.75f, 0.0f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part1.setTextureOffset(27, 66)
            .addCuboid(-3.0f, -5.25f, 0.0f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        
        part2.setPivot(2.0F, -2.75F, -0.5F)
        part2.setTextureOffset(27, 66)
            .addCuboid(-0.1f, -5.25f, 0.0f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part2.setTextureOffset(45, 63)
            .addCuboid(0.0f, 3.75f, 0.0f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        
        part3.setPivot(-4.1143f, -5.7857f, -0.9f)
        part3.setTextureOffset(27, 60)
            .addCuboid(-6.7357f, -20.2143f, 0.6f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(36, 66)
            .addCuboid(-9.7357f, -17.2143f, 0.6f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(36, 66)
            .addCuboid(-6.7357f, -8.2143f, 0.6f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(27, 72)
            .addCuboid(-9.7357f, -5.2143f, 0.6f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(36, 60)
            .addCuboid(-6.7357f, -2.2143f, 0.6f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(45, 60)
            .addCuboid(-3.7357f, 0.7857f, 0.6f, 3.0f, 9.0f, 0.0f, 0.0f, false)
        part3.setTextureOffset(36, 75)
            .addCuboid(-9.7357f, 3.7857f, 0.6f, 6.0f, 3.0f, 0.0f, 0.0f, false)

        part4.setPivot(4.1143F, -5.7857F, -0.8F);
        part4.setTextureOffset(27, 60)
            .addCuboid(3.7357f, -20.2143f, 0.5f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(36, 66)
            .addCuboid(6.7357f, -17.2143f, 0.5f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(27, 72)
            .addCuboid(6.7357f, -5.2143f, 0.5f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(36, 66)
            .addCuboid(3.7357f, -8.2143f, 0.5f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(36, 60)
            .addCuboid(3.7357f, -2.2143f, 0.5f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(45, 60)
            .addCuboid(0.7357f, 0.7857f, 0.5f, 3.0f, 9.0f, 0.0f, 0.0f, false)
        part4.setTextureOffset(36, 81)
            .addCuboid(3.7357f, 3.7857f, 0.5f, 6.0f, 3.0f, 0.0f, 0.0f, false)

        part5.setPivot(-6.575f, -6.375f, -1.8f)
        part5.setTextureOffset(36, 75)
            .addCuboid(-12.825f, -1.625f, 2.05f, 6.0f, 3.0f, 0.0f, 0.0f, false)
        part5.setTextureOffset(27, 60)
            .addCuboid(-12.825f, -13.625f, 2.05f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part5.setTextureOffset(27, 66)
            .addCuboid(-15.825f, -4.625f, 2.05f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part5.setTextureOffset(36, 66)
            .addCuboid(-9.825f, -10.625f, 2.05f, 3.0f, 6.0f, 0.0f, 0.0f, false)

        part6.setPivot(6.4f, -6.7f, -1.8f)
        part6.setTextureOffset(36, 81)
            .addCuboid(6.8f, -1.3f, 2.7f, 6.0f, 3.0f, 0.0f, 0.0f, false)
        part6.setTextureOffset(36, 66)
            .addCuboid(6.8f, -10.3f, 2.7f, 3.0f, 6.0f, 0.0f, 0.0f, false)
        part6.setTextureOffset(27, 60)
            .addCuboid(9.8f, -13.3f, 2.7f, 3.0f, 3.0f, 0.0f, 0.0f, false)
        part6.setTextureOffset(27, 66)
            .addCuboid(12.8f, -4.3f, 2.7f, 3.0f, 3.0f, 0.0f, 0.0f, false)


        ear1.setPivot(-11.5F, -10.0F, 5.5F)
        ear1.setTextureOffset(0, 57)
            .addCuboid(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true)

        ear2.setPivot(11.5F, -10.0F, 5.5F)
        ear2.setTextureOffset(0, 36)
            .addCuboid(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true)
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
