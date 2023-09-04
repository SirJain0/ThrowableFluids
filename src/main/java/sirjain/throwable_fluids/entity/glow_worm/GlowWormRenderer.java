package sirjain.throwable_fluids.entity.glow_worm;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import sirjain.throwable_fluids.entity.other.GlowWormEmissiveTextureFeature;
import sirjain.throwable_fluids.entity.other.TFEntityTypes;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class GlowWormRenderer extends MobEntityRenderer<GlowWormEntity, GlowWormModel> {
	public static final Identifier TEXTURE = new Identifier(ThrowableFluids.MOD_ID, "textures/entity/worm.png");

	public GlowWormRenderer(EntityRendererFactory.Context context) {
		super(context, new GlowWormModel(context.getPart(TFEntityTypes.GLOW_WORM_LAYER)), 0.5f);
		this.addFeature(new GlowWormEmissiveTextureFeature<>(this));
	}

	@Override
	public Identifier getTexture(GlowWormEntity entity) {
		return TEXTURE;
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(GlowWormEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return super.getRenderLayer(entity, showBody, true, showOutline);
	}
}