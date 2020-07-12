package rocks.sakira.gentlefawn.register;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.item.GentleFawnItemGroup;
import rocks.sakira.gentlefawn.item.SupplierSpawnEggItem;

public class Items {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, GentleFawn.MOD_ID);

    private static final ItemGroup GROUP = new GentleFawnItemGroup("gentlefawn") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DEER_SPAWN_EGG.get());
        }
    };

    public static final RegistryObject<SpawnEggItem> DEER_SPAWN_EGG = REGISTER.register(
            "deer_spawn_egg",

            () -> new SupplierSpawnEggItem(
                    Entities.DEER_ENTITY,
                    0xB49D8A,
                    0xF6F3EF,

                    (new Item.Properties())
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> VENISON_ITEM = REGISTER.register(
            "venison",

            () -> new Item(
                    new Item.Properties()
                            .group(GROUP)
                            .food(Foods.BEEF)
            )
    );

    public static final RegistryObject<Item> COOKED_VENISON_ITEM = REGISTER.register(
            "cooked_venison",

            () -> new Item(
                    new Item.Properties()
                            .group(GROUP)
                            .food(Foods.COOKED_BEEF)
            )
    );

    public static final RegistryObject<Item> DOE_HEAD_ITEM = REGISTER.register(
            "doe_head",

            () -> new WallOrFloorItem(
                    Blocks.DOE_HEAD.get(),
                    Blocks.DOE_WALL_HEAD.get(),

                    new Item.Properties()
                            .group(GROUP)
                            .rarity(Rarity.UNCOMMON)
            )
    );

    public static final RegistryObject<Item> BUCK_HEAD_ITEM = REGISTER.register(
            "buck_head",

            () -> new WallOrFloorItem(
                    Blocks.BUCK_HEAD.get(),
                    Blocks.BUCK_WALL_HEAD.get(),

                    new Item.Properties()
                            .group(GROUP)
                            .rarity(Rarity.UNCOMMON)
            )
    );
}
