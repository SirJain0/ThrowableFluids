package sirjain.throwable_fluids.items.throwable_water;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormEntity;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableWaterEntity extends ThrownItemEntity {
    public static final BlockState fluid = Fluids.WATER.getDefaultState().getBlockState();

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
            short a = 2;
            short b = 1;

            Entity entity = entityHitResult.getEntity();

            if (entity instanceof BlazeEntity ||
                    entity instanceof GlowWormEntity ||
                    entity instanceof MagmaCubeEntity ||
                    entity instanceof StriderEntity)
            {
                entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), a);
            } else {
                entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), b);
            }

            this.kill();
        }
    }

    // Method is called when colliding with a block
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        world.setBlockState(getBlockPos(), fluid, 11);
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWABLE_WATER;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }
}