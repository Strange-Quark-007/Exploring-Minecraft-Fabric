package strangequark.exploringfabric.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.ModTags;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, ModSounds.MAGIC_BLOCK_HIT, SoundCategory.BLOCKS);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (!isValidItem(itemEntity.getStack())) {
                return;
            }
            itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));

            if (!world.isClient()) {
                world.playSound(entity, pos, ModSounds.MAGIC_BLOCK_STEP, SoundCategory.BLOCKS);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }


}
