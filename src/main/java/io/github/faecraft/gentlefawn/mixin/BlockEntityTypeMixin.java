package io.github.faecraft.gentlefawn.mixin;

import io.github.faecraft.gentlefawn.mixin_handlers.BlockEntityTypeHandler;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {
    @Inject(at = @At("HEAD"), method = "create")
    private static void create(String name, BlockEntityType.Builder<?> builder, CallbackInfoReturnable<BlockEntityType<?>> cir) {
        BlockEntityTypeHandler.INSTANCE.create(name, builder, cir);
    }
}
