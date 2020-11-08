package io.github.faecraft.gentlefawn.mixin;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SkullBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockEntityType.class)
public interface BlockEntityTypeAccessor {
    @Accessor("SKULL")
    static BlockEntityType<SkullBlockEntity> getSkull() throws IllegalAccessException {
        throw new IllegalAccessException();
    };

    @Accessor("SKULL")
    static void setSkull(BlockEntityType<SkullBlockEntity> skull) throws IllegalAccessException {
        throw new IllegalAccessException();
    };
}
