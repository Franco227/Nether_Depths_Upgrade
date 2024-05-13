package com.scouter.netherdepthsupgrade.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.scouter.netherdepthsupgrade.entity.entities.LavaPufferfishEntity;
import com.scouter.netherdepthsupgrade.entity.model.LavaPufferfishModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LavaPufferfishRenderer extends GeoEntityRenderer<LavaPufferfishEntity> {

    private int puffStateO = 3;

    public LavaPufferfishRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LavaPufferfishModel());
        this.shadowRadius = 0.2F;

    }



    public void render(LavaPufferfishEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        int i = pEntity.getPuffState();
        this.puffStateO = i;
        this.shadowRadius = 0.1F + 0.1F * (float)i;
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    protected void applyRotations(LavaPufferfishEntity animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        poseStack.translate(0.0D, (double)(Mth.cos(ageInTicks * 0.05F) * 0.08F), 0.0D);
        super.applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick);
    }
}