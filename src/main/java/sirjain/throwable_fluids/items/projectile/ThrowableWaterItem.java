package sirjain.throwable_fluids.items.projectile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;

public class ThrowableWaterItem extends Item {
    public ThrowableWaterItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            ThrowableWaterEntity throwableWaterEntity = new ThrowableWaterEntity(ModEntityTypes.THROWABLE_WATER_TYPE, world);
            throwableWaterEntity.setItem(itemStack);
            throwableWaterEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2F, 1.0F);
            world.spawnEntity(throwableWaterEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
