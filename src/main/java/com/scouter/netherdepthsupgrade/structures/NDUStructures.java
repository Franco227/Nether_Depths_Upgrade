package com.scouter.netherdepthsupgrade.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NDUStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE, NetherDepthsUpgrade.MODID);
    public static final DeferredHolder<StructureType<?>, StructureType<NetherFortressPiece>> NETHER_FORTRESS_PIECE = STRUCTURES.register("nether_fortress_piece", () -> explicitStructureTypeTyping(NetherFortressPiece.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }
}
