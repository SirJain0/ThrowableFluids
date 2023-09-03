package sirjain.throwable_fluids.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
	public static final FoodComponent SPLASHER_FISH = new FoodComponent.Builder()
		.saturationModifier(1.1f)
		.hunger(2)
		.meat()
		.statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 6 * 20, 1), 1)
		.build();
}