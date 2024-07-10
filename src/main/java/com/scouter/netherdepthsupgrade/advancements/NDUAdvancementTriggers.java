package com.scouter.netherdepthsupgrade.advancements;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDUAdvancementTriggers {
    public static DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, NetherDepthsUpgrade.MODID);

    public static DeferredHolder<CriterionTrigger<?>, ItemUsedOnLocationTrigger> PLACE_WET_LAVA_SPONGE = TRIGGERS.register("placed_block", () -> new ItemUsedOnLocationTrigger());



}
