package me.devupdates.millenaireReborn.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

/**
 * Lightweight modern port of the old BlockRosette.
 * This provides the boolean block state properties that the legacy
 * rosette blockstate JSONs expect (north/south/east/west and the
 * various "ros_*" flags). The implementation intentionally keeps
 * the block behaviour minimal — it only exposes the properties so
 * the multipart blockstate files can instantiate the correct models.
 */
public class BlockRosette extends Block {

    public static final BooleanProperty NORTH = BooleanProperty.of("north");
    public static final BooleanProperty EAST = BooleanProperty.of("east");
    public static final BooleanProperty SOUTH = BooleanProperty.of("south");
    public static final BooleanProperty WEST = BooleanProperty.of("west");

    public static final BooleanProperty ROS_N = BooleanProperty.of("ros_n");
    public static final BooleanProperty ROS_S = BooleanProperty.of("ros_s");
    public static final BooleanProperty ROS_E = BooleanProperty.of("ros_e");
    public static final BooleanProperty ROS_W = BooleanProperty.of("ros_w");
    public static final BooleanProperty ROS_U = BooleanProperty.of("ros_u");
    public static final BooleanProperty ROS_D = BooleanProperty.of("ros_d");

    public BlockRosette(AbstractBlock.Settings settings) {
        super(settings);
        // initialize default state with all boolean properties set to false
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(ROS_N, false)
                .with(ROS_S, false)
                .with(ROS_E, false)
                .with(ROS_W, false)
                .with(ROS_U, false)
                .with(ROS_D, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, ROS_N, ROS_S, ROS_E, ROS_W, ROS_U, ROS_D);
    }
}