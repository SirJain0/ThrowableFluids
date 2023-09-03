package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sirjain.throwable_fluids.entity.other.ModEntitySpawn;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;
import sirjain.throwable_fluids.sounds.ModSoundEvents;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntityTypes.registerEntityRenderers();
		ModEntityTypes.registerAttributes();
		ModEntitySpawn.registerEntitySpawns();
		ModSoundEvents.registerSoundEvents();
		ModItems.registerModItems();
		ModItems.addItemsToTabs();

		LOGGER.info("Initializing Throwable Fluids!");
	}
}