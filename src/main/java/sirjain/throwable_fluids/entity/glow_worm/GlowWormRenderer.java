package sirjain.throwable_fluids.entity.glow_worm;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class GlowWormRenderer extends MobEntityRenderer<GlowWormEntity, GlowWormModel> {
    public GlowWormRenderer(EntityRendererFactory.Context context) {
        super(context, new GlowWormModel(context.getPart(ModEntityTypes.GLOW_WORM_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(GlowWormEntity entity) {
        return new Identifier(ThrowableFluids.MOD_ID, "textures/entity/worm.png");
    }
}