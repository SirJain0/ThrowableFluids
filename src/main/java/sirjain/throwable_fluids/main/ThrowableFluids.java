package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import sirjain.throwable_fluids.entity.other.ModEntitySpawn;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;
import sirjain.throwable_fluids.sounds.ModSoundEvents;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItems.registerMobSpawnEggItems();
		ModEntityTypes.registerEntityRender();
		ModEntityTypes.registerAttributes();
		ModEntitySpawn.entitySpawn();
		ModSoundEvents.registerSoundEvents();

		System.out.println("Hi, "+MOD_ID+"!");
	}
}