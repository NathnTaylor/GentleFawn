package io.github.faecraft.gentlefawn.block.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Quaternion;

public class BuckHeadModel extends SkullEntityModel {
    private final ModelPart head;
    private final ModelPart horns2;
    private final ModelPart bone9;
    private final ModelPart bone10;
    private final ModelPart bone11;
    private final ModelPart bone12;
    private final ModelPart bone13;
    private final ModelPart bone14;
    private final ModelPart bone8;
    private final ModelPart bone7;

    public BuckHeadModel() {
        textureWidth = 72;
        textureHeight = 84;
        head = new ModelPart(this);
        head.setPivot(0.0F, 16.0F, 0.0F);
        head.setTextureOffset(24, 36).addCuboid(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true);
        head.setTextureOffset(0, 0).addCuboid(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true);

        horns2 = new ModelPart(this);
        horns2.setPivot(0.0F, -17.0F, 6.0F);
        head.addChild(horns2);


        bone9 = new ModelPart(this);
        bone9.setPivot(-2.0F, -2.75F, -0.5F);
        horns2.addChild(bone9);
        bone9.setTextureOffset(45, 63).addCuboid(-3.0F, 3.75F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone9.setTextureOffset(27, 66).addCuboid(-3.0F, -5.25F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        bone10 = new ModelPart(this);
        bone10.setPivot(2.0F, -2.75F, -0.5F);
        horns2.addChild(bone10);
        bone10.setTextureOffset(27, 66).addCuboid(-0.1F, -5.25F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone10.setTextureOffset(45, 63).addCuboid(0.0F, 3.75F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);

        bone11 = new ModelPart(this);
        bone11.setPivot(-4.1143F, -5.7857F, -0.9F);
        horns2.addChild(bone11);
        setRotationAngle(bone11, 0.0F, -0.2618F, 0.0F);
        bone11.setTextureOffset(27, 60).addCuboid(-6.7357F, -20.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 66).addCuboid(-9.7357F, -17.2143F, 0.6F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 66).addCuboid(-6.7357F, -8.2143F, 0.6F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(27, 72).addCuboid(-9.7357F, -5.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 60).addCuboid(-6.7357F, -2.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(45, 60).addCuboid(-3.7357F, 0.7857F, 0.6F, 3.0F, 9.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 75).addCuboid(-9.7357F, 3.7857F, 0.6F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        bone12 = new ModelPart(this);
        bone12.setPivot(4.1143F, -5.7857F, -0.8F);
        horns2.addChild(bone12);
        setRotationAngle(bone12, 0.0F, 0.2618F, 0.0F);
        bone12.setTextureOffset(27, 60).addCuboid(3.7357F, -20.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 66).addCuboid(6.7357F, -17.2143F, 0.5F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(27, 72).addCuboid(6.7357F, -5.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 66).addCuboid(3.7357F, -8.2143F, 0.5F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 60).addCuboid(3.7357F, -2.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(45, 60).addCuboid(0.7357F, 0.7857F, 0.5F, 3.0F, 9.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 81).addCuboid(3.7357F, 3.7857F, 0.5F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        bone13 = new ModelPart(this);
        bone13.setPivot(-6.575F, -6.375F, -1.8F);
        horns2.addChild(bone13);
        setRotationAngle(bone13, 0.0F, -0.4363F, 0.0F);
        bone13.setTextureOffset(36, 75).addCuboid(-12.825F, -1.625F, 2.05F, 6.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(27, 60).addCuboid(-12.825F, -13.625F, 2.05F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(27, 66).addCuboid(-15.825F, -4.625F, 2.05F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(36, 66).addCuboid(-9.825F, -10.625F, 2.05F, 3.0F, 6.0F, 0.0F, 0.0F, false);

        bone14 = new ModelPart(this);
        bone14.setPivot(6.4F, -6.7F, -1.8F);
        horns2.addChild(bone14);
        setRotationAngle(bone14, 0.0F, 0.5236F, 0.0F);
        bone14.setTextureOffset(36, 81).addCuboid(6.8F, -1.3F, 2.7F, 6.0F, 3.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(36, 66).addCuboid(6.8F, -10.3F, 2.7F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(27, 60).addCuboid(9.8F, -13.3F, 2.7F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(27, 66).addCuboid(12.8F, -4.3F, 2.7F, 3.0F, 3.0F, 0.0F, 0.0F, false);

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
