package io.github.faecraft.gentlefawn.register

import io.github.faecraft.gentlefawn.Common.MOD_ID
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.entity.EntityType
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.registry.Registry

object Items {
    val GROUP: ItemGroup = FabricItemGroupBuilder
        .create(Identifier(MOD_ID, MOD_ID))
        .icon { ItemStack(DOE_HEAD) }
        .build()

    val DEER_SPAWN_EGG = createSpawnEggItem(Entities.DEER, 0xB49D8A, 0xF6F3EF)

    val VENISON = createFoodItem(FoodComponents.BEEF)
    val COOKED_VENISON = createFoodItem(FoodComponents.COOKED_BEEF)

    val DOE_HEAD = createWallStandingBlockItem(Blocks.DOE_HEAD, Blocks.DOE_HEAD_WALL, Rarity.UNCOMMON)
    val BUCK_HEAD = createWallStandingBlockItem(Blocks.BUCK_HEAD, Blocks.BUCK_HEAD_WALL, Rarity.UNCOMMON)

    fun register() {
        register(DEER_SPAWN_EGG, "deer_spawn_egg")

        register(VENISON, "venison")
        register(COOKED_VENISON, "cooked_venison")

        register(DOE_HEAD, "doe_head")
        register(BUCK_HEAD, "buck_head")
    }

    private fun register(item: Item, id: String) {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, id), item)
    }

    private fun createWallStandingBlockItem(blockStanding: Block, blockWall: Block, rarity: Rarity) = WallStandingBlockItem(
        blockStanding,
        blockWall,

        FabricItemSettings()
            .group(GROUP)
            .rarity(rarity)
    )

    private fun createFoodItem(food: FoodComponent) = Item(
        FabricItemSettings()
            .group(GROUP)
            .food(food)
    )

    private fun createSpawnEggItem(entity: EntityType<*>, primaryColor: Int, secondaryColor: Int) = SpawnEggItem(
        entity,
        primaryColor,
        secondaryColor,
        FabricItemSettings()
            .group(GROUP)
    )
}
