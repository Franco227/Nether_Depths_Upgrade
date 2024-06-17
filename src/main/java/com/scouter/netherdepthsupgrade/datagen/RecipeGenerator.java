package com.scouter.netherdepthsupgrade.datagen;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike> VELERIUM_SMELTABLES = List.of(ABlocks.VELERIUM_ORE.get(), AItems.RAW_VELERIUM.get());
    static final Map<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> SHAPE_CONSUMERS =
            ImmutableMap.<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>builder()
                    .put(BlockFamily.Variant.BUTTON, ((itemLike, itemLike2) -> buttonBuilder(itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.DOOR, ((itemLike, itemLike2) -> doorBuilder(itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.CHISELED, ((itemLike, itemLike2) -> chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.CUSTOM_FENCE, (p_176708_, p_176709_) -> fenceBuilder(p_176708_, Ingredient.of(p_176709_)))
                    .put(BlockFamily.Variant.FENCE, (p_248031_, p_248032_) -> fenceBuilder(p_248031_, Ingredient.of(p_248032_)))
                    .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, (p_176698_, p_176699_) -> fenceGateBuilder(p_176698_, Ingredient.of(p_176699_)))
                    .put(BlockFamily.Variant.FENCE_GATE, (p_248035_, p_248036_) -> fenceGateBuilder(p_248035_, Ingredient.of(p_248036_)))
                    .put(BlockFamily.Variant.SIGN, (p_176688_, p_176689_) -> signBuilder(p_176688_, Ingredient.of(p_176689_)))
                    .put(BlockFamily.Variant.SLAB, (p_248017_, p_248018_) -> slabBuilder(RecipeCategory.BUILDING_BLOCKS, p_248017_, Ingredient.of(p_248018_)))
                    .put(BlockFamily.Variant.STAIRS, (p_176674_, p_176675_) -> stairBuilder(p_176674_, Ingredient.of(p_176675_)))
                    .put(BlockFamily.Variant.PRESSURE_PLATE, (p_248039_, p_248040_) -> pressurePlateBuilder(RecipeCategory.REDSTONE, p_248039_, Ingredient.of(p_248040_)))
                    .put(BlockFamily.Variant.TRAPDOOR, (p_176638_, p_176639_) -> trapdoorBuilder(p_176638_, Ingredient.of(p_176639_)))
                    .put(BlockFamily.Variant.POLISHED, (p_248019_, p_248020_) -> polishedBuilder(RecipeCategory.BUILDING_BLOCKS, p_248019_, Ingredient.of(p_248020_)))
                    .put(BlockFamily.Variant.WALL, (p_248024_, p_248025_) -> wallBuilder(RecipeCategory.DECORATIONS, p_248024_, Ingredient.of(p_248025_)))
                    .put(BlockFamily.Variant.CUT, (p_248026_, p_248027_) -> cutBuilder(RecipeCategory.BUILDING_BLOCKS, p_248026_, Ingredient.of(p_248027_)))
                    .build();

    public RecipeGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

    }




    private Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }

    private Item getItem(ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.get(resourceLocation);
    }

    private String name(Item block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Item block) {
        return BuiltInRegistries.ITEM.getKey(block);
    }
}
