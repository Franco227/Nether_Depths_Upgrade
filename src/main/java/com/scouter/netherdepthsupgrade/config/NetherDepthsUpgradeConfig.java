package com.scouter.netherdepthsupgrade.config;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.neoforged.neoforge.common.ModConfigSpec;

public class NetherDepthsUpgradeConfig {



    public static final ModConfigSpec CONFIG_BUILDER;

    static {
        ModConfigSpec.Builder configBuilder = new ModConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_BUILDER = configBuilder.build();
    }

    public static ModConfigSpec.ConfigValue<Boolean> FISH_ENTITIES;


    private static void setupConfig(ModConfigSpec.Builder builder) {
        builder.comment(NetherDepthsUpgrade.MODID + " Config");

        builder.comment("Config for the Nether Depths Upgrade");
        FISH_ENTITIES = builder.comment("When set to true it will allow you to fish entities instead of items (default is true)").define("fish_entities", true);

    }
}
