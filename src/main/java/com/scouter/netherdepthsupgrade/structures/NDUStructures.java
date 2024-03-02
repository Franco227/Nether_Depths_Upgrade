package com.scouter.netherdepthsupgrade.structures;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class NDUStructures {
    public static final Logger LOGGER = LoggerFactory.getLogger("netherdepthsupgrade");
    public static StructureType<NetherFortressPiece> NETHER_FORTRESS_PIECE = () -> NetherFortressPiece.CODEC;

    public static void STRUCTURES(){
        Registry.register(BuiltInRegistries.STRUCTURE_TYPE, prefix("nether_fortress_piece"),  NETHER_FORTRESS_PIECE);
        LOGGER.info("Registering Structures for " + NetherDepthsUpgrade.MODID);
    }

}
