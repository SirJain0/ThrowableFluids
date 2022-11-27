package sirjain.throwable_fluids.items.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableWaterEntity extends ThrownItemEntity {
    public static final Fluid fluid = Fluids.WATER;

    public ThrowableWaterEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrowableWaterEntity(World world, LivingEntity owner) {
        super(ModEntityTypes.THROWABLE_WATER_ENTITY, owner, world);
    }

    // Method is called when colliding with anything
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.kill();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!world.isClient) {
            Entity entity = entityHitResult.getEntity();
            entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 0);
            this.kill();
        }
    }

    // Method is called when colliding with a block
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        System.out.println("Hit a block!");
        world.setBlockState(getBlockPos(), fluid.getDefaultState().getBlockState(), 11);
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWABLE_WATER;
    }

    @Override
    protected float getGravity() {
        return 0.05F;
    }
}