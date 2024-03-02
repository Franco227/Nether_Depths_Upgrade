package com.scouter.netherdepthsupgrade.entity.model;


import com.scouter.netherdepthsupgrade.entity.entities.SoulSuckerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class SoulSuckerModel extends AnimatedTickingGeoModel<SoulSuckerEntity> {
    @Override
    public ResourceLocation getModelResource(SoulSuckerEntity object) {
        return prefix("geo/soulsucker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoulSuckerEntity object) {
        return prefix("textures/entity/fish/soulsucker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoulSuckerEntity animatable) {
        return prefix("animations/soulsucker.animation.json");
    }
}
