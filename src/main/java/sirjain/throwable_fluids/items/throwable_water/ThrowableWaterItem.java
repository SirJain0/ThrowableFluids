package sirjain.throwable_fluids.items.throwable_water;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableWaterItem extends Item {
    short cooldown = 3;
    short maxNum = 8;

    public ThrowableWaterItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

            user.getItemCooldownManager().set(this, cooldown);

            // Spawns the projectile
            ThrowableWaterEntity throwableWaterEntity = new ThrowableWaterEntity(world, user);
            throwableWaterEntity.setItem(itemStack);
            throwableWaterEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.75F, 0F);
            world.spawnEntity(throwableWaterEntity);

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            if (world.random.nextInt(maxNum) == 0) {
                user.getInventory().insertStack(new ItemStack(Items.IRON_NUGGET));
                user.playerScreenHandler.sendContentUpdates();
            }
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}