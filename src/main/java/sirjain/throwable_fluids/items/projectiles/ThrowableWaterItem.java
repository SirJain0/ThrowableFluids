package sirjain.throwable_fluids.items.projectiles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import sirjain.throwable_fluids.entity.projectiles.ThrowableFluidEntity;
import sirjain.throwable_fluids.entity.projectiles.ThrowableWaterEntity;

public class ThrowableWaterItem extends ThrowableFluidItem {
	public ThrowableWaterItem(Settings settings) {
		super(settings);
	}

	@Override
	public ThrowableFluidEntity getEntity(World world, LivingEntity user) {
		return new ThrowableWaterEntity(world, user);
	}
}