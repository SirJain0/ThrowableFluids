package sirjain.throwable_fluids.items.projectiles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.projectiles.ThrowableFluidEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableLavaEntity;

public class ThrowableLavaItem extends ThrowableFluidItem {
	public ThrowableLavaItem(Settings settings) {
		super(settings);
	}

	@Override
	public ThrowableFluidEntity getEntity(World world, LivingEntity user) {
		return new ThrowableLavaEntity(world, user);
	}
}