package sirjain.throwable_fluids.entity.splasher;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import sirjain.throwable_fluids.items.ModItems;

public class SplasherEntity extends FishEntity {
    public SplasherEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(1, new SwimAroundGoal(this, 1.0, 10));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.initFleeGoals();
    }

    public void initFleeGoals() {
        this.goalSelector.add(1, new FleeEntityGoal<>(this, GuardianEntity.class, 9.0F, 1.4, 1.4));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, ElderGuardianEntity.class, 9.0F, 1.4, 1.4));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, PlayerEntity.class, 9.0F, 1.4, 1.4));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, DrownedEntity.class, 9.0F, 1.4, 1.4));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_DEATH;
    }

    public static DefaultAttributeContainer.Builder createSplasherAttributes() {
        return FishEntity
                .createFishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14);
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.SPLASHER_BUCKET);
    }
}