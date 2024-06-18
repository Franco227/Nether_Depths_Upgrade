package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.enchantments.NDUEnchantments;
import com.scouter.netherdepthsupgrade.world.feature.NDUBiomeModifiers;
import com.scouter.netherdepthsupgrade.world.feature.NDUConfiguredFeatures;
import com.scouter.netherdepthsupgrade.world.feature.NDUPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, NDUEnchantments::bootstrap)
            .add(Registries.PLACED_FEATURE, NDUPlacedFeatures::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, NDUConfiguredFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, NDUBiomeModifiers::bootstrap);


    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,BUILDER,Set.of("minecraft", NetherDepthsUpgrade.MODID));
    }
}
