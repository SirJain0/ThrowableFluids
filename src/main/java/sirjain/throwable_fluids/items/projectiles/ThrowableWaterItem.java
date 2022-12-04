package sirjain.throwable_fluids.items.projectiles;

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
import sirjain.throwable_fluids.entity.projectiles.ThrowableWaterEntity;

public class ThrowableWaterItem extends Item {
    short cooldown = 3;
    short maxNum = 32;

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
            throwableWaterEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.8F, 0F);
            world.spawnEntity(throwableWaterEntity);

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            // Insert random item into the player's inventory - Gold nuggets, prismarine crystals, ender pearls, charcoal, or phantom membranes.
            if (world.random.nextInt(maxNum) == 0 || world.random.nextInt(maxNum) == 4) {
                user.getInventory().insertStack(new ItemStack(Items.GOLD_NUGGET));
            } else if (world.random.nextInt(maxNum) == 1) {
                user.getInventory().insertStack(new ItemStack(Items.PRISMARINE_CRYSTALS));
            } else if (world.random.nextInt(maxNum) == 2) {
                user.getInventory().insertStack(new ItemStack(Items.ENDER_PEARL));
            } else if (world.random.nextInt(maxNum) == 3) {
                user.getInventory().insertStack(new ItemStack(Items.CHARCOAL));
            } else if (world.random.nextInt(maxNum) == 5) {
                user.getInventory().insertStack(new ItemStack(Items.PHANTOM_MEMBRANE));
            }

            user.playerScreenHandler.sendContentUpdates();
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}