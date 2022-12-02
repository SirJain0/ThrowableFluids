package sirjain.throwable_fluids.items;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.throwable_lava.ThrowableLavaItem;
import sirjain.throwable_fluids.items.throwable_water.ThrowableWaterItem;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModItems {
    public static Item SPLASHED_GEL;
    public static Item WORM_ESSENCE;
    public static Item SPLASHER_FISH;
    public static Item GLOW_WORM_SPAWN_EGG;
    public static Item SPLASHER_SPAWN_EGG;
    public static Item THROWABLE_WATER;
    public static Item THROWABLE_LAVA;
    public static Item SPLASHER_BUCKET;

    public static void registerModItems() {
        THROWABLE_WATER = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "throwable_water"),
                new ThrowableWaterItem(new Item.Settings().group(ItemGroup.BREWING).maxCount(32))
        );

        THROWABLE_LAVA = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "throwable_lava"),
                new ThrowableLavaItem(new Item.Settings().group(ItemGroup.BREWING).maxCount(32))
        );

        WORM_ESSENCE = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "worm_essence"),
                new WormEssenceItem(new Item.Settings().group(ItemGroup.MISC).fireproof())
        );

        SPLASHED_GEL = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splashed_gel"),
                new Item(new Item.Settings().group(ItemGroup.MISC))
        );

        SPLASHER_FISH = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splasher_fish"),
                new Item(new Item.Settings().food(ModFoodComponents.SPLASHER_FISH).group(ItemGroup.FOOD))
        );

        SPLASHER_BUCKET = Registry.register(
                Registry.ITEM,
                new Identifier(ThrowableFluids.MOD_ID, "splasher_bucket"),
                new EntityBucketItem(ModEntityTypes.SPLASHER_ENTITY, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, (new Item.Settings()).maxCount(1).group(ItemGroup.MISC))
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