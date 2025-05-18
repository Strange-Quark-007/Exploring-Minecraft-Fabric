package strangequark.exploringfabric.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.enchantment.custom.LightningStrikerEnchantmentEffect;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER = registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, createIdentifier(name), codec);
    }

    public static void registerEnchantmentEffects() {
        ExploringFabric.LOGGER.info("Registering Mod Enchantment Effects for " + ExploringFabric.MOD_ID);
    }
}
