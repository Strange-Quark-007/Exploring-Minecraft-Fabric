package strangequark.exploringfabric.trim;

import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> QUARK = of("quark");

    public static void bootstrap(Registerable<ArmorTrimPattern> registerable) {
        register(registerable, QUARK);
    }

    public static void register(Registerable<ArmorTrimPattern> registry, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern armorTrimPattern = new ArmorTrimPattern(key.getValue(), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        registry.register(key, armorTrimPattern);
    }

    private static RegistryKey<ArmorTrimPattern> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, createIdentifier(id));
    }
}
