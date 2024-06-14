package sirjain.throwable_fluids.entity.projectiles;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public abstract class ThrowableFluidEntity extends ThrownItemEntity {
	public ThrowableFluidEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public ThrowableFluidEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	// Method is called when colliding with anything
	protected void onCollision(HitResult hitResult) {
		World world = this.getWorld();

		if (!world.isClient) {
//			if (world.getServer() != null) {
//				boolean canPlace = OpenPACServerAPI.get(world.getServer())
//					.getChunkProtection()
//					.onEntityPlaceBlock(this, (ServerWorld) world, this.getBlockPos());
//
//				if (canPlace) {
//					world.setBlockState(getBlockPos(), getFluid(), Block.NOTIFY_LISTENERS);
//				}
//			}
//
//			if (world.getServer() == null) {
//				world.setBlockState(getBlockPos(), getFluid(), Block.NOTIFY_LISTENERS);
//			}

			world.setBlockState(getBlockPos(), getFluid(), Block.NOTIFY_LISTENERS);
			this.kill();
		}

		super.onCollision(hitResult);
		this.kill();
	}

	@Override
	protected Item getDefaultItem() {
		return null;
	}

	@Override
	protected float getGravity() {
		return 0.1f;
	}

	public BlockState getFluid() {
		return null;
	}
}