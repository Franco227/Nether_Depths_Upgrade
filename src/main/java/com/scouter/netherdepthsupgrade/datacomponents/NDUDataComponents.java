package com.scouter.netherdepthsupgrade.datacomponents;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Unit;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NDUDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(NetherDepthsUpgrade.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> HAS_HELL_STRIDER = DATA_COMPONENTS.registerComponentType("has_hell_strider",ob -> ob.persistent(Unit.CODEC));


    
}
