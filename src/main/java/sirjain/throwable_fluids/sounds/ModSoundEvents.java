package sirjain.throwable_fluids.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {
    public static final Identifier FLOP_SOUND_ID = new Identifier("throwablefluids:splasher_flop");
    public static final Identifier DEATH_SOUND_ID = new Identifier("throwablefluids:splasher_death");
    public static final Identifier GLOW_WORM_DEATH_SOUND_ID = new Identifier("throwablefluids:glow_worm_death");

    public static SoundEvent SPLASHER_FLOP = new SoundEvent(FLOP_SOUND_ID);
    public static SoundEvent SPLASHER_DEATH = new SoundEvent(DEATH_SOUND_ID);
    public static SoundEvent GLOW_WORM_DEATH = new SoundEvent(GLOW_WORM_DEATH_SOUND_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, FLOP_SOUND_ID, SPLASHER_FLOP);
        Registry.register(Registry.SOUND_EVENT, DEATH_SOUND_ID, SPLASHER_DEATH);
        Registry.register(Registry.SOUND_EVENT, GLOW_WORM_DEATH_SOUND_ID, GLOW_WORM_DEATH);
    }
}