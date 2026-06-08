package strangequark.exploringfabric.armor;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import strangequark.exploringfabric.util.ModTags;

import java.util.Map;

public class ModArmorMaterials {
    public static final ArmorMaterial PINK_GARNET = new ArmorMaterial(
            25,
            createDefenseMap(2, 5, 7, 2, 9),
            10,
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f,
            0,
            ModTags.Items.PINK_GARNET_REPAIR,
            ModEquipmentAssetKeys.PINK_GARNET
    );

    private static Map<ArmorType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        ArmorType.BOOTS,
                        bootsDefense,
                        ArmorType.LEGGINGS,
                        leggingsDefense,
                        ArmorType.CHESTPLATE,
                        chestplateDefense,
                        ArmorType.HELMET,
                        helmetDefense,
                        ArmorType.BODY,
                        bodyDefense
                )
        );
    }
}
