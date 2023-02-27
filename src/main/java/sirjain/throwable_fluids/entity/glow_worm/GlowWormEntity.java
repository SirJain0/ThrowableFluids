package sirjain.throwable_fluids.entity.glow_worm;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GlowWormEntity extends AnimalEntity {
    public GlowWormEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.6D));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.3));
    }

    @Override
    public boolean hurtByWater() {
        return true;
    }

    @Override
    public void mobTick() {
        if (this.age % 110 == 0) {
            this.heal(1);
        }
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void tickMovement() {
        this.world.addParticle(
                ParticleTypes.FLAME,
                this.getParticleX(0.2),
                this.getRandomBodyY(),
                this.getParticleZ(0.2),
                0,
                0,
                0
        );

        super.tickMovement();
    }

    public static DefaultAttributeContainer.Builder createGlowWormAttributes() {
        return AnimalEntity
                .createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }
}