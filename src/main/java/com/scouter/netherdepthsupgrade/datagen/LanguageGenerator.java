package com.scouter.netherdepthsupgrade.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.blocks.NDUBlocks;
import com.scouter.netherdepthsupgrade.effect.MobEffects;
import com.scouter.netherdepthsupgrade.enchantments.NDUEnchantments;
import com.scouter.netherdepthsupgrade.entity.NDUEntity;
import com.scouter.netherdepthsupgrade.items.NDUItems;
import com.scouter.netherdepthsupgrade.potion.NDUPotions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, NetherDepthsUpgrade.MODID, "en_us");
    }
    private final Set<Item> itemSet = new HashSet<>();

    static final Map<BlockFamily.Variant, BiConsumer<LanguageGenerator, Block>> SHAPE_CONSUMERS =
            ImmutableMap.<BlockFamily.Variant, BiConsumer<LanguageGenerator, Block>>builder()
                    .put(BlockFamily.Variant.BUTTON, LanguageGenerator::add)
                    .put(BlockFamily.Variant.DOOR, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CHISELED, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CRACKED, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CUSTOM_FENCE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.FENCE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.FENCE_GATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.SIGN, LanguageGenerator::add)
                    .put(BlockFamily.Variant.SLAB, LanguageGenerator::add)
                    .put(BlockFamily.Variant.STAIRS, LanguageGenerator::add)
                    .put(BlockFamily.Variant.PRESSURE_PLATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.TRAPDOOR, LanguageGenerator::add)
                    .put(BlockFamily.Variant.WALL, LanguageGenerator::add)
                    .build();
    @Override
    protected void addTranslations(){

        //BLOCKS
        addBlock(NDUBlocks.LAVA_SPONGE, "Lava Sponge");
        addBlock(NDUBlocks.WET_LAVA_SPONGE, "Wet Lava Sponge");
        addBlock(NDUBlocks.WARPED_KELP, "Warped Kelp");
        addBlock(NDUBlocks.WARPED_SEAGRASS, "Warped Seagrass");
        addBlock(NDUBlocks.WARPED_KELP_BLOCK, "Warped Kelp Block");
        addBlock(NDUBlocks.WARPED_KELP_CARPET_BLOCK, "Warped Kelp Carpet");
        addBlock(NDUBlocks.CRIMSON_KELP, "Crimson Kelp");
        addBlock(NDUBlocks.CRIMSON_SEAGRASS, "Crimson Seagrass");
        addBlock(NDUBlocks.CRIMSON_KELP_BLOCK, "Crimson Kelp Block");
        addBlock(NDUBlocks.CRIMSON_KELP_CARPET_BLOCK, "Crimson Kelp Carpet");
        addBlock(NDUBlocks.TALL_CRIMSON_SEAGRASS, "Tall Crimson Seagrass");
        addBlock(NDUBlocks.TALL_WARPED_SEAGRASS, "Tall Warped Seagrass");
        addBlock(NDUBlocks.WARPED_KELP_PLANT, "Warped Kelp Plant");
        addBlock(NDUBlocks.CRIMSON_KELP_PLANT, "Crimson Kelp Plant");

        //EGGS
        addItem(NDUItems.LAVA_PUFFERFISH_SPAWN_EGG, "Lava Pufferfish Spawn Egg");
        addItem(NDUItems.OBSIDIANFISH_SPAWN_EGG, "Obsidianfish Spawn Egg");
        addItem(NDUItems.SEARING_COD_SPAWN_EGG, "Searing Cod Spawn Egg");
        addItem(NDUItems.BONEFISH_SPAWN_EGG, "Bonefish Spawn Egg");
        addItem(NDUItems.WITHER_BONEFISH_SPAWN_EGG, "Wither Bonefish Spawn Egg");
        addItem(NDUItems.BLAZEFISH_SPAWN_EGG, "Blazefish Spawn Egg");
        addItem(NDUItems.MAGMACUBEFISH_SPAWN_EGG, "Magma Cube Fish Spawn Egg");
        addItem(NDUItems.GLOWDINE_SPAWN_EGG, "Glowdine Spawn Egg");
        addItem(NDUItems.SOULSUCKER_SPAWN_EGG, "Soul Sucker Spawn Egg");
        addItem(NDUItems.FORTRESS_GROUPER_SPAWN_EGG, "Fortress Grouper Spawn Egg");
        addItem(NDUItems.EYEBALL_FISH_SPAWN_EGG, "Eyeball Fish Spawn Egg");
        addItem(NDUItems.FORTRESS_GROUPER_PLATE, "Fortress Grouper Plate");
        addItem(NDUItems.EYEBALL_FISH_EYE, "Eyeball Fish Eye");
        //POTIONS
        addPotion(NDUPotions.LAVA_VISION, "Potion of Lava Vision", "lava_vision");
        addPotion(NDUPotions.LONG_LAVA_VISION, "Potion of Lava Vision", "long_lava_vision");

        addPotion(NDUPotions.WITHER, "Potion of Wither", "lava_puffer_wither");
        addPotion(NDUPotions.LONG_WITHER, "Potion of Wither", "lava_puffer_long_wither");

        addPotion(NDUPotions.RESISTANCE, "Potion of the Steadfast Treader", "obsidianfish_resistance");
        addPotion(NDUPotions.LONG_RESISTANCE, "Potion of the Steadfast Treader", "obsidianfish_long_resistance");
        addPotion(NDUPotions.STRONG_RESISTANCE, "Potion of the Steadfast Treader", "obsidianfish_strong_resistance");

        addPotion(NDUPotions.GLOWING, "Potion of Glowing", "glowdine_glowing");
        addPotion(NDUPotions.LONG_GLOWING, "Potion of Glowing", "glowdine_long_glowing");

        addTippedArrow(NDUPotions.LAVA_VISION, "Lava Vision");
        addTippedArrow(NDUPotions.WITHER, "Wither");
        addTippedArrow(NDUPotions.LONG_WITHER, "Wither");
        addTippedArrow(NDUPotions.RESISTANCE, "the Steadfast Treader");
        addTippedArrow(NDUPotions.LONG_RESISTANCE, "the Steadfast Treader");
        addTippedArrow(NDUPotions.STRONG_RESISTANCE, "the Steadfast Treader");
        addTippedArrow(NDUPotions.GLOWING, "Glowing");
        addTippedArrow(NDUPotions.LONG_GLOWING, "Glowing");


        //ENTITIES
        addEntityType(NDUEntity.LAVA_PUFFERFISH, "Lava Pufferfish");
        addEntityType(NDUEntity.OBSIDIAN_FISH, "Obsidianfish");
        addEntityType(NDUEntity.SEARING_COD, "Searing Cod");
        addEntityType(NDUEntity.BONEFISH, "Bonefish");
        addEntityType(NDUEntity.WITHER_BONEFISH, "Wither Bonefish");
        addEntityType(NDUEntity.BLAZEFISH, "Blazefish");
        addEntityType(NDUEntity.MAGMACUBEFISH, "Magma Cube Fish");
        addEntityType(NDUEntity.GLOWDINE, "Glowdine");
        addEntityType(NDUEntity.SOULSUCKER, "Soul Sucker");
        addEntityType(NDUEntity.FORTRESS_GROUPER, "Fortress Grouper");
        addEntityType(NDUEntity.EYEBALL_FISH, "Eyeball Fish");
        addEntityType(NDUEntity.LAVA_BOBBER, "Lava Bobber");

        addItem(NDUItems.LAVA_PUFFERFISH_BUCKET, "Bucket of Lava Pufferfish");
        addItem(NDUItems.LAVA_PUFFERFISH, "Lava Pufferfish");
        addItem(NDUItems.OBSIDIANFISH, "Obsidianfish");
        addItem(NDUItems.OBSIDIANFISH_BUCKET, "Bucket of Obsidianfish");
        addItem(NDUItems.SEARING_COD_BUCKET, "Bucket of Searing Cod");
        addItem(NDUItems.SEARING_COD, "Searing Cod");
        addItem(NDUItems.BONEFISH_BUCKET, "Bucket of Bonefish");
        addItem(NDUItems.BONEFISH, "Bonefish");
        addItem(NDUItems.WITHER_BONEFISH_BUCKET, "Bucket of Wither Bonefish");
        addItem(NDUItems.WITHER_BONEFISH, "Wither Bonefish");
        addItem(NDUItems.BLAZEFISH_BUCKET, "Bucket of Blazefish");
        addItem(NDUItems.BLAZEFISH, "Blazefish");
        addItem(NDUItems.MAGMACUBEFISH_BUCKET, "Bucket of Magma Cube Fish");
        addItem(NDUItems.MAGMACUBEFISH, "Magma Cube Fish");
        addItem(NDUItems.GLOWDINE_BUCKET, "Bucket of Glowdine");
        addItem(NDUItems.GLOWDINE, "Glowdine");
        addItem(NDUItems.SOULSUCKER_BUCKET, "Bucket of Soul Sucker");
        addItem(NDUItems.SOULSUCKER, "Soul Sucker");
        addItem(NDUItems.FORTRESS_GROUPER, "Fortress Grouper");
        addItem(NDUItems.FORTRESS_GROUPER_BUCKET, "Bucket of Fortress Grouper");
        addItem(NDUItems.EYEBALL_FISH, "Eyeball Fish");
        addItem(NDUItems.EYEBALL_FISH_BUCKET, "Bucket of Eyeball Fish");



        addItem(NDUItems.SOUL_SUCKER_BOOTS, "Soul Sucker Boots");
        addItem(NDUItems.SOUL_SUCKER_LEATHER, "Soul Sucker Leather");
        addItem(NDUItems.LAVA_FISHING_ROD, "Lava Fishing Rod");

        //Compat Items
        //addItem(FarmersDelightCompat.BAKED_BLAZEFISH_STEW, "Baked Blazefish Stew");
        //addItem(FarmersDelightCompat.BAKED_GLOWDINE_STEW, "Baked Glowdine Stew");
        //addItem(FarmersDelightCompat.BAKED_LAVA_PUFFERFISH_STEW, "Baked Lava Pufferfish Stew");
        //addItem(FarmersDelightCompat.BAKED_MAGMACUBEFISH_STEW, "Baked Magma Cube Fish Stew");
        //addItem(FarmersDelightCompat.BAKED_OBSIDIANFISH_STEW, "Baked Obsidianfish Stew");
        //addItem(FarmersDelightCompat.BAKED_SEARING_COD_STEW, "Baked Searing Cod Stew");
        //addItem(FarmersDelightCompat.BAKED_SOULSUCKER_STEW, "Baked Soulsucker Stew");
        //addItem(FarmersDelightCompat.SEARING_COD_SLICE, "Searing Cod Slice");
        //addItem(FarmersDelightCompat.SOULSUCKER_SLICE, "Soulsucker Slice");
        //addItem(FarmersDelightCompat.BLAZEFISH_SLICE, "Blazefish Slice");
        //addItem(FarmersDelightCompat.LAVA_PUFFERFISH_SLICE, "Lava Pufferfish Slice");
        //addItem(FarmersDelightCompat.GLOWDINE_SLICE, "Glowdine Slice");
        //addItem(FarmersDelightCompat.MAGMACUBEFISH_SLICE, "Magma Cube Fish Slice");
        //addItem(FarmersDelightCompat.OBSIDIANFISH_SLICE, "Obsidianfish Slice");
        //addItem(FarmersDelightCompat.COOKED_SOULSUCKER_SLICE, "Cooked Soulsucker Slice");
        //addItem(FarmersDelightCompat.COOKED_LAVA_PUFFERFISH_SLICE, "Cooked Lava Pufferfish Slice");
        //addItem(FarmersDelightCompat.COOKED_GLOWDINE_SLICE, "Cooked Glowdine Slice");
        //addItem(FarmersDelightCompat.COOKED_MAGMACUBEFISH_SLICE, "Cooked Magma Cube Fish Slice");
        //addItem(FarmersDelightCompat.COOKED_OBSIDIANFISH_SLICE, "Cooked Obsidianfish Slice");
        //addItem(FarmersDelightCompat.GRILLED_BLAZEFISH, "Grilled Blazefish");
        //addItem(FarmersDelightCompat.GRILLED_LAVA_PUFFERFISH, "Grilled Lava Pufferfish");
        //addItem(FarmersDelightCompat.GRILLED_MAGMA_CUBE_FISH, "Grilled Magma Cube Fish");
        //addItem(FarmersDelightCompat.GRILLED_GLOWDINE, "Grilled Glowdine");
        //addItem(FarmersDelightCompat.GRILLED_SOULSUCKER, "Grilled Soulsucker");
        //addItem(FarmersDelightCompat.GRILLED_SEARING_COD, "Grilled Searing Cod");
        //addItem(FarmersDelightCompat.GRILLED_OBSIDIANFISH, "Grilled Obsidianfish");
        //addItem(FarmersDelightCompat.BLAZEFISH_ROLL, "Blazefish Roll");
        //addItem(FarmersDelightCompat.SOULSUCKER_ROLL, "Soulsucker Roll");
        //addItem(FarmersDelightCompat.GLOWDINE_ROLL, "Glowdine Roll");
        //addItem(FarmersDelightCompat.LAVA_PUFFERFISH_ROLL, "Lava Pufferfish Roll");
        //addItem(FarmersDelightCompat.SEARING_COD_ROLL, "Searing Cod Roll");
        //addItem(FarmersDelightCompat.MAGMA_CUBE_FISH_ROLL, "Magma Cube Fish Roll");
        //addItem(FarmersDelightCompat.OBSIDIANFISH_ROLL, "Obsidianfish Roll");
        //addItem(FarmersDelightCompat.WARPED_KELP_ROLL_SLICE, "Warped Kelp Roll Slice");
        //addItem(FarmersDelightCompat.WARPED_KELP_ROLL, "Warped Kelp Roll");
        //addItem(FarmersDelightCompat.NETHER_RICE_ROLL_MEDLEY_BLOCKITEM, "Nether Rice Roll Medley");

        //ENCHANTMENTS
        add("enchantment.netherdepthsupgrade.hell_strider", "Hell Strider");

        //EFFECTS
        addEffect(MobEffects.LAVA_VISION, "Lava Vision");

        //TABS
        add("itemGroup.netherdepthsupgrade", "Nether Depths Upgrade");
        add("itemGroup.netherdepthsupgrade_fish", "Nether Depths Upgrade Fish");
        add("itemGroup.netherdepthsupgrade_food", "Nether Depths Upgrade Food");
        //Enchantment description
        add("enchantment.netherdepthsupgrade.hell_strider.desc","As you glide through the molten rock, you feel a surge of speed and power coursing through your veins, allowing you to swim through lava with ease and grace.");
        add("netherdepthsupgrade.advancement.root", "Nether Depths Upgrade");
        add("netherdepthsupgrade.advancement.root.desc", "A whole new world awaits you below the depths!");
        add("netherdepthsupgrade.advancement.place_lava_glass", "Lavaquarium");
        add("netherdepthsupgrade.advancement.place_lava_glass.desc", "Place down a Lava Glass block and start building your own Lavaquarium");
        add("netherdepthsupgrade.advancement.turn_wet_lava_sponge", "Dry Lava Sponge?");
        add("netherdepthsupgrade.advancement.turn_wet_lava_sponge.desc", "Place a Wet Lava Sponge underwater to dry it");
        add("netherdepthsupgrade.advancement.lava_fishing_master", "Lava Fishing Master");
        add("netherdepthsupgrade.advancement.lava_fishing_master.desc", "Fish all the fish from the depths");
        add("netherdepthsupgrade.advancement.get_wet_lava_sponge", "Sponges in the depths?");
        add("netherdepthsupgrade.advancement.get_wet_lava_sponge.desc", "Obtain a Wet Lava Sponge down from the depths");
        add("netherdepthsupgrade.advancement.get_eyeball_fish", "It's still looking at me!");
        add("netherdepthsupgrade.advancement.get_eyeball_fish.desc", "Obtain an Eyeball Fish to explore the depths");
        add("netherdepthsupgrade.advancement.filled_soulsucker_bucket", "Cleaning!");
        add("netherdepthsupgrade.advancement.filled_soulsucker_bucket.desc", "Obtain a Soulsucker to clean your Lavaquarium");
        add("netherdepthsupgrade.advancement.craft_lava_fishing_rod", "Peaceful.. Tidings?");
        add("netherdepthsupgrade.advancement.craft_lava_fishing_rod.desc", "Craft a Lava Fishing Rod and start your Lava Fishing journey");
        add("netherdepthsupgrade.advancement.abyssal_flora_expert", "Abyssal Flora Expert");
        add("netherdepthsupgrade.advancement.abyssal_flora_expert.desc", "Obtain all Lava Plants from the depths");

        //Compat Item Flavor Text
        add("item.netherdepthsupgrade.blazefish_slice.flavor_text", "Sizzling and steaming as they hit the cutting board, their fiery essence infusing the air with the smell of molten rock and burning magic.");
        add("item.netherdepthsupgrade.searing_cod_slice.flavor_text", "A sight to behold, the shimmering, searing flesh releasing waves of heat and energy as they hit the cutting board, almost as if they are alive and writhing in pain.");
        add("item.netherdepthsupgrade.soulsucker_slice.flavor_text", "A dark and unsettling sight, their ethereal, shimmering flesh seeming to pulsate and writhe as they are cut on the cutting board, as if they are still alive and hungry for more souls.");
        add("item.netherdepthsupgrade.obsidianfish_slice.flavor_text", "Sizzling can be heard as they hit the hot pan, the black sheen of the obsidian skin gleaming in the light, a testament to the creature's survival in the molten depths of the lava.");
        add("item.netherdepthsupgrade.magmacubefish_slice.flavor_text", "A steamy heat can be seen as they were expertly sliced on the cutting board, the vibrant red and orange hues of the magma cube fish's skin a testament to its fiery home");
        add("item.netherdepthsupgrade.glowdine_slice.flavor_text", "A soft and radiant glow can be seen permeating, the shimmering particles released from the fish's skin adding an otherworldly touch to the dish.");
        add("item.netherdepthsupgrade.lava_pufferfish_slice.flavor_text", "Sizzling on the cutting board, their fiery red skin a warning of the potentially toxic spines hidden within. Only the most skilled chefs dare to handle these dangerous, yet delicious fish.");
        add("item.netherdepthsupgrade.cooked_soulsucker_slice.flavor_text", "A slice exuding a rich, smoky aroma as it is served, the heat of the furnace bringing out the full flavor of the soulsucker's succulent flesh.");
        add("item.netherdepthsupgrade.cooked_obsidianfish_slice.flavor_text", "Glistening in the light, the heat of the furnace enhancing the shiny, black sheen of the obsidian skin as it adds a unique, smoky flavor to the tender fish meat.");
        add("item.netherdepthsupgrade.cooked_magmacubefish_slice.flavor_text", "Sizzling on the hot stones of the furnace, the magma cube fish slice exudes a tantalizing aroma that tempts the taste buds with its smoky, fiery flavors.");
        add("item.netherdepthsupgrade.cooked_glowdine_slice.flavor_text", "Tender and juicy, the cooked glowdine slice is kissed by flames in the furnace, infusing it with a subtle, smoky essence that pairs perfectly with its naturally sweet, buttery flavor.");
        add("item.netherdepthsupgrade.cooked_lava_pufferfish_slice.flavor_text", "The lava pufferfish slice, expertly cooked in the furnace to remove any toxins, reveals a succulent, tender flesh that is infused with a fiery, volcanic essence and a hint of sweetness.");
        add("item.netherdepthsupgrade.baked_soulsucker_stew.flavor_text", "Crafted with succulent slices of Soulsucker, hearty potatoes, protein-packed eggs, and ripe tomatoes, all imbued with the magical essence of Absorption and Dig speed.");
        add("item.netherdepthsupgrade.baked_obsidianfish_stew.flavor_text", "Brimming with tender slices of Obsidianfish, creamy potatoes, protein-packed eggs, and juicy tomatoes, all fortified with the empowering effects of Damage Resistance.");
        add("item.netherdepthsupgrade.baked_magmacubefish_stew.flavor_text", "Filled with savory slices of fish and hearty vegetables, guaranteed to give you fire resistance and a warm glow from within.");
        add("item.netherdepthsupgrade.baked_glowdine_stew.flavor_text", "Made with succulent slices of glowdine, creamy potatoes, rich eggs, and juicy tomatoes, you can feel your movement speed increase with every satisfying spoonful.");
        add("item.netherdepthsupgrade.baked_lava_pufferfish_stew.flavor_text", "Experience the fiery flavors of lava pufferfish stew, featuring tender slices of the exotic fish, creamy potatoes, rich eggs, and juicy tomatoes, all brought together in a savory broth that grants the gift of lava vision.");
        add("item.netherdepthsupgrade.baked_blazefish_stew.flavor_text", "Feast on a savory bowl of blazefish stew, made with juicy blazefish slices, creamy potatoes, rich eggs, and plump tomatoes, and watch your damage output soar with every fiery spoonful.");
        add("item.netherdepthsupgrade.baked_searing_cod_stew.flavor_text", "Experience the heat of the lava with a bowl of searing cod stew, brimming with succulent slices of searing cod, creamy potatoes, rich eggs, and ripe tomatoes. Each steaming spoonful will invigorate you with increased movement speed.");
        add("item.netherdepthsupgrade.blazefish_roll.flavor_text", "Experience the fiery flavor of blazefish in every bite a blazefish roll, made with succulent blazefish slices and perfectly cooked rice.");
        add("item.netherdepthsupgrade.soulsucker_roll.flavor_text", "Indulge in the mysterious and addictive taste of soulsucker in a delectable soulsucker roll, made with thinly sliced soulsucker and perfectly cooked rice.");
        add("item.netherdepthsupgrade.obsidianfish_roll.flavor_text", "Experience the bold and unique flavor of obsidianfish in an obsidianfish roll, filled with thin slices of the rare fish and expertly cooked rice.");
        add("item.netherdepthsupgrade.searing_cod_roll.flavor_text", "Savor the bold and flavorful taste of searing cod in every bite of a searing cod roll, made with thin slices of the savory fish and perfectly cooked rice.");
        add("item.netherdepthsupgrade.lava_pufferfish_roll.flavor_text", "Experience the spicy and fiery taste of lava pufferfish in a lava pufferfish roll, filled with thin slices of the exotic fish and perfectly cooked rice.");
        add("item.netherdepthsupgrade.magmacubefish_roll.flavor_text", "Sizzling with the heat of a thousand volcanoes, this magma cube fish roll brings the fiery flavor of the Nether to your taste buds with every bite.");
        add("item.netherdepthsupgrade.glowdine_roll.flavor_text", "Experience the otherworldly essence of the Nether with every bite of this glowdine roll, filled with delicate slices of the elusive, luminescent fish and wrapped in succulent sushi rice.");
        add("item.netherdepthsupgrade.grilled_blazefish.flavor_text", "Indulge in the fiery flavors of the grilled blazefish, bursting with the heat of the Nether and enhanced with sweet berries, savory cabbage, and caramelized onions for a damage boost that will have you feeling unstoppable.");
        add("item.netherdepthsupgrade.grilled_soulsucker.flavor_text", "Indulge in the savory, succulent flavors of the grilled soulsucker, bursting with the sweetness of berries and the crunch of cabbage and onions. Its heavenly taste is only surpassed by the positive effects it imparts, including a boost to your digging prowess and absorption capabilities.");
        add("item.netherdepthsupgrade.grilled_obsidianfish.flavor_text", "Indulge in the smoky, succulent flavor of grilled obsidianfish, infused with the sweet tang of berries and the crunch of cabbage and onions. One bite and you'll feel the added bonus of damage resistance coursing through your veins.");
        add("item.netherdepthsupgrade.grilled_magmacubefish.flavor_text", "Feast on the sizzling, spicy goodness of grilled magma cube fish, bursting with the sweetness of berries and the crunch of cabbage and onions. As you savor each bite, you'll feel the heat of fire resistance burning within you.");
        add("item.netherdepthsupgrade.grilled_searing_cod.flavor_text", "Experience the savory, flame-kissed flavor of grilled searing cod, enhanced with the sweetness of berries and the crunch of cabbage and onions. As you enjoy this delicious dish, you'll feel your movement speed increase with each bite.");
        add("item.netherdepthsupgrade.grilled_glowdine.flavor_text", "Savory and succulent, this grilled glowdine is bursting with the flavors of sweet berries, crunchy cabbage, and caramelized onions. One bite will leave you feeling light on your feet, thanks to its movement-enhancing properties.");
        add("item.netherdepthsupgrade.grilled_lava_pufferfish.flavor_text", "Indulge in the fiery flavor of grilled lava pufferfish, infused with sweet berries, crunchy cabbage, and savory onions, and gain the power of lava vision with every bite.");
        add("item.netherdepthsupgrade.warped_kelp_roll_slice.flavor_text", "Sliced from the popular warped kelp roll, this bite-sized piece packs a punch of flavor, with a hint of the bizarre and unexpected. Enjoy the combination of creamy rice, and crisp carrots, all wrapped up in a delicate warped kelp wrapper.");
        add("item.netherdepthsupgrade.warped_kelp_roll.flavor_text", "Indulge in the savory and slightly bizarre flavors of the signature warped kelp roll, made with tender strands of kelp, fluffy cooked rice, and crunchy carrots, all wrapped up in a perfectly crispy warped kelp wrapper.");
        add("item.netherdepthsupgrade.nether_rice_roll_medley_block.flavor_text", "The nether rice roll medley is a true feast for the senses. Featuring a combination of warped kelp roll, magma cube fish roll, soulsucker roll, searing cod roll, lava pufferfish roll and glowdine roll, this block is sure to satisfy even the most adventurous palate.");

        add("item.netherdepthsupgrade.descriptionitem.hover_info", "Press shift for more info!");
    }
    public void add(DeferredBlock<Block> block, String name){
        add(block.get().asItem(), name);
    }

    public void add(Item key, String name) {
        itemSet.add(key);
        add(key.getDescriptionId(), name);
    }

    public void addLeftOver(Item key) {
        //if(key instanceof BlockItem item && item.getBlock() instanceof WallSignBlock) return;
        String keyDescription = name(key);
        String[] parts = keyDescription.replace("item.scalebound.", "").split("_");
        StringBuilder modifiedString = new StringBuilder();
        int i = 0;
        for (String part : parts) {
            if(0 == i){
                modifiedString.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            } else {
                modifiedString.append(" ").append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            }
            i++;
        }
        modifiedString.trimToSize();
        String finalModifiedString = modifiedString.toString();
        add(key, finalModifiedString);
    }

    public void add(Block key) {
        //if(key instanceof WallSignBlock) return;
        itemSet.add(key.asItem());
        String keyDescription = key.getDescriptionId();
        String[] parts = keyDescription.replace("block.scalebound.", "").split("_");
        StringBuilder modifiedString = new StringBuilder();
        int i = 0;
        for (String part : parts) {
            if(0 == i){
                modifiedString.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            } else {
                modifiedString.append(" ").append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            }
            i++;
        }
        modifiedString.trimToSize();
        String finalModifiedString = modifiedString.toString();
        add(key.getDescriptionId(), finalModifiedString);
    }

    public void addTabName(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void add(CreativeModeTab key, String name) {
        add(key.getDisplayName().getString(), name);
    }

    public void addPotion(Supplier<? extends Potion> key, String name, String regName) {
        add(key.get(), name, regName);
    }

    public void add(Potion key, String name, String regName) {
        add("item.minecraft.potion.effect." + regName, name);
        add("item.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("item.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }

    public void addEnchantDescription( Enchantment enchantment, String description){
        add(enchantment.description()+ ".desc", description);
    }



    public void addTippedArrow(Supplier<? extends Potion> key, String name) {
        addTippedArrow(key.get(), name);
    }

    private void addTippedArrow(Potion key, String name) {
        add("item.minecraft.tipped_arrow.effect." + key, "Arrow of " + name);
    }

    private String name(Item block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Item block) {
        return BuiltInRegistries.ITEM.getKey(block);
    }

}

