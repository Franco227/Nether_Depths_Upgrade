package com.scouter.netherdepthsupgrade.entity.model;

import com.scouter.netherdepthsupgrade.entity.entities.SearingCodEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class SearingCodModel extends DefaultedEntityGeoModel<SearingCodEntity> {

    public SearingCodModel() {
        super(prefix("searing_cod"));
    }
}