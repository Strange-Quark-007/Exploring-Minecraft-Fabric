package strangequark.exploringfabric.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.util.ModTags;

public class TomahawkProjectileEntity extends AbstractArrow {

    public TomahawkProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
        super(entityType, world);
    }

    public TomahawkProjectileEntity(Level world, Player player) {
        super(ModEntities.TOMAHAWK, player, world, new ItemStack(ModItems.TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.TOMAHAWK);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.CHAIN_HIT;
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (!this.level().isClientSide()) {
            entity.hurtServer((ServerLevel) this.level(), this.damageSources().thrown(this, this.getOwner()), 25);
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    /*
     * Makes the Tomahawk extremely powerful.
     * Instantly breaks any block in its path tagged as TOMAHAWK_BREAKABLE (axe mineable + leaves) on hit.
     * Discard on hit to prevent repeated throws for balance.
     */
    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        Level level = this.level();
        BlockPos pos = blockHitResult.getBlockPos();
        BlockState blockstate = level.getBlockState(pos);
        if (!this.level().isClientSide() && blockstate.is(ModTags.Blocks.TOMAHAWK_BREAKABLE)) {
            level.destroyBlock(pos, true, this.getOwner());
        } else {
            super.onHitBlock(blockHitResult);
            this.discard();
        }
    }
}
