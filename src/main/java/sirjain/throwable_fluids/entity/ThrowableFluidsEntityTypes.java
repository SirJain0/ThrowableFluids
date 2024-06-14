package sirjain.throwable_fluids.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
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
	public static final EntityType<ThrowableWaterEntity> THROWABLE_WATER_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "throwable_water"),
		FabricEntityTypeBuilder.<ThrowableWaterEntity>create(SpawnGroup.MISC, ThrowableWaterEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // In-game dimensions
			.trackRangeBlocks(8).trackedUpdateRate(10)
			.build()
	);

	public static final EntityType<ThrowableLavaEntity> THROWABLE_LAVA_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "throwable_lava"),
		FabricEntityTypeBuilder.<ThrowableLavaEntity>create(SpawnGroup.MISC, ThrowableLavaEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // In-game dimensions
			.trackRangeBlocks(8).trackedUpdateRate(10)
			.build()
	);
}