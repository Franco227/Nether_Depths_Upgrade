package com.scouter.netherdepthsupgrade.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class PlaceWetLavaSpongeTrigger extends SimpleCriterionTrigger<PlaceWetLavaSpongeTrigger.TriggerInstance> {
    @Override
    public Codec<PlaceWetLavaSpongeTrigger.TriggerInstance> codec() {
        return PlaceWetLavaSpongeTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer pPlayer) {
        this.trigger(pPlayer, p_222625_ -> true);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<PlaceWetLavaSpongeTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                p_337390_ -> p_337390_.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(PlaceWetLavaSpongeTrigger.TriggerInstance::player))
                        .apply(p_337390_, PlaceWetLavaSpongeTrigger.TriggerInstance::new)
        );

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> located(LocationPredicate.Builder pLocation) {
            return CriteriaTriggers.LOCATION
                    .createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.of(EntityPredicate.wrap(EntityPredicate.Builder.entity().located(pLocation)))));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> located(EntityPredicate.Builder pEntity) {
            return CriteriaTriggers.LOCATION.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.of(EntityPredicate.wrap(pEntity.build()))));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> located(Optional<EntityPredicate> pEntity) {
            return CriteriaTriggers.LOCATION.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(EntityPredicate.wrap(pEntity)));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> sleptInBed() {
            return CriteriaTriggers.SLEPT_IN_BED.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.empty()));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> raidWon() {
            return CriteriaTriggers.RAID_WIN.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.empty()));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> avoidVibration() {
            return CriteriaTriggers.AVOID_VIBRATION.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.empty()));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> tick() {
            return CriteriaTriggers.TICK.createCriterion(new net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance(Optional.empty()));
        }

        public static Criterion<net.minecraft.advancements.critereon.PlayerTrigger.TriggerInstance> walkOnBlockWithEquipment(Block pBlock, Item pEquipment) {
            return located(
                    EntityPredicate.Builder.entity()
                            .equipment(EntityEquipmentPredicate.Builder.equipment().feet(ItemPredicate.Builder.item().of(pEquipment)))
                            .steppingOn(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(pBlock)))
            );
        }
    }
}

