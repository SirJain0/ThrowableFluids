package sirjain.throwable_fluids.main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.entity.other.ModEntitySpawn;
import sirjain.throwable_fluids.entity.other.ModEntityTypes;
import sirjain.throwable_fluids.items.ModItems;
import java.util.Random;

public class ThrowableFluids implements ModInitializer {
	public static final String MOD_ID = "throwablefluids";
	public static final ItemGroup TF_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "throwable_fluids_item_group"), () -> new ItemStack(ModItems.THROWABLE_WATER));

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItems.registerMobSpawnEggItems();
		ModEntityTypes.registerEntityRender();
		ModEntityTypes.registerAttributes();
		ModEntitySpawn.entitySpawn();

		System.out.println("Hi, "+MOD_ID+"!");
	}
}