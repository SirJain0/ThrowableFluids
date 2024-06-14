package sirjain.throwable_fluids.client;

import net.fabricmc.api.ClientModInitializer;
import sirjain.throwable_fluids.client.entity.ThrowableFluidsEntityLayers;

public class ThrowableFluidsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ThrowableFluidsEntityLayers.registerEntityRenderers();
	}
}
