package sirjain.throwable_fluids.items;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModItems {
    public static Item MORBID_FLESH;
    public static Item MORBID_ESSENCE;
    public static Item GLOW_WORM_SPAWN_EGG;
    public static Item SPLASHER_SPAWN_EGG;

    public static void registerModItems() {
        MORBID_FLESH = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "morbid_flesh"),
                new Item(new Item.Settings().food(ModFoodComponents.MORBID_FLESH).group(ItemGroup.FOOD))
        );

        MORBID_ESSENCE = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "morbid_essence"),
                new Item(new Item.Settings().group(ItemGroup.MISC).fireproof())
        );
    }

    public static void registerMobSpawnEggItems() {
        SPLASHER_SPAWN_EGG = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splasher_spawn_egg"),
                new SpawnEggItem(ModEntityTypes.SPLASHER_ENTITY, 0xaa9cff, 0xdcac55, new Item.Settings().group(ItemGroup.MISC))
        );

        GLOW_WORM_SPAWN_EGG = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "glow_worm_spawn_egg"),
                new SpawnEggItem(ModEntityTypes.GLOW_WORM_ENTITY, 0xa73b3f, 0xff7c1b, new Item.Settings().group(ItemGroup.MISC))
        );
    }
}