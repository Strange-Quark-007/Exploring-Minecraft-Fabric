package strangequark.exploringfabric.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import java.util.List;

public class MagnetItem extends Item {
    private final int RADIUS = 10;
    private final float STRENGTH = 1.5F;

    public MagnetItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        EquipmentSlot slot = interactionHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;

        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        List<Entity> entities = level.getEntities(player, player.getBoundingBox().inflate(RADIUS), e -> e instanceof ItemEntity);

        for (Entity entity : entities) {
            double dx = player.getX() - entity.getX();
            double dy = player.getY() + 1.0 - entity.getY();
            double dz = player.getZ() - entity.getZ();
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            if (distance > 0) {
                entity.setDeltaMovement(
                        entity.getDeltaMovement().x + (dx / distance) * STRENGTH,
                        entity.getDeltaMovement().y + (dy / distance) * STRENGTH,
                        entity.getDeltaMovement().z + (dz / distance) * STRENGTH
                );
            }
        }
        itemStack.hurtAndBreak(entities.size(), (ServerLevel) level, (ServerPlayer) player, item -> {
            player.onEquippedItemBroken(item, slot);
        });
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, Holder<Enchantment> enchantment, EnchantingContext context) {
        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
