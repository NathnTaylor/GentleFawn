package rocks.sakira.gentlefawn.client.renderer;


import com.mojang.blaze3d.matrix.MatrixStack;
import rocks.sakira.gentlefawn.client.model.ModelDeer;
import rocks.sakira.gentlefawn.entity.EntityDeer;
import rocks.sakira.gentlefawn.GentleFawn;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RenderDeer extends MobRenderer<EntityDeer, ModelDeer> {
    public RenderDeer(EntityRendererManager renderManager) {
        super(renderManager, new ModelDeer(), 0.6f);
    }

    @Override
    protected void preRenderCallback(EntityDeer entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.isChild()) {
            matrixStackIn.scale(0.66F, 0.66F, 0.66F);
        }
    }

    @Override @Nonnull
    public ResourceLocation getEntityTexture(@Nonnull EntityDeer deer) {
        return deer.isChild() ? this.getEntityTexture("fawn") : this.getEntityTexture(deer.getTextureName());
    }

    private ResourceLocation getEntityTexture(String fileName) {
        return new ResourceLocation(GentleFawn.MOD_ID, "textures/entity/deer/" + fileName + ".png");
    }
}
