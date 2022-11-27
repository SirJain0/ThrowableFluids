package sirjain.throwable_fluids.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WormEssenceItem extends Item {
    public WormEssenceItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}