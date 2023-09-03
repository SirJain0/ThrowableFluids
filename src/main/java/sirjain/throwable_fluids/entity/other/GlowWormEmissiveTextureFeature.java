package sirjain.throwable_fluids.entity.other;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormRenderer;

@Environment(EnvType.CLIENT)
public class GlowWormEmissiveTextureFeature<T extends Entity, M extends EntityModel<T>> extends EyesFeatureRenderer<T, M> {
	public GlowWormEmissiveTextureFeature(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	public RenderLayer getEyesTexture() {
		return RenderLayer.getEyes(GlowWormRenderer.TEXTURE);
	}
}