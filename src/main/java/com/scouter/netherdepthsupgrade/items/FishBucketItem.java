package com.scouter.netherdepthsupgrade.items;

import com.scouter.netherdepthsupgrade.entity.BucketableLava;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.material.Fluid;

public class FishBucketItem  extends MobBucketItem {
    private final EntityType<?> type;

    public FishBucketItem(EntityType<?> fishTypeIn, Fluid fluid, Properties builder) {
        super(fishTypeIn,  fluid, SoundEvents.BUCKET_EMPTY_FISH, builder.stacksTo(1));
        this.type = fishTypeIn;
    }


    @Override
    public void spawn(ServerLevel pServerLevel, ItemStack pBucketedMobStack, BlockPos pPos) {
        Entity entity = type.spawn(pServerLevel, pBucketedMobStack, (Player)null, pPos, MobSpawnType.BUCKET, true, false);
        if (this.type.spawn(pServerLevel, pBucketedMobStack, null, pPos, MobSpawnType.BUCKET, true, false) instanceof BucketableLava bucketable) {
            CustomData customdata = pBucketedMobStack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY);
            bucketable.loadFromBucketTag(customdata.copyTag());
            bucketable.setFromBucket(true);
        }
    }
}
