package rocks.sakira.gentlefawn.register;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.item.GentleFawnItemGroup;
import rocks.sakira.gentlefawn.item.SupplierSpawnEggItem;

public class Items {
    public static final DeferredRegister<Item> REGISTER = new DeferredRegister<>(ForgeRegistries.ITEMS, GentleFawn.MOD_ID);

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
}
