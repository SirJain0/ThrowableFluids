package sirjain.throwable_fluids.entity.glow_worm;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class GlowWormEntity extends PathAwareEntity {
    public static TrackedData<Byte> COLOR;

    public GlowWormEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.goalSelector.add(0, new LookAroundGoal(this));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.6D));
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
        return PathAwareEntity
                .createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }
}