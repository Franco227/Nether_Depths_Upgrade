package com.scouter.netherdepthsupgrade.datagen;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.utils.NDUTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NDUBiomeTagsProvider extends BiomeTagsProvider {
    public NDUBiomeTagsProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, NetherDepthsUpgrade.MODID, existingFileHelper);
    }

    protected void addTags() {
        tag(NDUTags.Biomes.IS_LAVA_PUFFERFISH_BIOME).add(Biomes.CRIMSON_FOREST).add(Biomes.WARPED_FOREST)
                .addOptional(new ResourceLocation("byg", "crimson_gardens"))
                .addOptional(new ResourceLocation("byg", "sythian_torrids"));
        tag(NDUTags.Biomes.IS_WITHER_BONEFISH_BIOME).add(Biomes.CRIMSON_FOREST).add(Biomes.SOUL_SAND_VALLEY)
                .addOptional(new ResourceLocation("byg", "subzero_hypogeal"))
                .addOptional(new ResourceLocation("gardens_of_the_dead", "whistling_woods"));
        tag(NDUTags.Biomes.IS_GLOWDINE_BIOME)
                .add(Biomes.BASALT_DELTAS)
                .add(Biomes.SOUL_SAND_VALLEY)
                .add(Biomes.NETHER_WASTES)
                .addOptional(new ResourceLocation("infernalexp", "glowstone_canyon"))
                .addOptional(new ResourceLocation("byg", "glowstone_gardens"));
        tag(NDUTags.Biomes.IS_MAGMACUBEFISH_BIOME).add(Biomes.BASALT_DELTAS)
                .addOptional(new ResourceLocation("byg", "embur_bog"))
                .addOptional(new ResourceLocation("byg", "magma_wastes"));
        tag(NDUTags.Biomes.IS_SOULSUCKER_BIOME).add(Biomes.SOUL_SAND_VALLEY)
                .addOptional(new ResourceLocation("byg", "warped_desert"))
                .addOptional(new ResourceLocation("byg", "wailing_garth"))
                .addOptional(new ResourceLocation("gardens_of_the_dead", "soulblight_forest"));
        tag(NDUTags.Biomes.IS_OBSIDIANFISH_BIOME).add(Biomes.BASALT_DELTAS)
                .addOptional(new ResourceLocation("byg", "brimstone_caverns"));

        tag(NDUTags.Biomes.IS_FORTRESS_GROUPER_BIOME)
                .add(Biomes.BASALT_DELTAS)
                .addTag(BiomeTags.HAS_NETHER_FORTRESS)
                .addOptional(new ResourceLocation("byg", "brimstone_caverns"));

        tag(NDUTags.Biomes.IS_EYEBALL_FISH_BIOME)
                .add(Biomes.CRIMSON_FOREST)
                .addOptional(new ResourceLocation("byg", "wailing_garth"));
    }
}
