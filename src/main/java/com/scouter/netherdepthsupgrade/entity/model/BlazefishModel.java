package com.scouter.netherdepthsupgrade.entity.model;

import com.scouter.netherdepthsupgrade.entity.entities.BlazefishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class BlazefishModel extends AnimatedTickingGeoModel<BlazefishEntity> {
    @Override
    public ResourceLocation getModelResource(BlazefishEntity object) {
        return prefix("geo/blazefish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlazefishEntity object) {
        return prefix("textures/entity/fish/blazefish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlazefishEntity animatable) {
        return prefix("animations/blazefish.animation.json");
    }
}
