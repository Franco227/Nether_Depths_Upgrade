package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.netherdepthsupgrade.blocks.NDUBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class LootTableBlocks extends BlockLootSubProvider {

    private final Set<Block> knownBlocks = new HashSet<>();
    //private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    //private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();

    protected LootTableBlocks(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures, HolderLookup.Provider p_344943_) {
        super(pExplosionResistant, pEnabledFeatures, p_344943_);

    }

    @Override
    protected void add(Block block, LootTable.Builder builder) {
        super.add(block, builder);
        knownBlocks.add(block);
    }

    @Override
    protected void generate() {
        dropSelf(NDUBlocks.WARPED_KELP.get());
        dropSelf(NDUBlocks.LAVA_SPONGE.get());
        dropSelf(NDUBlocks.WET_LAVA_SPONGE.get());
        dropSelf(NDUBlocks.WARPED_KELP_BLOCK.get());
        dropOther(NDUBlocks.WARPED_KELP_PLANT.get(), NDUBlocks.WARPED_KELP.get());
        add(NDUBlocks.WARPED_SEAGRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(NDUBlocks.TALL_WARPED_SEAGRASS.get(), createDoublePlantShearsDrop(NDUBlocks.WARPED_SEAGRASS.get()));
        dropSelf(NDUBlocks.CRIMSON_KELP.get());
        dropSelf(NDUBlocks.CRIMSON_KELP_BLOCK.get());
        dropSelf(NDUBlocks.CRIMSON_KELP_CARPET_BLOCK.get());
        dropSelf(NDUBlocks.WARPED_KELP_CARPET_BLOCK.get());
        dropOther(NDUBlocks.CRIMSON_KELP_PLANT.get(), NDUBlocks.CRIMSON_KELP.get());
        add(NDUBlocks.CRIMSON_SEAGRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        add(NDUBlocks.TALL_CRIMSON_SEAGRASS.get(), createDoublePlantShearsDrop(NDUBlocks.CRIMSON_SEAGRASS.get()));
        dropWhenSilkTouch(NDUBlocks.LAVA_GLASS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
