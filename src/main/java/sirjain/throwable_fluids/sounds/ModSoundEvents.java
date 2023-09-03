package sirjain.throwable_fluids.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModSoundEvents {
	public static final Identifier FLOP_SOUND_ID = new Identifier(ThrowableFluids.MOD_ID, "splasher_flop");
	public static final Identifier DEATH_SOUND_ID = new Identifier(ThrowableFluids.MOD_ID, "splasher_death");
	public static final Identifier GLOW_WORM_DEATH_SOUND_ID = new Identifier(ThrowableFluids.MOD_ID, "glow_worm_death");

	public static SoundEvent SPLASHER_FLOP = SoundEvent.of(FLOP_SOUND_ID);
	public static SoundEvent SPLASHER_DEATH = SoundEvent.of(DEATH_SOUND_ID);
	public static SoundEvent GLOW_WORM_DEATH = SoundEvent.of(GLOW_WORM_DEATH_SOUND_ID);

	public static void registerSoundEvents() {
		Registry.register(Registries.SOUND_EVENT, FLOP_SOUND_ID, SPLASHER_FLOP);
		Registry.register(Registries.SOUND_EVENT, DEATH_SOUND_ID, SPLASHER_DEATH);
		Registry.register(Registries.SOUND_EVENT, GLOW_WORM_DEATH_SOUND_ID, GLOW_WORM_DEATH);
	}
}