package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sirjain.throwable_fluids.entity.other.TFEntitySpawn;
import sirjain.throwable_fluids.entity.other.TFEntityTypes;
import sirjain.throwable_fluids.items.TFItems;
import sirjain.throwable_fluids.misc.TFLootTableModifier;
import sirjain.throwable_fluids.misc.TFSoundEvents;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TFEntityTypes.registerEntityRenderers();
		TFEntityTypes.registerAttributes();
		TFEntitySpawn.registerEntitySpawns();
		TFSoundEvents.registerSoundEvents();
		TFItems.registerModItems();
		TFItems.addItemsToTabs();
		TFLootTableModifier.initLootTables();

		LOGGER.info("Initializing Throwable Fluids!");
	}
}