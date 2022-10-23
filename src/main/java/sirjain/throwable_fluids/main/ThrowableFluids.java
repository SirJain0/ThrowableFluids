package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sirjain.throwable_fluids.items.ModItems;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItems.registerMobSpawnEggItems();
		LOGGER.info("Hello Fabric world!");
	}
}