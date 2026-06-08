package strangequark.exploringfabric.item.custom;



import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends Item {
    private static final int RANGE = 1;

    public HammerItem(Properties properties) {
        super(properties);
    }


    public static List<BlockPos> getBlocksToBeDestroyed(Level world, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.pick(20, 0, false);

        if (world.isClientSide()) {
            return new ArrayList<>();
        }

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            Block block = world.getBlockState(initalBlockPos).getBlock();
            float hardness = block.getExplosionResistance();

            /*
             * Prevent instant-mineable blocks (zero hardness) from breaking adjacent solid blocks.
             * Disallow mining of higher-hardness blocks (e.g. obsidian) when mining adjacent lower-hardness blocks (e.g. stone).
             */

            if (hardness <= 0 && block != Blocks.AIR) {
                positions.add(initalBlockPos);
                return positions;
            }

            if (blockHit.getDirection() == Direction.DOWN || blockHit.getDirection() == Direction.UP) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y);
                        if (world.getBlockState(blockPos).getBlock().getExplosionResistance() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }

            if (blockHit.getDirection() == Direction.NORTH || blockHit.getDirection() == Direction.SOUTH) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ());
                        if (world.getBlockState(blockPos).getBlock().getExplosionResistance() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }

            if (blockHit.getDirection() == Direction.EAST || blockHit.getDirection() == Direction.WEST) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x);
                        if (world.getBlockState(blockPos).getBlock().getExplosionResistance() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }
        }

        return positions;
    }
}
