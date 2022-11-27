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
    public static void entitySpawn() {
        GlowWormSpawn();
        SplasherSpawn();

        SpawnRestriction.register(ModEntityTypes.GLOW_WORM_ENTITY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntityTypes.SPLASHER_ENTITY, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);
    }

    public static void SplasherSpawn() {
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER),
                SpawnGroup.WATER_CREATURE,
                ModEntityTypes.SPLASHER_ENTITY,
                64,
                3,
                6
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.RIVER),
                SpawnGroup.WATER_CREATURE,
                ModEntityTypes.SPLASHER_ENTITY,
                65,
                2,
                5
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.OCEAN),
                SpawnGroup.WATER_CREATURE,
                ModEntityTypes.SPLASHER_ENTITY,
                65,
                2,
                4
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN),
                SpawnGroup.WATER_CREATURE,
                ModEntityTypes.SPLASHER_ENTITY,
                65,
                2,
                3
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN),
                SpawnGroup.WATER_CREATURE,
                ModEntityTypes.SPLASHER_ENTITY,
                65,
                2,
                5
        );
    }

    public static void GlowWormSpawn() {
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.DESERT),
                SpawnGroup.CREATURE,
                ModEntityTypes.GLOW_WORM_ENTITY,
                65,
                2,
                3
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST),
                SpawnGroup.CREATURE,
                ModEntityTypes.GLOW_WORM_ENTITY,
                50,
                2,
                4
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE,
                ModEntityTypes.GLOW_WORM_ENTITY,
                70,
                1,
                2
        );
    }
}