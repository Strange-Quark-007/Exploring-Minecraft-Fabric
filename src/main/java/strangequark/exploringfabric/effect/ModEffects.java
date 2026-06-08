package strangequark.exploringfabric.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import strangequark.exploringfabric.ExploringFabric;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEffects {
    public static final Holder<MobEffect> SLIMEY = registerStatusEffect(
            "slimey",
            new SlimeyEffect(MobEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, createIdentifier("effect.slimey"), -0.25f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    private static Holder<MobEffect> registerStatusEffect(String name, MobEffect statusEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, createIdentifier(name), statusEffect);
    }

    public static void registerEffects() {
        ExploringFabric.LOGGER.info("Registering Mod Effects for " + ExploringFabric.MOD_ID);
    }
}