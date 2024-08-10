package sirjain.throwable_fluids.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.projectiles.ThrowableFluidEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableLavaEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableWaterEntity;

import static sirjain.throwable_fluids.ThrowableFluids.MOD_ID;

public class ThrowableFluidsEntityTypes {
	public static EntityType<? extends ThrowableFluidEntity> THROWABLE_WATER_ENTITY;
	public static EntityType<? extends ThrowableFluidEntity> THROWABLE_LAVA_ENTITY;

	public static void registerEntityTypes() {
		THROWABLE_WATER_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			Identifier.of(MOD_ID, "throwable_water"),
			EntityType.Builder.<ThrowableWaterEntity>create(ThrowableWaterEntity::new, SpawnGroup.MISC)
				.dimensions(0.25F, 0.25F)
				.maxTrackingRange(8).trackingTickInterval(10)
				.build()
		);

		THROWABLE_LAVA_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			Identifier.of(MOD_ID, "throwable_lava"),
			EntityType.Builder.<ThrowableLavaEntity>create(ThrowableLavaEntity::new, SpawnGroup.MISC)
				.dimensions(0.25F, 0.25F)
				.maxTrackingRange(8).trackingTickInterval(10)
				.build()
		);
	}
}