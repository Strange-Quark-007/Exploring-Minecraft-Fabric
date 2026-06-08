package strangequark.exploringfabric.armor;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEquipmentAssetKeys {
    public static final ResourceKey<EquipmentAsset> PINK_GARNET = register("pink_garnet");

    static ResourceKey<EquipmentAsset> register(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, createIdentifier(name));
    }
}