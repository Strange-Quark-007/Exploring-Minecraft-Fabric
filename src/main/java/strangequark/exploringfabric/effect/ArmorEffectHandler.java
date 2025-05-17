package strangequark.exploringfabric.effect;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import strangequark.exploringfabric.util.ModTags;

import java.util.List;
import java.util.Map;

public class ArmorEffectHandler implements ServerTickEvents.EndTick {

    private static final int EFFECT_REFRESH_INTERVAL = 80;

    private static final Map<TagKey<Item>, List<StatusEffectInstance>> EFFECTS_MAP =
            new ImmutableMap.Builder<TagKey<Item>, List<StatusEffectInstance>>()
                    .put(ModTags.Items.PINK_GARNET_ARMOR, List.of(
                            new StatusEffectInstance(StatusEffects.HASTE, 400, 0, false, false),
                            new StatusEffectInstance(StatusEffects.SPEED, 400, 0, false, false),
                            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false)
                    ))
                    .put(ModTags.Items.NETHERITE_ARMOR, List.of(
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, false),
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false)
                    ))
                    .build();

    @Override
    public void onEndTick(MinecraftServer server) {
        if (server.getTicks() % EFFECT_REFRESH_INTERVAL != 0) {
            return;
        }
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (hasFullSuitOfArmorOn(player)) {
                applyArmorEffects(player);
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(ServerPlayerEntity player) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && player.getEquippedStack(slot).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void applyArmorEffects(ServerPlayerEntity player) {
        for (Map.Entry<TagKey<Item>, List<StatusEffectInstance>> entry : EFFECTS_MAP.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();

            if (!isWearingFullSetFromTag(player, tag)) {
                continue;
            }

            for (StatusEffectInstance effect : effects) {
                player.addStatusEffect(new StatusEffectInstance(effect));
            }
        }
    }

    private boolean isWearingFullSetFromTag(ServerPlayerEntity player, TagKey<Item> tag) {
        return player.getEquippedStack(EquipmentSlot.HEAD).isIn(tag) &&
                player.getEquippedStack(EquipmentSlot.CHEST).isIn(tag) &&
                player.getEquippedStack(EquipmentSlot.LEGS).isIn(tag) &&
                player.getEquippedStack(EquipmentSlot.FEET).isIn(tag);
    }
}
