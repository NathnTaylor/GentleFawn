package rocks.sakira.gentlefawn.block.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BuckHeadModel extends GenericHeadModel {
    private final ModelRenderer head;
    private final ModelRenderer horns2;
    private final ModelRenderer bone9;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer bone12;
    private final ModelRenderer bone13;
    private final ModelRenderer bone14;
    private final ModelRenderer bone8;
    private final ModelRenderer bone7;

    public BuckHeadModel() {
        textureWidth = 72;
        textureHeight = 84;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, 0.0F);
        head.setTextureOffset(24, 36).addBox(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true);
        head.setTextureOffset(0, 0).addBox(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true);

        horns2 = new ModelRenderer(this);
        horns2.setRotationPoint(0.0F, -17.0F, 6.0F);
        head.addChild(horns2);

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-2.0F, -2.75F, -0.5F);
        horns2.addChild(bone9);
        bone9.setTextureOffset(45, 63).addBox(-3.0F, 3.75F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone9.setTextureOffset(27, 66).addBox(-3.0F, -5.25F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(2.0F, -2.75F, -0.5F);
        horns2.addChild(bone10);
        bone10.setTextureOffset(27, 66).addBox(-0.1F, -5.25F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone10.setTextureOffset(45, 63).addBox(0.0F, 3.75F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(-4.1143F, -5.7857F, -0.9F);
        horns2.addChild(bone11);
        setRotationAngle(bone11, 0.0F, -0.2618F, 0.0F);
        bone11.setTextureOffset(27, 60).addBox(-6.7357F, -20.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 66).addBox(-9.7357F, -17.2143F, 0.6F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 66).addBox(-6.7357F, -8.2143F, 0.6F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(27, 72).addBox(-9.7357F, -5.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 60).addBox(-6.7357F, -2.2143F, 0.6F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(45, 60).addBox(-3.7357F, 0.7857F, 0.6F, 3.0F, 9.0F, 0.0F, 0.0F, false);
        bone11.setTextureOffset(36, 75).addBox(-9.7357F, 3.7857F, 0.6F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(4.1143F, -5.7857F, -0.8F);
        horns2.addChild(bone12);
        setRotationAngle(bone12, 0.0F, 0.2618F, 0.0F);
        bone12.setTextureOffset(27, 60).addBox(3.7357F, -20.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 66).addBox(6.7357F, -17.2143F, 0.5F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(27, 72).addBox(6.7357F, -5.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 66).addBox(3.7357F, -8.2143F, 0.5F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 60).addBox(3.7357F, -2.2143F, 0.5F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(45, 60).addBox(0.7357F, 0.7857F, 0.5F, 3.0F, 9.0F, 0.0F, 0.0F, false);
        bone12.setTextureOffset(36, 81).addBox(3.7357F, 3.7857F, 0.5F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(-6.575F, -6.375F, -1.8F);
        horns2.addChild(bone13);
        setRotationAngle(bone13, 0.0F, -0.4363F, 0.0F);
        bone13.setTextureOffset(36, 75).addBox(-12.825F, -1.625F, 2.05F, 6.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(27, 60).addBox(-12.825F, -13.625F, 2.05F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(27, 66).addBox(-15.825F, -4.625F, 2.05F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone13.setTextureOffset(36, 66).addBox(-9.825F, -10.625F, 2.05F, 3.0F, 6.0F, 0.0F, 0.0F, false);

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(6.4F, -6.7F, -1.8F);
        horns2.addChild(bone14);
        setRotationAngle(bone14, 0.0F, 0.5236F, 0.0F);
        bone14.setTextureOffset(36, 81).addBox(6.8F, -1.3F, 2.7F, 6.0F, 3.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(36, 66).addBox(6.8F, -10.3F, 2.7F, 3.0F, 6.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(27, 60).addBox(9.8F, -13.3F, 2.7F, 3.0F, 3.0F, 0.0F, 0.0F, false);
        bone14.setTextureOffset(27, 66).addBox(12.8F, -4.3F, 2.7F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(-11.5F, -10.0F, 5.5F);
        head.addChild(bone8);
        setRotationAngle(bone8, 0.0F, 0.0F, -1.0472F);
        bone8.setTextureOffset(0, 57).addBox(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(11.5F, -10.0F, 5.5F);
        head.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 1.0472F);
        bone7.setTextureOffset(0, 36).addBox(-4.5F, -9.0F, -1.5F, 9.0F, 18.0F, 3.0F, 0.0F, true);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.push();
        matrixStackIn.translate(0.0D, -0.75F, 0.0D);
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        matrixStackIn.rotate(new Quaternion(0, 180, 0, true));

        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        matrixStackIn.pop();
    }

    public void func_225603_a_(float p_225603_1_, float p_225603_2_, float p_225603_3_) {
        this.head.rotateAngleY = (p_225603_2_ + 180) * ((float) Math.PI / 180F);
        this.head.rotateAngleX = p_225603_3_ * ((float) Math.PI / 180F);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
