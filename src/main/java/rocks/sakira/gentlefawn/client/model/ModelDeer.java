package rocks.sakira.gentlefawn.client.model;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import rocks.sakira.gentlefawn.entity.EntityDeer;

public class ModelDeer extends EntityModel<EntityDeer> {
    private final ModelRenderer neck;
    private final ModelRenderer head;
    private final ModelRenderer horns;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer earl;
    private final ModelRenderer earr;
    private final ModelRenderer body;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tail;

    public ModelDeer() {
        // NOTE: If you're modifying a model using a model code generator, you should only need to
        // overwrite the contents of this method, and (if you added or removed a ModelRenderer) the
        // list of properties above.

        textureWidth = 128;
        textureHeight = 32;

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 8.0F, -4.0F);
        setRotationAngle(neck, -0.6981F, 0.0F, 0.0F);
        neck.setTextureOffset(0, 12).addBox(-2.0F, -2.7827F, -8.284F, 4.0F, 5.0F, 9.0F, 0.0F, true);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 2.25F, -10.0F);
        head.setTextureOffset(0, 0).addBox(-3.0F, -3.25F, -4.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
        head.setTextureOffset(24, 0).addBox(-2.0F, -1.25F, -8.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

        horns = new ModelRenderer(this);
        horns.setRotationPoint(0.0F, -3.25F, 1.0F);
        head.addChild(horns);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-2.0F, -2.75F, -0.5F);
        horns.addChild(bone);
        bone.setTextureOffset(76, 23).addBox(0.2F, 0.75F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone.setTextureOffset(74, 25).addBox(0.2F, -2.25F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(2.0F, -2.75F, -0.5F);
        horns.addChild(bone2);
        bone2.setTextureOffset(74, 25).addBox(-1.2F, -2.25F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone2.setTextureOffset(76, 23).addBox(-1.2F, 0.75F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-4.1143F, -5.7857F, -0.9F);
        horns.addChild(bone3);
        setRotationAngle(bone3, 0.0F, -0.2618F, 0.0F);
        bone3.setTextureOffset(70, 18).addBox(0.3904F, -5.2143F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(70, 18).addBox(-0.6096F, -4.2143F, -0.1812F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(72, 20).addBox(-0.6096F, -0.2143F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(74, 18).addBox(0.3904F, -1.2143F, -0.1812F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(72, 23).addBox(0.3904F, 0.7857F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(74, 21).addBox(1.3904F, 1.7857F, -0.1812F, 1.0F, 3.0F, 0.0F, 0.0F, false);
        bone3.setTextureOffset(70, 21).addBox(-0.6096F, 2.7857F, -0.1812F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(4.1143F, -5.7857F, -0.9F);
        horns.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.2618F, 0.0F);
        bone4.setTextureOffset(70, 18).addBox(-1.3904F, -5.2143F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(76, 19).addBox(-0.3904F, -4.2143F, -0.1812F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(72, 20).addBox(-0.3904F, -0.2143F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(74, 18).addBox(-1.3904F, -1.2143F, -0.1812F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(72, 23).addBox(-1.3904F, 0.7857F, -0.1812F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(74, 21).addBox(-2.3904F, 1.7857F, -0.1812F, 1.0F, 3.0F, 0.0F, 0.0F, false);
        bone4.setTextureOffset(72, 20).addBox(-1.3904F, 2.7857F, -0.1812F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-6.575F, -6.375F, -1.8F);
        horns.addChild(bone5);
        setRotationAngle(bone5, 0.0F, -0.4363F, 0.0F);
        bone5.setTextureOffset(70, 21).addBox(0.0094F, 1.375F, -0.2958F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(70, 18).addBox(0.0094F, -2.625F, -0.2958F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(70, 18).addBox(-0.9906F, 0.375F, -0.2958F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone5.setTextureOffset(70, 18).addBox(1.0094F, -1.625F, -0.2958F, 1.0F, 2.0F, 0.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(6.3F, -6.7F, -1.8F);
        horns.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.5236F, 0.0F);
        bone6.setTextureOffset(72, 20).addBox(-1.8062F, 1.7F, -0.35F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(70, 18).addBox(-1.8062F, -1.3F, -0.35F, 1.0F, 2.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(70, 18).addBox(-0.8062F, -2.3F, -0.35F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(70, 18).addBox(0.1938F, 0.7F, -0.35F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        bone6.setTextureOffset(76, 19).addBox(-1.8062F, -1.3F, -0.35F, 1.0F, 0.0F, 0.0F, 0.0F, false);

        earl = new ModelRenderer(this);
        earl.setRotationPoint(-3.5F, -3.25F, 0.5F);
        head.addChild(earl);
        setRotationAngle(earl, 0.0F, 0.0F, -0.9599F);
        earl.setTextureOffset(32, 16).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, true);

        earr = new ModelRenderer(this);
        earr.setRotationPoint(3.5F, -3.25F, 0.5F);
        head.addChild(earr);
        setRotationAngle(earr, 0.0F, 0.0F, 0.9599F);
        earr.setTextureOffset(32, 23).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 8.1667F, 0.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(40, 0).addBox(-4.0F, -8.1667F, -4.0F, 8.0F, 18.0F, 7.0F, 0.0F, true);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(2.6F, 10.0F, -6.5F);
        leg1.setTextureOffset(94, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-2.6F, 10.0F, -6.5F);
        leg2.setTextureOffset(106, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(2.6F, 10.0F, 7.5F);
        leg3.setTextureOffset(70, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(-2.6F, 10.0F, 7.5F);
        leg4.setTextureOffset(82, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, 0.0F, true);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 9.0F, 10.0F);
        setRotationAngle(tail, 0.4363F, 0.0F, 0.0F);
        tail.setTextureOffset(32, 8).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(EntityDeer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // NOTE: Model code generators may tell you that this method is no longer used and that we should
        // defer to the `render` method.
        //
        // Model code generators are wrong.

        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.8F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.8F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.8F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.8F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        // NOTE: Do not modify this method unless you've added more ModelRenderers and they aren't parented
        // to any of the renderers listed here, either directly or indirectly. If you render a parent model
        // as well as the model itself, the model will be rendered twice in different locations.

        head.render(matrixStack, buffer, packedLight, packedOverlay);
        neck.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
