package sirjain.throwable_fluids.entity.other;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormEntity;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormModel;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormRenderer;
import sirjain.throwable_fluids.entity.projectiles.ThrowableFluidEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableLavaEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableWaterEntity;
import sirjain.throwable_fluids.entity.splasher.SplasherEntity;
import sirjain.throwable_fluids.entity.splasher.SplasherModel;
import sirjain.throwable_fluids.entity.splasher.SplasherRenderer;

import static sirjain.throwable_fluids.main.ThrowableFluids.MOD_ID;

public class TFEntityTypes {
	public static final EntityModelLayer SPLASHER_LAYER = new EntityModelLayer(new Identifier(MOD_ID, "splasher"), "root");
	public static final EntityType<SplasherEntity> SPLASHER_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "splasher"),
		FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, SplasherEntity::new)
			.dimensions(EntityDimensions.fixed(1.25f, 2f))
			.build()
	);

	public static final EntityModelLayer GLOW_WORM_LAYER = new EntityModelLayer(new Identifier(MOD_ID, "glow_worm"), "root");
	public static final EntityType<GlowWormEntity> GLOW_WORM_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "glow_worm"),
		FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlowWormEntity::new)
			.fireImmune()
			.dimensions(EntityDimensions.fixed(0.75f, 0.75f))
			.build()
	);

	public static final EntityType<ThrowableWaterEntity> THROWABLE_WATER_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "throwable_water"),
		FabricEntityTypeBuilder.<ThrowableWaterEntity>create(SpawnGroup.MISC, ThrowableWaterEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // In-game dimensions
			.trackRangeBlocks(8).trackedUpdateRate(10)
			.build()
	);

	public static final EntityType<ThrowableFluidEntity> THROWABLE_LAVA_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(MOD_ID, "throwable_lava"),
		FabricEntityTypeBuilder.<ThrowableFluidEntity>create(SpawnGroup.MISC, ThrowableLavaEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // In-game dimensions
			.trackRangeBlocks(8).trackedUpdateRate(10)
			.build()
	);

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(TFEntityTypes.SPLASHER_ENTITY, SplasherEntity.createSplasherAttributes());
		FabricDefaultAttributeRegistry.register(TFEntityTypes.GLOW_WORM_ENTITY, GlowWormEntity.createGlowWormAttributes());
	}

	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(TFEntityTypes.SPLASHER_ENTITY, SplasherRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(SPLASHER_LAYER, SplasherModel::getTexturedModelData);

		EntityRendererRegistry.register(TFEntityTypes.GLOW_WORM_ENTITY, GlowWormRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(GLOW_WORM_LAYER, GlowWormModel::getTexturedModelData);

		EntityRendererRegistry.register(TFEntityTypes.THROWABLE_WATER_ENTITY, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(TFEntityTypes.THROWABLE_LAVA_ENTITY, FlyingItemEntityRenderer::new);
	}
}