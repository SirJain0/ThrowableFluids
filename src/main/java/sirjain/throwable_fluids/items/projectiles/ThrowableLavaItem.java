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
import sirjain.throwable_fluids.entity.projectiles.ThrowableLavaEntity;

public class ThrowableLavaItem extends Item {
    short cooldown = 20;
    short maxNum = 32;

    public ThrowableLavaItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

            user.getItemCooldownManager().set(this, cooldown);

            // Spawns the projectile
            ThrowableLavaEntity throwableLavaEntity = new ThrowableLavaEntity(world, user);
            throwableLavaEntity.setItem(itemStack);
            throwableLavaEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0, 0.8F, 0);
            world.spawnEntity(throwableLavaEntity);

            user.incrementStat(Stats.USED.getOrCreateStat(this));

            if (!user.getAbilities().creativeMode) {
                (itemStack).decrement(1);
            }

            // Insert random item into the player's inventory.
            switch (world.random.nextInt(maxNum)) {
                case 0:
                case 4:
                    addItemToInventory(new ItemStack(Items.GOLD_NUGGET), user);
                case 1:
                    addItemToInventory(new ItemStack(Items.PRISMARINE_CRYSTALS), user);
                case 2:
                    addItemToInventory(new ItemStack(Items.ENDER_PEARL), user);
                case 3:
                    addItemToInventory(new ItemStack(Items.CHARCOAL), user);
                case 5:
                    addItemToInventory(new ItemStack(Items.PHANTOM_MEMBRANE), user);
            }

            user.playerScreenHandler.sendContentUpdates();
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }

    public void addItemToInventory(ItemStack item, PlayerEntity user) {
        user.getInventory().insertStack(item);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}