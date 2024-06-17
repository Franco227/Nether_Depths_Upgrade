package com.scouter.netherdepthsupgrade.blocks;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;

import javax.annotation.Nullable;

public class TallCrimsonSeagrassBlock extends DoublePlantBlock implements LiquidBlockContainer {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final EnumProperty<DoubleBlockHalf> HALF = DoublePlantBlock.HALF;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public TallCrimsonSeagrassBlock(Properties p_154745_) {
        super(p_154745_);
    }

    public VoxelShape getShape(BlockState p_154763_, BlockGetter p_154764_, BlockPos p_154765_, CollisionContext p_154766_) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState p_154774_, BlockGetter p_154775_, BlockPos p_154776_) {
        return p_154774_.isFaceSturdy(p_154775_, p_154776_, Direction.UP) && !p_154774_.is(Blocks.MAGMA_BLOCK);
    }


    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(NDUBlocks.CRIMSON_SEAGRASS.get());
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_154747_) {
        BlockState blockstate = super.getStateForPlacement(p_154747_);
        if (blockstate != null) {
            FluidState fluidstate = p_154747_.getLevel().getFluidState(p_154747_.getClickedPos().above());
            if (fluidstate.is(FluidTags.LAVA) && fluidstate.getAmount() == 8) {
                return blockstate;
            }
        }

        return null;
    }

    public boolean canSurvive(BlockState p_154768_, LevelReader p_154769_, BlockPos p_154770_) {
        if (p_154768_.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState blockstate = p_154769_.getBlockState(p_154770_.below());
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        } else {
            FluidState fluidstate = p_154769_.getFluidState(p_154770_);
            return super.canSurvive(p_154768_, p_154769_, p_154770_) && fluidstate.is(FluidTags.LAVA) && fluidstate.getAmount() == 8;
        }
    }

    public FluidState getFluidState(BlockState p_154772_) {
        return Fluids.LAVA.getSource(false);
    }


    @Override
    public boolean canPlaceLiquid(@org.jetbrains.annotations.Nullable Player pPlayer, BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return false;
    }

    public boolean placeLiquid(LevelAccessor p_154758_, BlockPos p_154759_, BlockState p_154760_, FluidState p_154761_) {
        return false;
    }
}
