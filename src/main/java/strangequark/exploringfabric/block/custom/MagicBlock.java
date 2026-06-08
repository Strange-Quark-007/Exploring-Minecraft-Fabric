package strangequark.exploringfabric.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.ModTags;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        level.playSound(player, blockPos, ModSounds.MAGIC_BLOCK_HIT, SoundSource.BLOCKS);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (!isValidItem(itemEntity.getItem())) {
                return;
            }
            itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));

            if (!level.isClientSide()) {
                level.playSound(entity, blockPos, ModSounds.MAGIC_BLOCK_STEP, SoundSource.BLOCKS);
            }
        }
        super.stepOn(level, blockPos, blockState, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }


}
