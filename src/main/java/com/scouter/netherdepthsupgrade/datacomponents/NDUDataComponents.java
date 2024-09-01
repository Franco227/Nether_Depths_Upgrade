package com.scouter.netherdepthsupgrade.datacomponents;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.UnaryOperator;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDUDataComponents {

    public static final Logger LOGGER = LoggerFactory.getLogger("netherdepthsupgrade");

    public static final DataComponentType<Unit> HAS_HELL_STRIDER = register("has_hell_strider", e -> e.persistent(Unit.CODEC));

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, prefix(name), builder.apply(DataComponentType.builder()).build());
    }

    public static void ENCHANTMENT_COMPONENTS()
    {
        LOGGER.info("Registering Enchantments Components for " + NetherDepthsUpgrade.MODID);
    }
}
