package sirjain.throwable_fluids.items.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableWaterEntity extends ThrownItemEntity {
    private final Fluid fluid = Fluids.WATER;

    public ThrowableWaterEntity(EntityType<? extends ThrowableWaterEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.world.isClient) {
            System.out.println("Threw the projectile!");

            BlockHitResult blockHitResult = (BlockHitResult)hitResult;
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);

            placeFluid((PlayerEntity) getOwner(), world, blockPos2, blockHitResult);
            this.discard();
        }
    }

    public boolean placeFluid(PlayerEntity owner, World world, BlockPos pos, @Nullable BlockHitResult hitResult) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        Material material = blockState.getMaterial();
        boolean bl = blockState.canBucketPlace(fluid);
        boolean bl2 = blockState.isAir() || bl || block instanceof FluidFillable && ((FluidFillable)block).canFillWithFluid(world, pos, blockState, this.fluid);
        if (!bl2) {
            return hitResult != null && this.placeFluid(owner, world, hitResult.getBlockPos().offset(hitResult.getSide()), (BlockHitResult)null);
        } else if (world.getDimension().ultrawarm() && fluid.isIn(FluidTags.WATER)) {
            int i = pos.getX();
            int j = pos.getY();
            int k = pos.getZ();

            for(int l = 0; l < 8; ++l) {
                world.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0, 0.0, 0.0);
            }

            return true;
        } else if (block instanceof FluidFillable && fluid == Fluids.WATER) {
            ((FluidFillable)block).tryFillWithFluid(world, pos, blockState, ((FlowableFluid)fluid).getStill(false));
            return true;
        } else {
            if (!world.isClient && bl && !material.isLiquid()) {
                world.breakBlock(pos, true);
            }

            return world.setBlockState(pos, fluid.getDefaultState().getBlockState(), 11) || blockState.getFluidState().isStill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWABLE_WATER;
    }
}
