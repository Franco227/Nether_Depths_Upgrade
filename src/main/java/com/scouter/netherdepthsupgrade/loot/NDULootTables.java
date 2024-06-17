package com.scouter.netherdepthsupgrade.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDULootTables {
    public static final ResourceKey<LootTable> LAVA_FISHING = register("gameplay/lava_fishing");
    public static final ResourceKey<LootTable> NETHER_FISHING = register("gameplay/nether_fishing");
    public static final ResourceKey<LootTable> FAILED_FISHING = register("gameplay/failed_fishing");

    private static ResourceKey<LootTable> register(String pName) {
        return ResourceKey.create(Registries.LOOT_TABLE,  prefix(pName));
    }
}
