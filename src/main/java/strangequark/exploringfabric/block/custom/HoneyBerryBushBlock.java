package strangequark.exploringfabric.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import strangequark.exploringfabric.item.ModItems;

public class HoneyBerryBushBlock extends SweetBerryBushBlock {
    public HoneyBerryBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return new ItemStack(ModItems.HONEY_BERRIES);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        boolean bl = i == 3;

        if (i <= 1) {
            return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
        }

        int j = 1 + level.random.nextInt(2);
        popResource(level, blockPos, new ItemStack(ModItems.HONEY_BERRIES, j + (bl ? 1 : 0)));
        level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

        BlockState newBlockState = blockState.setValue(AGE, 1);
        level.setBlock(blockPos, newBlockState, Block.UPDATE_CLIENTS);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newBlockState));

        return InteractionResult.SUCCESS;
    }
}