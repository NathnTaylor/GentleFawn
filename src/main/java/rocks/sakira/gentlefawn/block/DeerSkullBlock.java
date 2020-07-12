package rocks.sakira.gentlefawn.block;

import net.minecraft.block.SkullBlock;

public class DeerSkullBlock extends SkullBlock {
    public DeerSkullBlock(ISkullType type, Properties properties) {
        super(type, properties);
    }

    public enum Types implements ISkullType {
        DOE,
        BUCK
    }
}
