package sirjain.throwable_fluids.entity.splasher;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class SplasherRenderer extends MobEntityRenderer<SplasherEntity, SplasherModel> {
	public SplasherRenderer(EntityRendererFactory.Context context) {
		super(context, new SplasherModel(context.getPart(ModEntityTypes.SPLASHER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SplasherEntity entity) {
		return new Identifier(ThrowableFluids.MOD_ID, "textures/entity/splasher.png");
	}
}