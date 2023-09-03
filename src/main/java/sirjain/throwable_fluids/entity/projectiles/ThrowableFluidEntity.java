package sirjain.throwable_fluids.entity.projectiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;

public abstract class ThrowableFluidEntity extends ThrownItemEntity {
    public ThrowableFluidEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrowableFluidEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
        super(entityType, owner, world);
    }

    // Method is called when colliding with anything
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        World world = this.getWorld();

        if (!world.isClient) {
            world.setBlockState(getBlockPos(), getFluid(), 11);
            this.kill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }

    public BlockState getFluid() {
        return null;
    }
}