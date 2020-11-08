package io.github.faecraft.gentlefawn.mixin;

import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(SkullBlockEntityRenderer.class)
public interface SkullBlockEntityRendererMixin {
    @Accessor("MODELS")
    static Map<SkullBlock.SkullType, SkullEntityModel> getModels() throws IllegalAccessException {
        throw new IllegalAccessException();
    };

    @Accessor("MODELS")
    static void setModels(Map<SkullBlock.SkullType, SkullEntityModel> models) throws IllegalAccessException {
        throw new IllegalAccessException();
    };

    @Accessor("TEXTURES")
    static Map<SkullBlock.SkullType, Identifier> getTextures() throws IllegalAccessException {
        throw new IllegalAccessException();
    };

    @Accessor("TEXTURES")
    static void setTextures(Map<SkullBlock.SkullType, Identifier> models) throws IllegalAccessException {
        throw new IllegalAccessException();
    };
}
