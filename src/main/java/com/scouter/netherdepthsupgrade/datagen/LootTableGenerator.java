/*package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.arcanewastelands.datagen.loot.BlockLootTables;
import com.scouter.arcanewastelands.datagen.loot.ChestLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(PackOutput pOutput) {
        super(pOutput, Set.of(),
                List.of(
                        new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK),
                        new SubProviderEntry(EntityLootTables::new, LootContextParamSets.ENTITY),
                        new SubProviderEntry(ChestLootTables::new, LootContextParamSets.CHEST)
                        )
        );
    }

}
*/