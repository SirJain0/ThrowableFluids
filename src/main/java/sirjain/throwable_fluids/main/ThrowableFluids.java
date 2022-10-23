package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItems.registerMobSpawnEggItems();
		System.out.println("Hi, "+MOD_ID+"!");
	}
}