package strangequark.exploringfabric.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class MagnetItem extends Item {
    private final int RADIUS = 10;
    private final float STRENGTH = 1.5F;

    public MagnetItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;

        if (world.isClient()) {
            return ActionResult.PASS;
        }

        List<Entity> entities = world.getOtherEntities(user, user.getBoundingBox().expand(RADIUS), e -> e instanceof net.minecraft.entity.ItemEntity);

        for (Entity entity : entities) {
            double dx = user.getX() - entity.getX();
            double dy = user.getY() + 1.0 - entity.getY();
            double dz = user.getZ() - entity.getZ();
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            if (distance > 0) {
                entity.setVelocity(
                        entity.getVelocity().x + (dx / distance) * STRENGTH,
                        entity.getVelocity().y + (dy / distance) * STRENGTH,
                        entity.getVelocity().z + (dz / distance) * STRENGTH
                );
            }
        }
        itemStack.damage(entities.size(), (ServerWorld) world, (ServerPlayerEntity) user, item -> {
            user.sendEquipmentBreakStatus(item, slot);
        });
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        return super.canBeEnchantedWith(stack, enchantment, context);
    }
}
