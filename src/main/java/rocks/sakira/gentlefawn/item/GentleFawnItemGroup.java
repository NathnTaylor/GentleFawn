package rocks.sakira.gentlefawn.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GentleFawnItemGroup extends ItemGroup {
    public GentleFawnItemGroup(String label) {
        super(label);
    }

    public GentleFawnItemGroup(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack createIcon() {
        return null;
    }
}
