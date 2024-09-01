package com.scouter.netherdepthsupgrade.entity.ai;

import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LavaSwimNodeEvaluator extends NodeEvaluator {
    private final boolean allowBreaching;
    private final Long2ObjectMap<PathType> pathTypesByPosCache = new Long2ObjectOpenHashMap<>();

    public LavaSwimNodeEvaluator(boolean p_77457_) {
        this.allowBreaching = p_77457_;
    }

    public void prepare(PathNavigationRegion p_192959_, Mob p_192960_) {
        super.prepare(p_192959_, p_192960_);
        this.pathTypesByPosCache.clear();
    }

    /**
     * This method is called when all nodes have been processed and PathEntity is created.
     * {@link net.minecraft.world.pathfinder.WalkNodeProcessor WalkNodeProcessor} uses this to change its field {@link
     * net.minecraft.world.pathfinder.WalkNodeProcessor#avoidsWater avoidsWater}
     */
    public void done() {
        super.done();
        this.pathTypesByPosCache.clear();
    }

    public Node getStart() {
        return super.getNode(Mth.floor(this.mob.getBoundingBox().minX), Mth.floor(this.mob.getBoundingBox().minY + 0.5D), Mth.floor(this.mob.getBoundingBox().minZ));
    }

    @Override
    public Target getTarget(double pX, double pY, double pZ) {
        return this.getTargetNodeAt(pX, pY, pZ);
    }

    protected Target getTargetNodeAt(double pX, double pY, double pZ) {
        return new Target(this.getNode(Mth.floor(pX), Mth.floor(pY), Mth.floor(pZ)));
    }

    public int getNeighbors(Node[] p_77483_, Node p_77484_) {
        int i = 0;
        Map<Direction, Node> map = Maps.newEnumMap(Direction.class);

        for(Direction direction : Direction.values()) {
            Node node = this.findAcceptedNode(p_77484_.x + direction.getStepX(), p_77484_.y + direction.getStepY(), p_77484_.z + direction.getStepZ());
            map.put(direction, node);
            if (this.isNodeValid(node)) {
                p_77483_[i++] = node;
            }
        }

        for(Direction direction1 : Direction.Plane.HORIZONTAL) {
            Direction direction2 = direction1.getClockWise();
            if (hasMalus(map.get(direction1)) && hasMalus(map.get(direction2))) {

                Node node1 = this.findAcceptedNode(p_77484_.x + direction1.getStepX() + direction2.getStepX(), p_77484_.y, p_77484_.z + direction1.getStepZ() + direction2.getStepZ());
                if (this.isDiagonalNodeValid(node1, map.get(direction1), map.get(direction2))) {
                    p_77483_[i++] = node1;
                }
            }
        }

        return i;
    }


    private static boolean hasMalus(@Nullable Node pNode) {
        return pNode != null && pNode.costMalus >= 0.0F;
    }

    protected boolean isNodeValid(@Nullable Node pNode) {
        return pNode != null && !pNode.closed;
    }

    protected boolean isDiagonalNodeValid(@Nullable Node p_192964_, @Nullable Node p_192965_, @Nullable Node p_192966_) {
        return this.isNodeValid(p_192964_) && p_192965_ != null && p_192965_.costMalus >= 0.0F && p_192966_ != null && p_192966_.costMalus >= 0.0F;
    }

    /**
     * Returns a mapped point or creates and adds one
     */
    @Nullable
    protected Node findAcceptedNode(int pX, int pY, int pZ) {
        Node node = null;
        PathType PathType = this.getCachedBlockType(pX, pY, pZ);
        if (this.allowBreaching && PathType == PathType.BREACH || PathType == PathType.WATER ||  PathType == PathType.LAVA) {
            float f = this.mob.getPathfindingMalus(PathType);
            if (f >= 0.0F) {
                node = super.getNode(pX, pY, pZ);
                node.type = PathType;
                node.costMalus = Math.max(node.costMalus, f);
                if (this.mob.level().getFluidState(new BlockPos(pX, pY, pZ)).isEmpty()) {
                    node.costMalus += 8.0F;
                }
            }
        }

        return node;
    }

    protected PathType getCachedBlockType(int pX, int pY, int pZ) {
        return this.pathTypesByPosCache
                .computeIfAbsent(
                        BlockPos.asLong(pX, pY, pZ), p_330157_ -> this.getPathType(this.currentContext, pX, pY, pZ)
                );
    }



    @Override
    public PathType getPathType(PathfindingContext pContext, int pX, int pY, int pZ) {
        return this.getPathTypeOfMob(pContext, pX, pY, pZ, this.mob);
    }




    /**
     * Returns the significant (e.g LAVA if the entity were half in lava) node type at the location taking the
     * surroundings and the entity size in account
     */



    public PathType getPathTypeOfMob(PathfindingContext pBlockaccess, int pX, int pY, int pZ, Mob pEntityliving) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int i = pX; i < pX + this.entityWidth; ++i) {
            for(int j = pY; j < pY + this.entityHeight; ++j) {
                for(int k = pZ; k < pZ + this.entityDepth; ++k) {
                    BlockState blockstate = pBlockaccess.getBlockState(blockpos$mutableblockpos.set(i, j, k));
                    FluidState fluidstate = blockstate.getFluidState();
                    if (fluidstate.isEmpty() && blockstate.isPathfindable(PathComputationType.WATER) && blockstate.isAir()) {
                        return PathType.BREACH;
                    }
                    else {
                        return fluidstate.is(FluidTags.LAVA) ? PathType.WATER : PathType.BLOCKED;
                    }
                }
            }
        }

        BlockState blockstate1 = pBlockaccess.getBlockState(blockpos$mutableblockpos);
        FluidState fluidState1 = blockstate1.getFluidState();
        return fluidState1.is(FluidTags.LAVA) ? PathType.WATER : PathType.BLOCKED;
    }
}
