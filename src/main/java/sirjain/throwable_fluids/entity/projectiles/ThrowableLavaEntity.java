package sirjain.throwable_fluids.entity.projectiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableLavaEntity extends ThrowableFluidEntity {
	public ThrowableLavaEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public ThrowableLavaEntity(World world, LivingEntity owner) {
		super(ModEntityTypes.THROWABLE_LAVA_ENTITY, world, owner);
	}

	@Override
	protected Item getDefaultItem() {
		return ModItems.THROWABLE_LAVA;
	}

	@Override
	public BlockState getFluid() {
		return Fluids.LAVA.getDefaultState().getBlockState();
	}
}