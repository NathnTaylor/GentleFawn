package rocks.sakira.gentlefawn.register;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.gentlefawn.GentleFawn;
import rocks.sakira.gentlefawn.block.DeerSkullBlock;
import rocks.sakira.gentlefawn.block.DeerWallSkullBlock;

import static net.minecraft.block.Blocks.DRAGON_HEAD;

public class Blocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, GentleFawn.MOD_ID);

    public static final RegistryObject<Block> DOE_HEAD = REGISTER.register(
            "doe_head",

            () -> new DeerSkullBlock(
                    DeerSkullBlock.Types.DOE,
                    Block.Properties.from(DRAGON_HEAD)
            )
    );

    public static final RegistryObject<Block> DOE_WALL_HEAD = REGISTER.register(
            "doe_wall_head",

            () -> new DeerWallSkullBlock(
                    DeerSkullBlock.Types.DOE,
                    Block.Properties.from(DRAGON_HEAD)
                        .lootFrom(DOE_HEAD.get())
            )
    );

    public static final RegistryObject<Block> BUCK_HEAD = REGISTER.register(
            "buck_head",

            () -> new DeerSkullBlock(
                    DeerSkullBlock.Types.BUCK,
                    Block.Properties.from(DRAGON_HEAD)
            )
    );

    public static final RegistryObject<Block> BUCK_WALL_HEAD = REGISTER.register(
            "buck_wall_head",

            () -> new DeerWallSkullBlock(
                    DeerSkullBlock.Types.BUCK,
                    Block.Properties.from(DRAGON_HEAD)
                            .lootFrom(BUCK_HEAD.get())
            )
    );
}
