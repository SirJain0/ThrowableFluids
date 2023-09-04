package sirjain.throwable_fluids.entity.projectiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.other.TFEntityTypes;
import sirjain.throwable_fluids.items.TFItems;

public class ThrowableWaterEntity extends ThrowableFluidEntity {
	public ThrowableWaterEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public ThrowableWaterEntity(World world, LivingEntity owner) {
		super(TFEntityTypes.THROWABLE_WATER_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return TFItems.THROWABLE_WATER;
	}

	@Override
	public BlockState getFluid() {
		return Fluids.WATER.getDefaultState().getBlockState();
	}
}