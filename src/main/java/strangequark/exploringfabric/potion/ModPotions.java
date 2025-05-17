package strangequark.exploringfabric.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.effect.ModEffects;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModPotions {
    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey",
            new Potion("slimey", new StatusEffectInstance(ModEffects.SLIMEY, 600, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, createIdentifier(name), potion);
    }

    public static void registerPotions() {
        ExploringFabric.LOGGER.info("Registering Mod Potions for " + ExploringFabric.MOD_ID);
    }
}
