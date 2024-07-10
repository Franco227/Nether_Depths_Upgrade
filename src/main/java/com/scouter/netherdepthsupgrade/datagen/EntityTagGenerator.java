package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.entity.NDUEntity;
import com.scouter.netherdepthsupgrade.utils.NDUTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EntityTagGenerator extends EntityTypeTagsProvider {


    public EntityTagGenerator(PackOutput p_256095_, CompletableFuture<HolderLookup.Provider> p_256572_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_256095_, p_256572_, NetherDepthsUpgrade.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ATags.EntityTypes.NOOP).add(EntityType.AREA_EFFECT_CLOUD).add(EntityType.MARKER).add(EntityType.INTERACTION);

        this.tag(EntityTypeTags.NOT_SCARY_FOR_PUFFERFISH).add(
                NDUEntity.BLAZEFISH.value(),
                NDUEntity.BONEFISH.value(),
                NDUEntity.EYEBALL_FISH.value(),
                NDUEntity.GLOWDINE.value(),
                NDUEntity.FORTRESS_GROUPER.value(),
                NDUEntity.LAVA_PUFFERFISH.value(),
                NDUEntity.OBSIDIAN_FISH.value(),
                NDUEntity.MAGMACUBEFISH.value(),
                NDUEntity.SOULSUCKER.value(),
                NDUEntity.WITHER_BONEFISH.value()
        );
        this.tag(EntityTypeTags.CAN_BREATHE_UNDER_WATER).add(
                NDUEntity.BLAZEFISH.value(),
                NDUEntity.BONEFISH.value(),
                NDUEntity.EYEBALL_FISH.value(),
                NDUEntity.GLOWDINE.value(),
                NDUEntity.FORTRESS_GROUPER.value(),
                NDUEntity.LAVA_PUFFERFISH.value(),
                NDUEntity.OBSIDIAN_FISH.value(),
                NDUEntity.MAGMACUBEFISH.value(),
                NDUEntity.SOULSUCKER.value(),
                NDUEntity.WITHER_BONEFISH.value()
        );
    }
}