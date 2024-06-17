package com.scouter.netherdepthsupgrade.world.feature;


import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NDUFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, NetherDepthsUpgrade.MODID);

    private static final String WARPED_KELP_FEATURE_NAME = "warped_kelp_feature";
    private static final String WARPED_SEAGRASS_FEATURE_NAME = "warped_seagrass_feature";
    private static final String CRIMSON_KELP_FEATURE_NAME = "crimson_kelp_feature";
    private static final String CRIMSON_SEAGRASS_FEATURE_NAME = "crimson_seagrass_feature";
    private static final String VENT_FEATURE_NAME = "vent_feature";
    private static final String LAVA_SPONGE_FEATURE_NAME = "lava_sponge_feature";
    public static final DeferredHolder<Feature<?>, WarpedKelpFeature> WARPED_KELP = FEATURES.register(WARPED_KELP_FEATURE_NAME, () -> new WarpedKelpFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, WarpedSeagrassFeature> WARPED_SEAGRASS = FEATURES.register(WARPED_SEAGRASS_FEATURE_NAME, () -> new WarpedSeagrassFeature(ProbabilityFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, CrimsonKelpFeature> CRIMSON_KELP = FEATURES.register(CRIMSON_KELP_FEATURE_NAME, () -> new CrimsonKelpFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, CrimsonSeagrassFeature> CRIMSON_SEAGRASS = FEATURES.register(CRIMSON_SEAGRASS_FEATURE_NAME, () -> new CrimsonSeagrassFeature(ProbabilityFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, VentFeature> VENT = FEATURES.register(VENT_FEATURE_NAME, () -> new VentFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, SpongeFeature> LAVA_SPONGE = FEATURES.register(LAVA_SPONGE_FEATURE_NAME, () -> new SpongeFeature(NoneFeatureConfiguration.CODEC));

}
