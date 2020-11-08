package io.github.faecraft.gentlefawn.block.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Quaternion;

public class DoeHeadModel extends SkullEntityModel {
    private final ModelPart head;
    private final ModelPart bone8;
    private final ModelPart bone7;

    public DoeHeadModel() {
        textureWidth = 72;
        textureHeight = 84;
        head = new ModelPart(this);
        head.setPivot(0.0F, 16.0F, 0.0F);
        head.setTextureOffset(24, 36).addCuboid(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true);
        head.setTextureOffset(0, 0).addCuboid(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true);

        bone8 = new ModelPart(this);
        bone8.setPivot(-11.5F, -10.0F, 5.5F);
        head.addChild(bone8);
        setRotationAngle(bone8, 0.0F, 0.0F, -1.0472F);
        bone8.setTextureOffset(0, 57).addCuboid(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true);

        bone7 = new ModelPart(this);
        bone7.setPivot(11.5F, -10.0F, 5.5F);
        head.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 1.0472F);
        bone7.setTextureOffset(0, 36).addCuboid(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();

        matrices.translate(0.0, -0.75, 0.0);
        matrices.scale(0.5F, 0.5F, 0.5F);
        matrices.multiply(new Quaternion(0.0F, 180.0F, 0.0F, true));

        head.render(matrices, vertices, light, overlay, red, green, blue, alpha);

        matrices.pop();
    }

    @Override
    public void method_2821(float f, float g, float h) {
        head.yaw = (g + 180) * (float) (Math.PI / 180F);
        head.pitch = h * (float) (Math.PI / 180F);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
