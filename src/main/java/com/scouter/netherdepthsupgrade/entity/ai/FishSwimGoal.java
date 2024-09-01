package com.scouter.netherdepthsupgrade.entity.ai;

import com.mojang.logging.LogUtils;
import com.scouter.netherdepthsupgrade.entity.AbstractLavaFish;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class FishSwimGoal extends RandomStrollGoal {
    private static final Logger LOGGER = LogUtils.getLogger();

    public FishSwimGoal(AbstractLavaFish p_27505_) {
        super(p_27505_, 1.0D, 40);
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    @Override
    public boolean canUse() {
        if (!this.mob.isInLava() && !this.mob.isInWater() || this.mob.isPassenger() || mob.getTarget() != null || !this.mob.isInWater() && !this.mob.isInLava()) {
            return false;
        } else {
            if (!this.forceTrigger) {
                if (this.mob.getRandom().nextInt(this.interval) >= 100) {

                    return false;
                }
            }

            Vec3 vector3d = this.getPosition();
            if (vector3d == null) {
                return false;
            } else {
                this.wantedX = vector3d.x;
                this.wantedY = vector3d.y;
                this.wantedZ = vector3d.z;

                this.forceTrigger = false;
                return true;
            }
        }
    }

    @Nullable
    @Override
    protected Vec3 getPosition() {
        Vec3 vector3d = DefaultRandomPos.getPos(this.mob, 10, 7);
        for (int i = 0; vector3d != null && !this.mob.level().getFluidState(BlockPos.containing(vector3d)).is(FluidTags.LAVA) && i++ < 10; vector3d = DefaultRandomPos.getPos(this.mob, 10, 7)) {
        }
        return vector3d;
    }
}