package com.scouter.netherdepthsupgrade.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.scouter.netherdepthsupgrade.entity.entities.LavaFishingBobberEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import static com.scouter.netherdepthsupgrade.NetherDepthsUpgrade.prefix;

public class LavaFishingBobberRenderer extends EntityRenderer<LavaFishingBobberEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = prefix("textures/entity/lava_fishing_hook.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutout(TEXTURE_LOCATION);
    private static final double VIEW_BOBBING_SCALE = 960.0D;

    public LavaFishingBobberRenderer(EntityRendererProvider.Context p_174117_) {
        super(p_174117_);
    }

    public void render(LavaFishingBobberEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        Player player = pEntity.getPlayerOwner();
        if (player != null) {
            pMatrixStack.pushPose();
            pMatrixStack.pushPose();
            pMatrixStack.scale(0.5F, 0.5F, 0.5F);
            pMatrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            pMatrixStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            PoseStack.Pose posestack$pose = pMatrixStack.last();
            Matrix4f matrix4f = posestack$pose.pose();
            Matrix3f matrix3f = posestack$pose.normal();
            VertexConsumer vertexconsumer = pBuffer.getBuffer(RENDER_TYPE);
            vertex(vertexconsumer, posestack$pose, pPackedLight, 0.0F, 0, 0, 1);
            vertex(vertexconsumer, posestack$pose, pPackedLight, 1.0F, 0, 1, 1);
            vertex(vertexconsumer, posestack$pose, pPackedLight, 1.0F, 1, 1, 0);
            vertex(vertexconsumer, posestack$pose, pPackedLight, 0.0F, 1, 0, 0);
            pMatrixStack.popPose();
            int i = player.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
            ItemStack itemstack = player.getMainHandItem();
            if (!(itemstack.getItem() instanceof FishingRodItem)) {
                i = -i;
            }

            float f = player.getAttackAnim(pPartialTicks);
            float f1 = Mth.sin(Mth.sqrt(f) * (float) Math.PI);
            float f2 = Mth.lerp(pPartialTicks, player.yBodyRotO, player.yBodyRot) * ((float) Math.PI / 180F);
            double d0 = (double) Mth.sin(f2);
            double d1 = (double) Mth.cos(f2);
            double d2 = (double) i * 0.35D;
            double d3 = 0.8D;
            double d4;
            double d5;
            double d6;
            float f3;
            if ((this.entityRenderDispatcher.options == null || this.entityRenderDispatcher.options.getCameraType().isFirstPerson()) && player == Minecraft.getInstance().player) {
                double d7 = 960.0D / (double)this.entityRenderDispatcher.options.fov().get().intValue();
                Vec3 vec3 = this.entityRenderDispatcher.camera.getNearPlane().getPointOnPlane((float) i * 0.525F, -0.1F);
                vec3 = vec3.scale(d7);
                vec3 = vec3.yRot(f1 * 0.5F);
                vec3 = vec3.xRot(-f1 * 0.7F);
                d4 = Mth.lerp((double) pPartialTicks, player.xo, player.getX()) + vec3.x;
                d5 = Mth.lerp((double) pPartialTicks, player.yo, player.getY()) + vec3.y;
                d6 = Mth.lerp((double) pPartialTicks, player.zo, player.getZ()) + vec3.z;
                f3 = player.getEyeHeight();
            } else {
                d4 = Mth.lerp((double) pPartialTicks, player.xo, player.getX()) - d1 * d2 - d0 * 0.8D;
                d5 = player.yo + (double) player.getEyeHeight() + (player.getY() - player.yo) * (double) pPartialTicks - 0.45D;
                d6 = Mth.lerp((double) pPartialTicks, player.zo, player.getZ()) - d0 * d2 + d1 * 0.8D;
                f3 = player.isCrouching() ? -0.1875F : 0.0F;
            }

            double d9 = Mth.lerp((double) pPartialTicks, pEntity.xo, pEntity.getX());
            double d10 = Mth.lerp((double) pPartialTicks, pEntity.yo, pEntity.getY()) + 0.25D;
            double d8 = Mth.lerp((double) pPartialTicks, pEntity.zo, pEntity.getZ());
            float f4 = (float) (d4 - d9);
            float f5 = (float) (d5 - d10) + f3;
            float f6 = (float) (d6 - d8);
            VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RenderType.lineStrip());
            PoseStack.Pose posestack$pose1 = pMatrixStack.last();
            int j = 16;

            for (int k = 0; k <= 16; ++k) {
                stringVertex(f4, f5, f6, vertexconsumer1, posestack$pose1, fraction(k, 16), fraction(k + 1, 16));
            }

            pMatrixStack.popPose();
            super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        }
    }

    private static float fraction(int p_114691_, int p_114692_) {
        return (float) p_114691_ / (float) p_114692_;
    }


    private static void vertex(VertexConsumer pConsumer, PoseStack.Pose pPose, int pPackedLight, float pX, int pY, int pU, int pV) {
        pConsumer.addVertex(pPose, pX - 0.5F, (float)pY - 0.5F, 0.0F)
                .setColor(-1)
                .setUv((float)pU, (float)pV)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(pPackedLight)
                .setNormal(pPose, 0.0F, 1.0F, 0.0F);
    }

    private static void stringVertex(
            float pX, float pY, float pZ, VertexConsumer pConsumer, PoseStack.Pose pPose, float pStringFraction, float pNextStringFraction
    ) {
        float f = pX * pStringFraction;
        float f1 = pY * (pStringFraction * pStringFraction + pStringFraction) * 0.5F + 0.25F;
        float f2 = pZ * pStringFraction;
        float f3 = pX * pNextStringFraction - f;
        float f4 = pY * (pNextStringFraction * pNextStringFraction + pNextStringFraction) * 0.5F + 0.25F - f1;
        float f5 = pZ * pNextStringFraction - f2;
        float f6 = Mth.sqrt(f3 * f3 + f4 * f4 + f5 * f5);
        f3 /= f6;
        f4 /= f6;
        f5 /= f6;
        pConsumer.addVertex(pPose, f, f1, f2).setColor(-16777216).setNormal(pPose, f3, f4, f5);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(LavaFishingBobberEntity pEntity) {
        return TEXTURE_LOCATION;
    }
}
