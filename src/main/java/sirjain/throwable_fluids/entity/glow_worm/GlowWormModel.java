package sirjain.throwable_fluids.entity.glow_worm;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GlowWormModel extends EntityModel<GlowWormEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart body;

	public GlowWormModel(ModelPart part) {
		root = part;
		main = root.getChild("grub");
		head = main.getChild("head");
		body = main.getChild("body");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData grub = modelPartData.addChild("grub", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData head = grub.addChild("head", ModelPartBuilder.create().uv(14, 20).cuboid(-2.03F, -4.0F, -7.65F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData body = grub.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.04F, -6.0F, -0.74F, 6.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(GlowWormEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		head.yaw = MathHelper.cos(animationProgress * 0.8f) * 0.1f;
		body.yaw = MathHelper.sin(animationProgress * 0.8f) * 0.04f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}