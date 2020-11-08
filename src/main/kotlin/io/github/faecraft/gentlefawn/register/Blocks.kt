package io.github.faecraft.gentlefawn.register

import io.github.faecraft.gentlefawn.Common.MOD_ID
import io.github.faecraft.gentlefawn.block.UtilSkullBlock
import io.github.faecraft.gentlefawn.block.UtilSkullWallBlock
import io.github.faecraft.gentlefawn.enum.DeerSkullType
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.SkullBlock
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Blocks {
    val DOE_HEAD = createSkullBlock(DeerSkullType.DOE)
    val DOE_HEAD_WALL = createSkullWallBlock(DeerSkullType.DOE, DOE_HEAD)

    val BUCK_HEAD = createSkullBlock(DeerSkullType.BUCK)
    val BUCK_HEAD_WALL = createSkullWallBlock(DeerSkullType.BUCK, BUCK_HEAD)

    fun register() {
        register(DOE_HEAD, "doe_head")
        register(DOE_HEAD_WALL, "doe_wall_head")

        register(BUCK_HEAD, "buck_head")
        register(BUCK_HEAD_WALL, "buck_wall_head")
    }

    private fun register(block: Block, id: String) {
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, id), block)
    }

    private fun createSkullBlock(type: SkullBlock.SkullType) = UtilSkullBlock(
        type,

        FabricBlockSettings
            .copyOf(Blocks.DRAGON_HEAD)
    )

    private fun createSkullWallBlock(type: SkullBlock.SkullType, dropsLike: Block) = UtilSkullWallBlock(
        type,

        FabricBlockSettings
            .copyOf(Blocks.DRAGON_HEAD)
            .dropsLike(dropsLike)
    )
}
