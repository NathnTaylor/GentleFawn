package rocks.sakira.gentlefawn.block.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DoeHeadModel extends GenericHeadModel {
    private final ModelRenderer head;
    private final ModelRenderer bone8;
    private final ModelRenderer bone7;

    public DoeHeadModel() {
        textureWidth = 72;
        textureHeight = 84;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 16.0F, 0.0F);
        head.setTextureOffset(24, 36).addBox(-6.0F, -4.0F, -20.0F, 12.0F, 12.0F, 12.0F, 0.0F, true);
        head.setTextureOffset(0, 0).addBox(-9.0F, -10.0F, -8.0F, 18.0F, 18.0F, 18.0F, 0.0F, true);

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
        matrixStackIn.translate(0, -0.75F, 0);
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        matrixStackIn.rotate(new Quaternion(0, 180, 0, true));

        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

        matrixStackIn.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
