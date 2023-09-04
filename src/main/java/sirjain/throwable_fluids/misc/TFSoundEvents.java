package sirjain.throwable_fluids.misc;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class TFSoundEvents {
	public static final Identifier SPLASHER_FLOP_SOUND_ID = new Identifier(ThrowableFluids.MOD_ID, "splasher_flop");
	public static SoundEvent SPLASHER_FLOP = SoundEvent.of(SPLASHER_FLOP_SOUND_ID);

	public static void registerSoundEvents() {
		Registry.register(Registries.SOUND_EVENT, SPLASHER_FLOP_SOUND_ID, SPLASHER_FLOP);
	}
}