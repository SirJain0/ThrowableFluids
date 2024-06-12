package sirjain.throwable_fluids.items.projectiles;

import net.minecraft.entity.LivingEntity;
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
import sirjain.throwable_fluids.entity.projectiles.ThrowableFluidEntity;

public abstract class ThrowableFluidItem extends Item {
	public ThrowableFluidItem(Settings settings) {
		super(settings);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);

		if (!world.isClient) {
			ThrowableFluidEntity throwable = getEntity(world, user);
			throwable.setItem(itemStack);
			throwable.setVelocity(user, user.getPitch(), user.getYaw(), 0, 0.8F, 0);
			world.spawnEntity(throwable);

			if (!user.getAbilities().creativeMode) {
				itemStack.decrement(1);
				user.getItemCooldownManager().set(this, 20);
			}

			// Insert random item into the player's inventory - Gold nuggets, prismarine crystals, ender pearls, charcoal, or phantom membranes.
			if (world.random.nextInt(10) == 0) {
				user.getInventory().insertStack(Items.IRON_NUGGET.getDefaultStack());
				user.playerScreenHandler.sendContentUpdates();
			}

			user.incrementStat(Stats.USED.getOrCreateStat(this));
			world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);
		}

		return TypedActionResult.success(itemStack, !world.isClient);
	}

	abstract public ThrowableFluidEntity getEntity(World world, LivingEntity user);
}