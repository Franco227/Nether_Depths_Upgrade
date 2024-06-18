package com.scouter.netherdepthsupgrade.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NetherDepthsUpgrade.MODID, existingFileHelper);
    }
    static final Map<BlockFamily.Variant, BiConsumer<BlockTagGenerator, Block>> SHAPE_CONSUMERS =
            ImmutableMap.<BlockFamily.Variant, BiConsumer<BlockTagGenerator, Block>>builder()
                    .put(BlockFamily.Variant.BUTTON, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.DOOR, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.CHISELED, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.CRACKED, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.CUSTOM_FENCE, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.FENCE, BlockTagGenerator::addToTagFence)
                    .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.FENCE_GATE, BlockTagGenerator::addToTagFenceGate)
                    .put(BlockFamily.Variant.SIGN, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.SLAB, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.STAIRS, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.PRESSURE_PLATE, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.TRAPDOOR, BlockTagGenerator::addToTag)
                    .put(BlockFamily.Variant.WALL, BlockTagGenerator::addToTagWall)
                    .build();
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


    }
    
    public void addToTag(Block block){
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(block);
    }

    public void addToTagWall(Block block){
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(block);
        this.tag(BlockTags.WALLS)
                .add(block);

    }

    public void addToTagFence(Block block){
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(block);
        this.tag(BlockTags.WOODEN_FENCES)
                .add(block);
        this.tag(BlockTags.FENCES)
                .add(block);
    }

    public void addToTagFenceGate(Block block){
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(block);
        this.tag(BlockTags.WOODEN_FENCES)
                .add(block);
        this.tag(BlockTags.FENCE_GATES)
                .add(block);
    }

}
