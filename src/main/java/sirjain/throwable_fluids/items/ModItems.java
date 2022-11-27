package sirjain.throwable_fluids.items;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.projectile.ThrowableWaterItem;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModItems {
    public static Item SPLASHED_GEL;
    public static Item WORM_CREAM;
    public static Item SPLASHER_FISH;
    public static Item GLOW_WORM_SPAWN_EGG;
    public static Item SPLASHER_SPAWN_EGG;
    public static Item THROWABLE_WATER;

    public static void registerModItems() {
        WORM_CREAM = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "worm_cream"),
                new Item(new Item.Settings().group(ItemGroup.MISC).fireproof())
        );

        SPLASHED_GEL = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splashed_gel"),
                new Item(new Item.Settings().group(ItemGroup.MISC).fireproof())
        );

        SPLASHER_FISH = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splasher_fish"),
                new Item(new Item.Settings().food(ModFoodComponents.SPLASHER_FISH).group(ItemGroup.MISC))
        );

        THROWABLE_WATER = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "throwable_water"),
                new ThrowableWaterItem(new Item.Settings().group(ItemGroup.MISC).maxCount(16))
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