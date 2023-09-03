package sirjain.throwable_fluids.entity.other;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
	public static void registerEntitySpawns() {
		registerSplasherSpawns();
		registerGlowWormSpawns();
		registerSpawnRestrictions();
	}

	public static void registerSplasherSpawns() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER, BiomeKeys.RIVER, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.OCEAN), SpawnGroup.WATER_CREATURE, ModEntityTypes.SPLASHER_ENTITY, 64, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.DEEP_COLD_OCEAN), SpawnGroup.WATER_CREATURE, ModEntityTypes.SPLASHER_ENTITY, 66, 2, 5);
	}

	public static void registerGlowWormSpawns() {
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT, BiomeKeys.NETHER_WASTES, BiomeKeys.CRIMSON_FOREST), SpawnGroup.CREATURE, ModEntityTypes.GLOW_WORM_ENTITY, 95, 2, 3);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST), SpawnGroup.CREATURE, ModEntityTypes.GLOW_WORM_ENTITY, 50, 2, 4);
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.CREATURE, ModEntityTypes.GLOW_WORM_ENTITY, 70, 1, 2);
	}

	public static void registerSpawnRestrictions() {
		SpawnRestriction.register(ModEntityTypes.GLOW_WORM_ENTITY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canMobSpawn);
		SpawnRestriction.register(ModEntityTypes.SPLASHER_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);
	}
}