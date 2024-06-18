package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.items.NDUItems;
import com.scouter.netherdepthsupgrade.utils.NDUTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, NetherDepthsUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.FISHING_ENCHANTABLE).add(NDUItems.LAVA_FISHING_ROD.asItem());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(NDUItems.LAVA_FISHING_ROD.asItem());
        tag(ItemTags.FOOT_ARMOR).add(NDUItems.SOUL_SUCKER_BOOTS.asItem());
        tag(NDUTags.Items.NETHER_SALAD_FOODS)
                .add(NDUItems.WARPED_KELP.get())
                .add(NDUItems.WARPED_SEAGRASS.get())
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.WARPED_FUNGUS);
        tag(ItemTags.FISHES)
                .add(NDUItems.LAVA_PUFFERFISH.get())
                .add(NDUItems.GLOWDINE.get())
                .add(NDUItems.SOULSUCKER.get())
                .add(NDUItems.OBSIDIANFISH.get())
                .add(NDUItems.BONEFISH.get())
                .add(NDUItems.WITHER_BONEFISH.get())
                .add(NDUItems.FORTRESS_GROUPER.get())
                .add(NDUItems.EYEBALL_FISH.get())
                .add(NDUItems.BLAZEFISH.get())
                .add(NDUItems.SEARING_COD.get())
                .add(NDUItems.MAGMACUBEFISH.get());
    }
}