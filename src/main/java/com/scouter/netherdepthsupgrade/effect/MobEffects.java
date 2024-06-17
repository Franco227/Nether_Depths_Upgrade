package com.scouter.netherdepthsupgrade.effect;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, NetherDepthsUpgrade.MODID);
    public static final DeferredHolder<MobEffect, ?> LAVA_VISION = MOB_EFFECTS.register("lava_vision", () -> new LavaVisionEffect(MobEffectCategory.BENEFICIAL, 0xf4d919));
}
