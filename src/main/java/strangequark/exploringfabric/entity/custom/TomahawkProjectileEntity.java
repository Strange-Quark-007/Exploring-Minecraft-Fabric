package strangequark.exploringfabric.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.util.ModTags;

public class TomahawkProjectileEntity extends PersistentProjectileEntity {

    public TomahawkProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public TomahawkProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.TOMAHAWK, player, world, new ItemStack(ModItems.TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.TOMAHAWK);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.BLOCK_CHAIN_HIT;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (!this.getWorld().isClient()) {
            entity.damage(((ServerWorld) this.getWorld()), this.getDamageSources().thrown(this, this.getOwner()), 25);

            this.getWorld().sendEntityStatus(this, (byte) 3);
            this.discard();
        }
    }

    /*
     * Makes the Tomahawk extremely powerful.
     * Instantly breaks any block in its path tagged as TOMAHAWK_BREAKABLE (axe mineable + leaves) on hit.
     */
    @Override
    protected void onBlockHit(BlockHitResult result) {
        World world = this.getWorld();
        BlockPos pos = result.getBlockPos();
        BlockState blockstate = world.getBlockState(pos);
        if (!this.getWorld().isClient() && blockstate.isIn(ModTags.Blocks.TOMAHAWK_BREAKABLE)) {
            world.breakBlock(pos, true, this.getOwner());
        } else {
            super.onBlockHit(result);
        }
    }
}
