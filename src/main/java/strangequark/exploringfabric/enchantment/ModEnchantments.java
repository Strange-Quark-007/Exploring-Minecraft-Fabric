package strangequark.exploringfabric.enchantment;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.enchantment.custom.LightningStrikerEnchantmentEffect;
import strangequark.exploringfabric.util.ModTags;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = of("lightning_striker");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, LIGHTNING_STRIKER,
                Enchantment.enchantment(Enchantment.definition(
                                items.getOrThrow(ModTags.Items.LIGHTNING_STRIKER_ENCHANTABLE),
                                items.getOrThrow(ItemTags.SWORDS),
                                5,
                                5,
                                Enchantment.dynamicCost(10, 10),
                                Enchantment.dynamicCost(50, 10),
                                5,
                                EquipmentSlotGroup.MAINHAND))
                        .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                        .withEffect(
                                EnchantmentEffectComponents.POST_ATTACK,
                                EnchantmentTarget.ATTACKER,
                                EnchantmentTarget.VICTIM,
                                new LightningStrikerEnchantmentEffect())
        );
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.identifier()));
    }

    private static ResourceKey<Enchantment> of(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, createIdentifier(id));
    }

    public static void registerEnchantments() {
        ExploringFabric.LOGGER.info("Registering Mod Enchantments for " + ExploringFabric.MOD_ID);
    }
}