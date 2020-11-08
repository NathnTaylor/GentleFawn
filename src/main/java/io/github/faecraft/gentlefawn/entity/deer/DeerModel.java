package io.github.faecraft.gentlefawn.entity.deer;

import io.github.faecraft.gentlefawn.entity.DeerEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class DeerModel extends EntityModel<DeerEntity> {
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart earr_r1;
    private final ModelPart earl_r1;
    private final ModelPart horns;
    private final ModelPart bone6_r1;
    private final ModelPart bone5_r1;
    private final ModelPart bone4_r1;
    private final ModelPart bone3_r1;
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart earl;
    private final ModelPart earr;
    private final ModelPart body;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;
    private final ModelPart tail;

    public DeerModel() {
        textureWidth = 64;
        textureHeight = 64;
        neck = new ModelPart(this);
        neck.setPivot(0.0F, 8.0F, -4.0F);
        setRotationAngle(neck, -0.6981F, 0.0F, 0.0F);
        neck.setTextureOffset(25, 10).addCuboid(-2.0F, -2.7827F, -8.284F, 4.0F, 5.0F, 9.0F, 0.0F, true);

        head = new ModelPart(this);
        head.setPivot(0.0F, 2.25F, -10.0F);
        head.setTextureOffset(1, 1).addCuboid(-3.0F, -3.25F, -4.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
        head.setTextureOffset(26, 1).addCuboid(-2.0F, -1.25F, -8.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

        earr_r1 = new ModelPart(this);
        earr_r1.setPivot(3.5F, -3.25F, 0.5F);
        head.addChild(earr_r1);
        setRotationAngle(earr_r1, 0.0F, 0.0F, 0.9599F);


        earl_r1 = new ModelPart(this);
        earl_r1.setPivot(-3.5F, -3.25F, 0.5F);
        head.addChild(earl_r1);
        setRotationAngle(earl_r1, 0.0F, 0.0F, -0.9599F);


        horns = new ModelPart(this);
        horns.setPivot(0.0F, -3.25F, 1.0F);
        head.addChild(horns);


        bone6_r1 = new ModelPart(this);
        bone6_r1.setPivot(6.4F, -6.7F, -1.8F);
        horns.addChild(bone6_r1);
        setRotationAngle(bone6_r1, 0.0F, 0.5236F, 0.0F);


        bone5_r1 = new ModelPart(this);
        bone5_r1.setPivot(-6.575F, -6.375F, -1.8F);
        horns.addChild(bone5_r1);
        setRotationAngle(bone5_r1, 0.0F, -0.4363F, 0.0F);


        bone4_r1 = new ModelPart(this);
        bone4_r1.setPivot(4.1143F, -5.7857F, -0.8F);
        horns.addChild(bone4_r1);
        setRotationAngle(bone4_r1, 0.0F, 0.2618F, 0.0F);


        bone3_r1 = new ModelPart(this);
        bone3_r1.setPivot(-4.1143F, -5.7857F, -0.9F);
        horns.addChild(bone3_r1);
        setRotationAngle(bone3_r1, 0.0F, -0.2618F, 0.0F);


        bone = new ModelPart(this);
        bone.setPivot(-2.0F, -2.75F, -0.5F);
        horns.addChild(bone);
        bone.setTextureOffset(43, 15).addCuboid(0.196F, 0.75F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone.setTextureOffset(43, 5).addCuboid(0.2F, -2.25F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

        bone2 = new ModelPart(this);
        bone2.setPivot(2.0F, -2.75F, -0.5F);
        horns.addChild(bone2);
        bone2.setTextureOffset(43, 5).addCuboid(-1.196F, -2.25F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone2.setTextureOffset(43, 15).addCuboid(-1.196F, 0.75F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

        bone3 = new ModelPart(this);
        bone3.setPivot(-4.1143F, -5.7857F, -0.9F);
        horns.addChild(bone3);
        setRotationAngle(bone3, 0.0F, -0.2618F, 0.0F);
        bone3.setTextureOffset(43, 1).addCuboid(0.3343F, -5.2143F, -0.21F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(43, 7).addCuboid(-0.6657F, -4.2143F, -0.21F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(43, 5).addCuboid(-0.6657F, -0.2143F, -0.21F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(43, 7).addCuboid(0.3343F, -1.2143F, -0.21F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(46, 5).addCuboid(0.3343F, 0.7857F, -0.21F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(43, 14).addCuboid(1.3343F, 1.7857F, -0.21F, 1.0F, 3.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(43, 10).addCuboid(-0.6657F, 2.7857F, -0.21F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        bone4 = new ModelPart(this);
        bone4.setPivot(4.1143F, -5.7857F, -0.8F);
        horns.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.2618F, 0.0F);
        bone4.setTextureOffset(43, 1).addCuboid(-1.3103F, -5.2143F, -0.31F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(43, 7).addCuboid(-0.3103F, -4.2143F, -0.31F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(43, 5).addCuboid(-0.3103F, -0.2143F, -0.31F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(43, 7).addCuboid(-1.3103F, -1.2143F, -0.31F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(46, 5).addCuboid(-1.3103F, 0.7857F, -0.31F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(43, 14).addCuboid(-2.3103F, 1.7857F, -0.31F, 1.0F, 3.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(43, 12).addCuboid(-1.3103F, 2.7857F, -0.31F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        bone5 = new ModelPart(this);
        bone5.setPivot(-6.575F, -6.375F, -1.8F);
        horns.addChild(bone5);
        setRotationAngle(bone5, 0.0F, -0.4363F, 0.0F);
        bone5.setTextureOffset(43, 10).addCuboid(-0.085F, 1.375F, -0.32F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(43, 1).addCuboid(-0.085F, -2.625F, -0.32F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(43, 3).addCuboid(-1.085F, 0.375F, -0.32F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(43, 7).addCuboid(0.915F, -1.625F, -0.32F, 1.0F, 2.0F, 0.0F, 0.0F, false);

        bone6 = new ModelPart(this);
        bone6.setPivot(6.4F, -6.7F, -1.8F);
        horns.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.5236F, 0.0F);
        bone6.setTextureOffset(43, 12).addCuboid(-1.74F, 1.7F, -0.4F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(43, 7).addCuboid(-1.74F, -1.3F, -0.4F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(43, 1).addCuboid(-0.74F, -2.3F, -0.4F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(43, 3).addCuboid(0.26F, 0.7F, -0.4F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(76, 19).addCuboid(-1.8062F, -1.3F, -0.35F, 1.0F, 0.0F, 0.0F, 0.0F, false);

        earl = new ModelPart(this);
        earl.setPivot(-3.5F, -3.25F, 0.5F);
        head.addChild(earl);
        setRotationAngle(earl, 0.0F, 0.0F, -0.9599F);
        earl.setTextureOffset(1, 14).addCuboid(-1.5F, -3.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, true);

        earr = new ModelPart(this);
        earr.setPivot(3.5F, -3.25F, 0.5F);
        head.addChild(earr);
        setRotationAngle(earr, 0.0F, 0.0F, 0.9599F);
        earr.setTextureOffset(1, 14).addCuboid(-1.5F, -3.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, true);

        body = new ModelPart(this);
        body.setPivot(0.0F, 8.1667F, 0.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(28, 26).addCuboid(-4.0F, -8.1667F, -4.0F, 8.0F, 18.0F, 7.0F, 0.0F, true);

        leg1 = new ModelPart(this);
        leg1.setPivot(2.6F, 10.0F, -6.5F);
        leg1.setTextureOffset(1, 43).addCuboid(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg2 = new ModelPart(this);
        leg2.setPivot(-2.6F, 10.0F, -6.5F);
        leg2.setTextureOffset(14, 43).addCuboid(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg3 = new ModelPart(this);
        leg3.setPivot(2.6F, 10.0F, 7.5F);
        leg3.setTextureOffset(14, 24).addCuboid(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg4 = new ModelPart(this);
        leg4.setPivot(-2.6F, 10.0F, 7.5F);
        leg4.setTextureOffset(1, 24).addCuboid(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        tail = new ModelPart(this);
        tail.setPivot(0.0F, 9.0F, 10.0F);
        setRotationAngle(tail, 0.4363F, 0.0F, 0.0F);
        tail.setTextureOffset(10, 14).addCuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
    }

    public void render(
            MatrixStack matrices,
            VertexConsumer vertices,
            int light,
            int overlay,
            float red,
            float green,
            float blue,
            float alpha
    ) {
        head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        neck.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg1.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg2.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg3.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        leg4.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        tail.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(
            DeerEntity entity,
            float limbAngle,
            float limbDistance,
            float animationProgress,
            float headYaw,
            float headPitch
    ) {
        head.pitch = headPitch * 0.017453292f;
        head.yaw = headYaw * 0.017453292f;

        body.pitch = (float) (Math.PI / 2f);

        leg1.pitch = MathHelper.cos(limbAngle * 0.8f) * 1.4f * limbDistance;
        leg2.pitch = MathHelper.cos(limbAngle * 0.8f + (float) Math.PI) * 1.4f * limbDistance;
        leg3.pitch = MathHelper.cos(limbAngle * 0.8f + (float) Math.PI) * 1.4f * limbDistance;
        leg4.pitch = MathHelper.cos(limbAngle * 0.8f) * 1.4f * limbDistance;

    }

    private void setRotationAngle(ModelPart part, Float pitch, Float yaw, Float roll) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        part.pitch = pitch;
        part.yaw = yaw;
        part.roll = roll;
    }
}
