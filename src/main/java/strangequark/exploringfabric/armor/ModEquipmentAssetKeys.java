package strangequark.exploringfabric.armor;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEquipmentAssetKeys {
    public static final RegistryKey<EquipmentAsset> PINK_GARNET = register("pink_garnet");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, createIdentifier(name));
    }
}
