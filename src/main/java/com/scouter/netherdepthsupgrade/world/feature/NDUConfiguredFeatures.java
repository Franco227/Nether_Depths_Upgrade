package com.scouter.netherdepthsupgrade.world.feature;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.blocks.NDUBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.List;

public class NDUConfiguredFeatures {
    ;
    public static List<String> placedFeatureList = new ArrayList<>();
    public static List<String> configuredFeatureList = new ArrayList<>();
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_SEAGRASS_SIMPLE_FEATURE_NAME = registerKey("warped_seagrass_simple_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_KELP_FEATURE_NAME = registerKey("warped_kelp_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_SEAGRASS_SHORT_FEATURE_NAME = registerKey("warped_seagrass_short_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_SEAGRASS_SLIGHTLY_LESS_SHORT_FEATURE_NAME = registerKey("warped_seagrass_slightly_less_short_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_SEAGRASS_MID_FEATURE_NAME = registerKey("warped_seagrass_mid_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_SEAGRASS_TALL_FEATURE_NAME = registerKey("warped_seagrass_tall_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VENT_FEATURE_NAME = registerKey("vent_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVA_SPONGE_FEATURE_NAME = registerKey("lava_sponge_feature");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_SEAGRASS_SIMPLE_FEATURE_NAME = registerKey("crimson_seagrass_simple_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_KELP_FEATURE_NAME = registerKey("crimson_kelp_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_SEAGRASS_SHORT_FEATURE_NAME = registerKey("crimson_seagrass_short_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_SEAGRASS_SLIGHTLY_LESS_SHORT_FEATURE_NAME = registerKey("crimson_seagrass_slightly_less_short_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_SEAGRASS_MID_FEATURE_NAME = registerKey("crimson_seagrass_mid_feature");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_SEAGRASS_TALL_FEATURE_NAME = registerKey("crimson_seagrass_tall_feature");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(WARPED_SEAGRASS_SIMPLE_FEATURE_NAME, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(NDUBlocks.WARPED_SEAGRASS.get()))));
        context.register(WARPED_KELP_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.WARPED_KELP.get(), new NoneFeatureConfiguration()));
        context.register(WARPED_SEAGRASS_SHORT_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.WARPED_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.3F)));
        context.register(WARPED_SEAGRASS_SLIGHTLY_LESS_SHORT_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.WARPED_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.4F)));
        context.register(WARPED_SEAGRASS_MID_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.WARPED_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.6F)));
        context.register(WARPED_SEAGRASS_TALL_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.WARPED_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.8F)));
        context.register(VENT_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.VENT.get(), new NoneFeatureConfiguration()));
        context.register(LAVA_SPONGE_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.LAVA_SPONGE.get(), new NoneFeatureConfiguration()));


        context.register(CRIMSON_SEAGRASS_SIMPLE_FEATURE_NAME, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(NDUBlocks.CRIMSON_SEAGRASS.get()))));
        context.register(CRIMSON_KELP_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.CRIMSON_KELP.get(), new NoneFeatureConfiguration()));
        context.register(CRIMSON_SEAGRASS_SHORT_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.CRIMSON_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.3F)));
        context.register(CRIMSON_SEAGRASS_SLIGHTLY_LESS_SHORT_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.CRIMSON_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.4F)));
        context.register(CRIMSON_SEAGRASS_MID_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.CRIMSON_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.6F)));
        context.register(CRIMSON_SEAGRASS_TALL_FEATURE_NAME, new ConfiguredFeature<>(NDUFeatures.CRIMSON_SEAGRASS.get(), new ProbabilityFeatureConfiguration(0.8F)));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NetherDepthsUpgrade.prefix(name));
    }
}
