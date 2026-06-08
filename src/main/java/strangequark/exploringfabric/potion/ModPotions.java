package strangequark.exploringfabric.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.effect.ModEffects;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModPotions {
    public static final Holder<Potion> SLIMEY_POTION = registerPotion("slimey",
            new Potion("slimey", new MobEffectInstance(ModEffects.SLIMEY, 600, 0)));

    private static Holder<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, createIdentifier(name), potion);
    }

    public static void registerPotions() {
        ExploringFabric.LOGGER.info("Registering Mod Potions for " + ExploringFabric.MOD_ID);
    }
}