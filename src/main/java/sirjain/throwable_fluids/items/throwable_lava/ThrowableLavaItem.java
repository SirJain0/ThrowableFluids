package sirjain.throwable_fluids.items.throwable_lava;

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

public class ThrowableLavaItem extends Item {
    short cooldown = 3;
    short maxNum = 8;

    public ThrowableLavaItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent

            user.getItemCooldownManager().set(this, cooldown);

            // Spawns the projectile
            ThrowableLavaEntity throwableLavaEntity = new ThrowableLavaEntity(world, user);
            throwableLavaEntity.setItem(itemStack);
            throwableLavaEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.75F, 0F);
            world.spawnEntity(throwableLavaEntity);

            user.incrementStat(Stats.USED.getOrCreateStat(this));

            if (!user.getAbilities().creativeMode) {
                (itemStack).decrement(1);
            }

            if (world.random.nextInt(maxNum) == 0) {
                user.getInventory().insertStack(new ItemStack(Items.IRON_NUGGET));
                user.playerScreenHandler.sendContentUpdates();
            }
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }
}