package rocks.sakira.gentlefawn.register;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.item.SupplierSpawnEggItem;

public class Items {
    public static final DeferredRegister<Item> REGISTER = new DeferredRegister<>(ForgeRegistries.ITEMS, GentleFawn.MOD_ID);

    public static final RegistryObject<SpawnEggItem> DEER_SPAWN_EGG = REGISTER.register(
            "deer_spawn_egg",

            () -> new SupplierSpawnEggItem(
                    Entities.DEER_ENTITY,
                    0xB49D8A,
                    0xF6F3EF,

                    (new Item.Properties())
                            .group(ItemGroup.MISC)
            )
    );
}
