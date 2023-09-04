package sirjain.throwable_fluids.entity.splasher;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SplasherModel extends EntityModel<SplasherEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart head;
	private final ModelPart body;

	public SplasherModel(ModelPart part) {
		root = part;
		main = root.getChild("splasher");
		tail = main.getChild("tail");
		tail2 = tail.getChild("tail2");
		body = main.getChild("body");
		head = body.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData splasher = modelPartData.addChild("splasher", ModelPartBuilder.create(), ModelTransform.pivot(1.83F, 20.035F, -11.475F));
		ModelPartData tail = splasher.addChild("tail", ModelPartBuilder.create().uv(0, 29).cuboid(0.295F, -5.365F, 2.86F, 0.0F, 5.0F, 7.0F, new Dilation(0.0F))
			.uv(0, 19).cuboid(-2.425F, -2.3225F, -0.37F, 5.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.965F, -1.61F, 10.34F));
		ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(29, 25).mirrored().cuboid(-9.76F, -3.66F, -1.22F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.965F, 1.11F, 5.66F, 0.0F, 0.0F, -0.6545F));
		ModelPartData cube_r2 = tail.addChild("cube_r2", ModelPartBuilder.create().uv(29, 25).cuboid(3.76F, -3.66F, -1.22F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-3.695F, 1.11F, 5.66F, 0.0F, 0.0F, 0.6545F));
		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(22, 6).cuboid(-0.0908F, -2.7202F, -0.5381F, 0.0F, 6.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0308F, -0.5173F, 12.0781F));
		ModelPartData body = splasher.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.17F, -2.475F, -13.05F, 7.0F, 6.0F, 13.0F, new Dilation(0.0F))
			.uv(0, 29).cuboid(0.33F, -7.225F, -9.8F, 0.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 10.0F));
		ModelPartData cube_r3 = body.addChild("cube_r3", ModelPartBuilder.create().uv(29, 25).mirrored().cuboid(-9.76F, -3.66F, -1.22F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, 2.0F, -10.0F, 0.0F, 0.0F, -0.6545F));
		ModelPartData cube_r4 = body.addChild("cube_r4", ModelPartBuilder.create().uv(29, 25).cuboid(3.76F, -3.66F, -1.22F, 6.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.66F, 2.0F, -10.0F, 0.0F, 0.0F, 0.6545F));
		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(27, 0).cuboid(-2.34F, -2.44F, -4.76F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.44F, 1.66F, -13.17F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SplasherEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		tail.yaw = MathHelper.cos(-20 + animationProgress * 0.2f) * 0.3f;
		tail2.yaw = MathHelper.cos(-40 + animationProgress * 0.2f) * 0.45f;
		head.yaw = (MathHelper.cos(-10 + animationProgress * 0.2f) * 0.12f);
		main.pivotX = -(MathHelper.cos(animationProgress * 0.2f) * 1.25f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.pop();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}
}