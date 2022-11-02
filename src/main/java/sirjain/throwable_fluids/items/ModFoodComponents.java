package sirjain.throwable_fluids.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent MORBID_FLESH = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(2)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10, 1), 1)
            .build();
}
