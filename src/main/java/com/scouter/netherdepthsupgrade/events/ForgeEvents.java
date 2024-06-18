package com.scouter.netherdepthsupgrade.events;

import com.mojang.logging.LogUtils;
import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.config.NetherDepthsUpgradeConfig;
import com.scouter.netherdepthsupgrade.datacomponents.NDUDataComponents;
import com.scouter.netherdepthsupgrade.enchantments.NDUEnchantments;
import com.scouter.netherdepthsupgrade.entity.NDUEntity;
import com.scouter.netherdepthsupgrade.entity.entities.LavaFishingBobberEntity;
import com.scouter.netherdepthsupgrade.items.NDUItems;
import com.scouter.netherdepthsupgrade.potion.NDUPotions;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

import java.util.List;

@EventBusSubscriber(modid = NetherDepthsUpgrade.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ForgeEvents {
    private static final Logger LOGGER = LogUtils.getLogger();


    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        addMixes(event.getBuilder());
    }

    public static void addMixes(PotionBrewing.Builder builder) {
        builder.addMix(Potions.AWKWARD, NDUItems.LAVA_PUFFERFISH.get(), NDUPotions.WITHER.getDelegate());
        builder.addMix(Potions.AWKWARD, NDUItems.EYEBALL_FISH_EYE.get(), NDUPotions.LAVA_VISION.getDelegate());
        builder.addMix(Potions.AWKWARD, NDUItems.EYEBALL_FISH.get(), NDUPotions.LAVA_VISION.getDelegate());
        builder.addMix(Potions.AWKWARD, NDUItems.OBSIDIANFISH.get(), NDUPotions.RESISTANCE.getDelegate());
        builder.addMix(Potions.AWKWARD, NDUItems.GLOWDINE.get(), NDUPotions.GLOWING.getDelegate());
        builder.addMix(NDUPotions.GLOWING.getDelegate(), Items.REDSTONE, NDUPotions.LONG_GLOWING.getDelegate());
        builder.addMix(NDUPotions.RESISTANCE.getDelegate(), Items.REDSTONE, NDUPotions.LONG_RESISTANCE.getDelegate());
        builder.addMix(NDUPotions.RESISTANCE.getDelegate(), Items.GLOWSTONE_DUST, NDUPotions.STRONG_RESISTANCE.getDelegate());
        builder.addMix(Potions.AWKWARD, NDUItems.LAVA_PUFFERFISH.get(), NDUPotions.WITHER.getDelegate());
        builder.addMix(NDUPotions.LAVA_VISION.getDelegate(), Items.REDSTONE, NDUPotions.LONG_LAVA_VISION.getDelegate());

    }

    @SubscribeEvent
    public static void lavaMovementSpeed(PlayerTickEvent.Post event) {
        if (event.getEntity() == null || event.getEntity().isCreative() || event.getEntity().isSpectator()) {
            return;
        }
        double d0 = 0.000D;
        boolean flag = event.getEntity().getDeltaMovement().y <= 0.0D;
        if (flag && event.getEntity().hasEffect(MobEffects.SLOW_FALLING)) {
            d0 = 0.01;
        }
        if (EnchantmentHelper.has(event.getEntity().getItemBySlot(EquipmentSlot.FEET), NDUDataComponents.HAS_HELL_STRIDER.get())) {
            Player player = event.getEntity();
            int level = getHellStriderLevel(player);
            BlockPos eyePos = new BlockPos((int) player.getEyePosition().x(), (int) player.getEyePosition().y(), (int) player.getEyePosition().z());
            FluidState state = player.level().getFluidState(eyePos);
            if (player.isInLava() && player.isAffectedByFluids() && state.is(FluidTags.LAVA)) {

                double e = player.getY();
                float speed = (float) (1.15 + (0.35 * level));
                player.setDeltaMovement(player.getDeltaMovement().multiply(speed, 0.8F, speed));
                Vec3 vec33 = player.getFluidFallingAdjustedMovement(d0, flag, player.getDeltaMovement());
                player.setDeltaMovement(vec33);
                if (player.isShiftKeyDown()) {
                    player.setDeltaMovement(vec33.x, -0.075000001192092896 * level, vec33.z);
                }

                if (player.horizontalCollision && player.isFree(vec33.x, vec33.y + 0.6000000238418579 - player.getY() + e, vec33.z)) {
                    player.setDeltaMovement(vec33.x, 0.30000001192092896, vec33.z);
                }
            }
        }
    }

    private static int getHellStriderLevel(Player entity) {
        return entity.registryAccess()
                .registry(Registries.ENCHANTMENT)
                .flatMap(e -> e.getHolder(NDUEnchantments.HELL_STRIDER))
                .map(d -> EnchantmentHelper.getEnchantmentLevel(d, entity))
                .orElse(0);
    }


    @SubscribeEvent
    public static void changeFish(ItemFishedEvent event) {
        Player fisher = (Player) event.getEntity();
        ItemStack itemstack = fisher.getItemInHand(InteractionHand.MAIN_HAND);
        FishingHook bobber = event.getHookEntity();
        List<ItemStack> drops = event.getDrops();


        if (bobber instanceof LavaFishingBobberEntity && NetherDepthsUpgradeConfig.FISH_ENTITIES.get()) {
            for (ItemStack stack : drops) {
                Entity entity = null;
                if (stack.getItem() == NDUItems.SEARING_COD.get()) {
                    entity = NDUEntity.SEARING_COD.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.SOULSUCKER.get()) {
                    entity = NDUEntity.SOULSUCKER.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.LAVA_PUFFERFISH.get()) {
                    entity = NDUEntity.LAVA_PUFFERFISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.BONEFISH.get()) {
                    entity = NDUEntity.BONEFISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.WITHER_BONEFISH.get()) {
                    entity = NDUEntity.WITHER_BONEFISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.GLOWDINE.get()) {
                    entity = NDUEntity.GLOWDINE.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.MAGMACUBEFISH.get()) {
                    entity = NDUEntity.MAGMACUBEFISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.OBSIDIANFISH.get()) {
                    entity = NDUEntity.OBSIDIAN_FISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.BLAZEFISH.get()) {
                    entity = NDUEntity.BLAZEFISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.EYEBALL_FISH.get()) {
                    entity = NDUEntity.EYEBALL_FISH.get().create(event.getEntity().level());
                }
                if (stack.getItem() == NDUItems.FORTRESS_GROUPER.get()) {
                    entity = NDUEntity.FORTRESS_GROUPER.get().create(event.getEntity().level());
                }

                if (entity == null) {
                    ItemEntity itementity = new ItemEntity(event.getEntity().level(), bobber.getX(), bobber.getY() + 1, bobber.getZ(), stack);
                    double d0 = fisher.position().x() - bobber.position().x();
                    double d1 = fisher.position().y() - (bobber.position().y() + 1);
                    double d2 = fisher.position().z() - bobber.position().z();
                    double d3 = 0.1D;
                    itementity.setDeltaMovement(d0 * 0.1D, d1 * 0.1D + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08D, d2 * 0.1D);
                    event.getEntity().level().addFreshEntity(itementity);
                    fisher.level().addFreshEntity(new ExperienceOrb(fisher.level(), fisher.getX(), fisher.getY() + 0.5D, fisher.getZ() + 0.5D, bobber.level().random.nextInt(6) + 1));

                    CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) fisher, itemstack, bobber, drops);
                    if (itemstack.is(ItemTags.FISHES)) {
                        fisher.awardStat(Stats.FISH_CAUGHT, 1);
                    }


                    event.setCanceled(true);
                    event.damageRodBy(event.getRodDamage());
                    return;
                }
                entity.moveTo(bobber.position().x(), bobber.position().y(), bobber.position().z(), bobber.xRotO, bobber.yRotO);
                double dX = fisher.position().x() - bobber.position().x();
                double dY = fisher.position().y() - bobber.position().y();
                double dZ = fisher.position().z() - bobber.position().z();
                double mult = 0.12;
                entity.setDeltaMovement(dX * mult, dY * mult + Math.sqrt(Math.sqrt(dX * dX + dY * dY + dZ * dZ)) * 0.14D, dZ * mult);
                event.getEntity().level().addFreshEntity(entity);
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) fisher, itemstack, bobber, drops);
                if (itemstack.is(ItemTags.FISHES)) {
                    fisher.awardStat(Stats.FISH_CAUGHT, 1);
                }
            }
            event.setCanceled(true);
            event.damageRodBy(event.getRodDamage());
        }
    }

    @SubscribeEvent
    public static void frogFeed(PlayerInteractEvent.EntityInteract event) {
        if (event.getLevel().isClientSide || !(event.getTarget() instanceof Frog) || !(event.getEntity() instanceof Player)) {
            return;
        }
        Frog frog = (Frog) event.getTarget();
        Player player = event.getEntity();
        Level level = event.getLevel();
        ItemStack itemStack_ochre = new ItemStack(Items.OCHRE_FROGLIGHT);
        ItemStack itemStack_pearlescent = new ItemStack(Items.PEARLESCENT_FROGLIGHT);
        ItemStack itemStack_verdant = new ItemStack(Items.VERDANT_FROGLIGHT);
        ItemEntity itemEntity_ochre = new ItemEntity(level, frog.getX(), frog.getY(), frog.getZ(), itemStack_ochre);
        ItemEntity itemEntity_pearlescent = new ItemEntity(level, frog.getX(), frog.getY(), frog.getZ(), itemStack_pearlescent);
        ItemEntity itemEntity_verdant = new ItemEntity(level, frog.getX(), frog.getY(), frog.getZ(), itemStack_verdant);
        ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);

        if (itemInHand.getItem() == NDUItems.MAGMACUBEFISH.get().asItem()) {
            if (frog.getVariant() == FrogVariant.COLD) {
                level.addFreshEntity(itemEntity_verdant);
            }
            if (frog.getVariant() == FrogVariant.TEMPERATE) {
                level.addFreshEntity(itemEntity_ochre);
            }
            if (frog.getVariant() == FrogVariant.WARM) {
                level.addFreshEntity(itemEntity_pearlescent);
            }
            if (!player.isCreative()) {
                level.playSound(null, frog.blockPosition(), SoundEvents.FROG_EAT, SoundSource.NEUTRAL, 1, 1);
                itemInHand.setCount(itemInHand.getCount() - 1);
            }
        }
    }
}

