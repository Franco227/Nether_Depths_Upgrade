package com.scouter.netherdepthsupgrade.entity;


import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.entity.entities.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;


public class NDUEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, NetherDepthsUpgrade.MODID);


    public static final DeferredHolder<EntityType<?> ,EntityType<LavaPufferfishEntity>> LAVA_PUFFERFISH = ENTITY_TYPES.register("lava_pufferfish",
            () -> EntityType.Builder.of(LavaPufferfishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.7F).clientTrackingRange(4)
                    .build(prefix("lava_pufferfish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<ObsidianfishEntity>> OBSIDIAN_FISH = ENTITY_TYPES.register("obsidianfish",
            () -> EntityType.Builder.of(ObsidianfishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.4F).clientTrackingRange(4)
                    .build(prefix("obsidianfish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<SearingCodEntity>> SEARING_COD = ENTITY_TYPES.register("searing_cod",
            () -> EntityType.Builder.of(SearingCodEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.3F).clientTrackingRange(4)
                    .build(prefix("searing_cod").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<BonefishEntity>> BONEFISH = ENTITY_TYPES.register("bonefish",
            () -> EntityType.Builder.of(BonefishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.6F, 0.4F).clientTrackingRange(4)
                    .build(prefix("bonefish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<WitherBonefishEntity>> WITHER_BONEFISH = ENTITY_TYPES.register("wither_bonefish",
            () -> EntityType.Builder.of(WitherBonefishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.6F, 0.4F).clientTrackingRange(4)
                    .build(prefix("wither_bonefish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<BlazefishEntity>> BLAZEFISH = ENTITY_TYPES.register("blazefish",
            () -> EntityType.Builder.of(BlazefishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.8F).clientTrackingRange(4)
                    .build(prefix("blazefish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<MagmaCubefishEntity>> MAGMACUBEFISH = ENTITY_TYPES.register("magmacubefish",
            () -> EntityType.Builder.of(MagmaCubefishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.6F, 0.6F).clientTrackingRange(4)
                    .build(prefix("magmacubefish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<GlowdineEntity>> GLOWDINE = ENTITY_TYPES.register("glowdine",
            () -> EntityType.Builder.of(GlowdineEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.6F, 0.6F).clientTrackingRange(4)
                    .build(prefix("glowdine").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<SoulSuckerEntity>> SOULSUCKER = ENTITY_TYPES.register("soulsucker",
            () -> EntityType.Builder.of(SoulSuckerEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.6F, 0.6F).clientTrackingRange(4)
                    .build(prefix("soulsucker").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<FortressGrouperEntity>> FORTRESS_GROUPER = ENTITY_TYPES.register("fortressgrouper",
            () -> EntityType.Builder.of(FortressGrouperEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(2F, 1.6F).clientTrackingRange(4)
                    .build(prefix("fortressgrouper").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<EyeballfishEntity>> EYEBALL_FISH = ENTITY_TYPES.register("eyeball_fish",
            () -> EntityType.Builder.of(EyeballfishEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(0.7F, 0.7F).clientTrackingRange(4)
                    .build(prefix("eyeball_fish").toString()));

    public static final DeferredHolder<EntityType<?> ,EntityType<LavaFishingBobberEntity>> LAVA_BOBBER = ENTITY_TYPES.register("lava_fishing_bobber",
            () -> EntityType.Builder.<LavaFishingBobberEntity>of(LavaFishingBobberEntity::new, MobCategory.MISC)
                    .fireImmune().noSave().noSummon().sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(5)
                    .build(prefix("lava_fishing_bobber").toString()));
}
