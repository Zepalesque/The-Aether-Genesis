package com.aetherteam.aether_genesis.block.natural;

import com.aetherteam.aether.block.AetherBlockStateProperties;
import com.aetherteam.aether.block.natural.AercloudBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PurpleAercloudBlock extends AercloudBlock {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    protected static final VoxelShape COLLISION_SHAPE = Shapes.empty();

    public PurpleAercloudBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.SOUTH).setValue(AetherBlockStateProperties.DOUBLE_DROPS, false));
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isShiftKeyDown()) {
            entity.resetFallDistance();
            switch (state.getValue(FACING)) {
                case EAST -> entity.setDeltaMovement(2.0, entity.getDeltaMovement().y(), entity.getDeltaMovement().z());
                case WEST -> entity.setDeltaMovement(-2.0, entity.getDeltaMovement().y(), entity.getDeltaMovement().z());
                case NORTH -> entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), -2.0);
                case SOUTH -> entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), 2.0);
            }
        } else {
            super.entityInside(state, level, pos, entity);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double xOffset = (double) pos.getX() + 0.5F;
        double yOffset = (double) pos.getY() + 0.5F;
        double zOffset = (double) pos.getZ() + 0.5F;
        double xSpeed = 0.0;
        double ySpeed = 0.0;
        double zSpeed = 0.0;

        switch (state.getValue(FACING)) {
            case EAST -> {
                xOffset += 0.5F;
                xSpeed = 1.0;
            }
            case WEST -> {
                xOffset -= 0.5F;
                xSpeed = -1.0;
            }
            case NORTH -> {
                zOffset -= 0.5F;
                zSpeed = -1.0;
            }
            case SOUTH -> {
                zOffset += 0.5F;
                zSpeed = 1.0;
            }
        }
        level.addParticle(ParticleTypes.POOF, xOffset, yOffset, zOffset, xSpeed, ySpeed, zSpeed);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AetherBlockStateProperties.DOUBLE_DROPS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getDefaultCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }
}
