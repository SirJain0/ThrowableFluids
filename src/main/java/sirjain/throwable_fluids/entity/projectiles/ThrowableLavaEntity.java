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

public class ThrowableLavaEntity extends ThrownItemEntity {
    public static final BlockState fluid = Fluids.LAVA.getDefaultState().getBlockState();

    public ThrowableLavaEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrowableLavaEntity(World world, LivingEntity owner) {
        super(ModEntityTypes.THROWABLE_LAVA_ENTITY, owner, world);
    }

    // Method is called when colliding with anything
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            getWorld().setBlockState(getBlockPos(), fluid, 11);
            this.kill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWABLE_LAVA;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }
}