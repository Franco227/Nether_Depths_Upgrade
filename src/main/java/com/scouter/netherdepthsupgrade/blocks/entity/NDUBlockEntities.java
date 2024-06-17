package com.scouter.netherdepthsupgrade.blocks.entity;

import com.scouter.netherdepthsupgrade.NetherDepthsUpgrade;
import com.scouter.netherdepthsupgrade.blocks.NDUBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NDUBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, NetherDepthsUpgrade.MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LavaGlassBlockEntity>> LAVA_GLASS =
            BLOCK_ENTITIES.register("lava_glass_entity", () ->
                    BlockEntityType.Builder.of(LavaGlassBlockEntity::new,
                            NDUBlocks.LAVA_GLASS.get()).build(null));
}
