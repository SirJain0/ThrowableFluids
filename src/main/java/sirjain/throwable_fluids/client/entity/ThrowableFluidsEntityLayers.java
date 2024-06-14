package sirjain.throwable_fluids.client.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import sirjain.throwable_fluids.entity.ThrowableFluidsEntityTypes;

public class ThrowableFluidsEntityLayers {
	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(ThrowableFluidsEntityTypes.THROWABLE_WATER_ENTITY, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ThrowableFluidsEntityTypes.THROWABLE_LAVA_ENTITY, FlyingItemEntityRenderer::new);
	}
}
