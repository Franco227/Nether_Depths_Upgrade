package com.scouter.netherdepthsupgrade.setup;

import com.mojang.logging.LogUtils;
import com.scouter.netherdepthsupgrade.blocks.NDUBlocks;
import com.scouter.netherdepthsupgrade.blocks.advancements.NDUAdvancementTriggers;
import com.scouter.netherdepthsupgrade.blocks.entity.NDUBlockEntities;
import com.scouter.netherdepthsupgrade.config.NetherDepthsUpgradeConfig;
import com.scouter.netherdepthsupgrade.effect.MobEffects;
import com.scouter.netherdepthsupgrade.enchantments.NDUEnchantments;
import com.scouter.netherdepthsupgrade.entity.NDUEntity;
import com.scouter.netherdepthsupgrade.items.NDUItems;
import com.scouter.netherdepthsupgrade.modcompat.FarmersDelightCompat;
import com.scouter.netherdepthsupgrade.modcompat.ModChecker;
import com.scouter.netherdepthsupgrade.particle.NDUParticle;
import com.scouter.netherdepthsupgrade.potion.NDUPotions;
import com.scouter.netherdepthsupgrade.structures.NDUStructures;
import com.scouter.netherdepthsupgrade.world.feature.NDUConfiguredFeatures;
import com.scouter.netherdepthsupgrade.world.feature.NDUFeatures;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.scouter.netherdepthsupgrade.items.NDUItems.creativeTab;
import static com.scouter.netherdepthsupgrade.items.NDUItems.creativeTabFish;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init(){

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NetherDepthsUpgradeConfig.CONFIG_BUILDER);

        NDUBlocks.BLOCKS.register(bus);
        NDUBlockEntities.BLOCK_ENTITIES.register(bus);
        NDUEntity.ENTITY_TYPES.register(bus);
        MobEffects.MOB_EFFECTS.register(bus);
        NDUItems.ITEMS.register(bus);
        NDUStructures.STRUCTURES.register(bus);
        NDUParticle.PARTICLE.register(bus);
        NDUEnchantments.ENCHANTMENT.register(bus);
        NDUPotions.POTIONS.register(bus);
        NDUConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
        NDUConfiguredFeatures.PLACED_FEATURES.register(bus);
        NDUFeatures.FEATURES.register(bus);
        NDUAdvancementTriggers.init();

        if(ModChecker.farmersDelightPresent){
            FarmersDelightCompat.ITEMS_FARMERS_DELIGHT.register(bus);
            FarmersDelightCompat.BLOCKS_FARMERS_DELIGHT.register(bus);
        }

    }

    public static final Item.Properties defaultBuilder() {
        return new Item.Properties().tab(creativeTab);
    }
    public static final Item.Properties fishBuilder() {return new Item.Properties().tab(creativeTabFish);}


}
