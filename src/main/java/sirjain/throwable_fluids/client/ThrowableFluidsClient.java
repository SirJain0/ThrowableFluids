package sirjain.throwable_fluids.client;

import net.fabricmc.api.ClientModInitializer;
import sirjain.throwable_fluids.entity.ThrowableFluidsEntityTypes;

public class ThrowableFluidsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ThrowableFluidsEntityTypes.registerEntityRenderers();
	}
}
