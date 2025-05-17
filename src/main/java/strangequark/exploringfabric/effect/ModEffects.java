package strangequark.exploringfabric.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import strangequark.exploringfabric.ExploringFabric;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect(
            "slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, createIdentifier("effect.slimey"), -0.25f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, createIdentifier(name), statusEffect);
    }

    public static void registerEffects() {
        ExploringFabric.LOGGER.info("Registering Mod Effects for " + ExploringFabric.MOD_ID);
    }
}
