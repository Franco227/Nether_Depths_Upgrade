package com.scouter.netherdepthsupgrade.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDUAdvancementTriggers {
    public static ItemUsedOnLocationTrigger PLACE_WET_LAVA_SPONGE = new ItemUsedOnLocationTrigger();

    public static void init(){
        CriteriaTriggers.register(prefix("placed_block").toString(), PLACE_WET_LAVA_SPONGE);
    }

}
