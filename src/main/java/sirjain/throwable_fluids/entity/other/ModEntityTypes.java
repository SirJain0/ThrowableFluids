package sirjain.throwable_fluids.entity.other;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.splasher.SplasherEntity;
import sirjain.throwable_fluids.entity.splasher.SplasherModel;
import sirjain.throwable_fluids.entity.splasher.SplasherRenderer;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModEntityTypes {
    public static final EntityModelLayer SPLASHER_LAYER = new EntityModelLayer(new Identifier(ThrowableFluids.MOD_ID, "splasher"), "root");
    public static final EntityType<SplasherEntity> SPLASHER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableFluids.MOD_ID, "splasher"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SplasherEntity::new).dimensions(EntityDimensions.fixed(1.25f, 2f)).build()
    );

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntityTypes.SPLASHER_ENTITY, SplasherEntity.createSplasherAttributes());
    }

    public static void registerEntityRender() {
        EntityRendererRegistry.register(ModEntityTypes.SPLASHER_ENTITY, SplasherRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SPLASHER_LAYER, SplasherModel::getTexturedModelData);
    }
}
