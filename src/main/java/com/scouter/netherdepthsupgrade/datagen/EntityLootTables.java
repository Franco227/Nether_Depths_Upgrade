/*package com.scouter.netherdepthsupgrade.datagen;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class EntityLootTables extends EntityLootSubProvider {
    private final Set<EntityType<?>> knownEntityTypes = new HashSet<>();
    protected EntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {

    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return knownEntityTypes.stream();
    }
}
*/