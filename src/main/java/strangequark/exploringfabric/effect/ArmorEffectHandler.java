package strangequark.exploringfabric.effect;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import strangequark.exploringfabric.util.ModTags;

import java.util.List;
import java.util.Map;

public class ArmorEffectHandler implements ServerTickEvents.EndTick {

    private static final int EFFECT_REFRESH_INTERVAL = 80;

    private static final Map<TagKey<Item>, List<MobEffectInstance>> EFFECTS_MAP =
            new ImmutableMap.Builder<TagKey<Item>, List<MobEffectInstance>>()
                    .put(ModTags.Items.PINK_GARNET_ARMOR, List.of(
                            new MobEffectInstance(MobEffects.HASTE, 400, 0, false, false),
                            new MobEffectInstance(MobEffects.SPEED, 400, 0, false, false),
                            new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 1, false, false)
                    ))
                    .put(ModTags.Items.NETHERITE_ARMOR, List.of(
                            new MobEffectInstance(MobEffects.RESISTANCE, 200, 1, false, false),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false)
                    ))
                    .build();

    @Override
    public void onEndTick(MinecraftServer server) {
        if (server.getTickCount() % EFFECT_REFRESH_INTERVAL != 0) {
            return;
        }
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            if (hasFullSuitOfArmorOn(player)) {
                applyArmorEffects(player);
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(ServerPlayer player) {
        return !player.getItemBySlot(EquipmentSlot.HEAD).isEmpty() &&
                !player.getItemBySlot(EquipmentSlot.CHEST).isEmpty() &&
                !player.getItemBySlot(EquipmentSlot.LEGS).isEmpty() &&
                !player.getItemBySlot(EquipmentSlot.FEET).isEmpty();
    }

    private void applyArmorEffects(ServerPlayer player) {
        for (Map.Entry<TagKey<Item>, List<MobEffectInstance>> entry : EFFECTS_MAP.entrySet()) {
            TagKey<Item> tag = entry.getKey();
            List<MobEffectInstance> effects = entry.getValue();

            if (!isWearingFullSetFromTag(player, tag)) {
                continue;
            }

            for (MobEffectInstance effect : effects) {
                player.addEffect(new MobEffectInstance(effect));
            }
        }
    }

    private boolean isWearingFullSetFromTag(ServerPlayer player, TagKey<Item> tag) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(tag) &&
                player.getItemBySlot(EquipmentSlot.CHEST).is(tag) &&
                player.getItemBySlot(EquipmentSlot.LEGS).is(tag) &&
                player.getItemBySlot(EquipmentSlot.FEET).is(tag);
    }
}