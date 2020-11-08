package io.github.faecraft.gentlefawn.mixin_handlers

import com.google.common.collect.ImmutableSet
import io.github.faecraft.gentlefawn.mixin.BlockEntityTypeBuilderAccessor
import io.github.faecraft.gentlefawn.register.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

object BlockEntityTypeHandler {
    fun create(
        name: String,
        builder: BlockEntityType.Builder<*>,
        cir: CallbackInfoReturnable<BlockEntityType<*>>
    ) {
        if (name == "skull") {
            val blocks = (builder as BlockEntityTypeBuilderAccessor).blocks.toMutableSet()

            blocks.add(Blocks.DOE_HEAD)
            blocks.add(Blocks.DOE_HEAD_WALL)
            blocks.add(Blocks.BUCK_HEAD)
            blocks.add(Blocks.BUCK_HEAD_WALL)

            (builder as BlockEntityTypeBuilderAccessor).blocks = ImmutableSet.copyOf(blocks)
        }
    }
}
