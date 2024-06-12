package sirjain.throwable_fluids.misc;

import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import sirjain.throwable_fluids.items.ThrowableFluidsItems;

public class TFLootTableModifier {
	public static void initLootTables() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			appendItemToLootTable(LootTables.NETHER_BRIDGE_CHEST, ThrowableFluidsItems.THROWABLE_LAVA, 0.2f, id, tableBuilder);
			appendItemToLootTable(LootTables.STRONGHOLD_CORRIDOR_CHEST, ThrowableFluidsItems.THROWABLE_LAVA, 0.15f, id, tableBuilder);
			appendItemToLootTable(LootTables.STRONGHOLD_CROSSING_CHEST, ThrowableFluidsItems.THROWABLE_LAVA, 0.15F, id, tableBuilder);

			appendItemToLootTable(LootTables.UNDERWATER_RUIN_BIG_CHEST, ThrowableFluidsItems.THROWABLE_WATER, 0.2F, id, tableBuilder);
			appendItemToLootTable(LootTables.UNDERWATER_RUIN_SMALL_CHEST, ThrowableFluidsItems.THROWABLE_WATER, 0.15F, id, tableBuilder);
		});
	}

	public static void appendItemToLootTable(Identifier target, Item item, float chance, Identifier id, FabricLootTableBuilder tableBuilder) {
		if (!target.equals(id)) return;

		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(chance))
			.with(ItemEntry.builder(item))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

		tableBuilder.pool(poolBuilder.build());
	}
}