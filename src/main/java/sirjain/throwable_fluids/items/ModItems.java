package sirjain.throwable_fluids.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModItems {
    public static void registerModItems() {
        // Register here
    }

    public static void registerMobSpawnEggItems() {
        Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splasher_spawn_egg"),
                new SpawnEggItem(ModEntityTypes.SPLASHER_ENTITY, 0xaa9cff, 0xdcac55, new Item.Settings().group(ItemGroup.MISC))
        );
    }
}