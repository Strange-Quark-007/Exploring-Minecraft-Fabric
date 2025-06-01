package strangequark.exploringfabric.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends Item {
    private static final int RANGE = 1;

    public HammerItem(Settings settings) {
        super(settings);
    }


    public static List<BlockPos> getBlocksToBeDestroyed(World world, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            Block block = world.getBlockState(initalBlockPos).getBlock();
            float hardness = block.getHardness();

            /*
             * Prevent instant-mineable blocks (zero hardness) from breaking adjacent solid blocks.
             * Disallow mining of higher-hardness blocks (e.g. obsidian) when mining adjacent lower-hardness blocks (e.g. stone).
             */

            if (hardness <= 0 && block != Blocks.AIR) {
                positions.add(initalBlockPos);
                return positions;
            }

            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y);
                        if (world.getBlockState(blockPos).getBlock().getHardness() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }

            if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ());
                        if (world.getBlockState(blockPos).getBlock().getHardness() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }

            if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for (int x = -RANGE; x <= RANGE; x++) {
                    for (int y = -RANGE; y <= RANGE; y++) {
                        var blockPos = new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x);
                        if (world.getBlockState(blockPos).getBlock().getHardness() <= hardness) {
                            positions.add(blockPos);
                        }
                    }
                }
            }
        }

        return positions;
    }
}
