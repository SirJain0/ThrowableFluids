package sirjain.throwable_fluids.misc;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import sirjain.throwable_fluids.items.ThrowableFluidsItems;

public class ThrowableFluidsLootTableModifier {
	public static void initLootTables() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
			if (key == LootTables.NETHER_BRIDGE_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 0.2f, tableBuilder);
			else if (key == LootTables.STRONGHOLD_CORRIDOR_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 0.15f, tableBuilder);
			else if (key == LootTables.STRONGHOLD_CROSSING_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 0.15f, tableBuilder);
			else if (key == LootTables.VILLAGE_PLAINS_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 1, tableBuilder);

			if (key == LootTables.UNDERWATER_RUIN_BIG_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 0.2f, tableBuilder);
			else if (key == LootTables.UNDERWATER_RUIN_SMALL_CHEST) appendItemToLootTable(ThrowableFluidsItems.THROWABLE_LAVA, 0.2f, tableBuilder);
		});
	}

	public static void appendItemToLootTable(Item item, float chance, LootTable.Builder tableBuilder) {
		LootPool.Builder poolBuilder = new LootPool.Builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(chance))
			.with(ItemEntry.builder(item))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

		tableBuilder.pool(poolBuilder);
	}
}