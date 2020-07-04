package com.sakira.gentlefawn.client.model;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sakira.gentlefawn.entity.EntityDeer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDeer extends EntityModel<EntityDeer> {
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer horns;
	private final ModelRenderer earl;
	private final ModelRenderer earr;
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer tail;

	public ModelDeer() {
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
		horns.setRotationPoint(3.5F, -3.25F, 0.5F);
		head.addChild(horns);
		horns.setTextureOffset(76, 23).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 21).addBox(-1.0F, -5.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(72, 20).addBox(0.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(70, 18).addBox(1.0F, -8.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 18).addBox(0.0F, -10.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 18).addBox(-8.0F, -10.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(76, 19).addBox(-10.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(76, 19).addBox(2.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 25).addBox(0.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(72, 23).addBox(1.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(72, 20).addBox(-8.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(70, 18).addBox(-9.0F, -8.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 25).addBox(-8.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(72, 23).addBox(-9.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(74, 21).addBox(-7.0F, -5.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		horns.setTextureOffset(76, 23).addBox(-6.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);

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
	public void setRotationAngles(EntityDeer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.body.rotateAngleX = ((float)Math.PI / 2F);
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.8F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.8F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.8F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.8F) * 1.4F * limbSwingAmount;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
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
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}