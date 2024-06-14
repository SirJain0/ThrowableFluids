package sirjain.throwable_fluids;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sirjain.throwable_fluids.entity.ThrowableFluidsEntityTypes;
import sirjain.throwable_fluids.items.ThrowableFluidsItems;
import sirjain.throwable_fluids.misc.ThrowableFluidsLootTableModifier;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ThrowableFluidsEntityTypes.registerEntityTypes();
		ThrowableFluidsItems.registerModItems();
		ThrowableFluidsItems.addItemsToTabs();
		ThrowableFluidsLootTableModifier.initLootTables();

		LOGGER.info("Initializing Throwable Fluids!");
	}
}