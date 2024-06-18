package com.scouter.netherdepthsupgrade.datacomponents;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Unit;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NDUDataComponents {
    //public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(NetherDepthsUpgrade.MODID);

    //public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> HAS_HELL_STRIDER = DATA_COMPONENTS.registerComponentType("has_hell_strider",ob -> ob.persistent(Unit.CODEC));

    public static final DeferredRegister<DataComponentType<?>> ENCHANT_COMPONENT = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, NetherDepthsUpgrade.MODID);


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> HAS_HELL_STRIDER = ENCHANT_COMPONENT.register("has_hell_strider", () -> DataComponentType.<Unit>builder().persistent(Unit.CODEC).build());

}
