package strangequark.exploringfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.component.ModDataComponentTypes;
import strangequark.exploringfabric.effect.ArmorEffectHandler;
import strangequark.exploringfabric.effect.ModEffects;
import strangequark.exploringfabric.enchantment.ModEnchantmentEffects;
import strangequark.exploringfabric.enchantment.ModEnchantments;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.entity.custom.MantisEntity;
import strangequark.exploringfabric.item.ModItemGroups;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.potion.ModPotions;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.HammerUsageEvent;
import strangequark.exploringfabric.world.gen.ModWorldGeneration;

public class ExploringFabric implements ModInitializer {
    public static final String MOD_ID = "exploringfabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModDataComponentTypes.registerDataComponentTypes();
        ModSounds.registerSounds();
        ModEffects.registerEffects();
        ModPotions.registerPotions();
        ModEnchantments.registerEnchantments();
        ModEnchantmentEffects.registerEnchantmentEffects();
        ModWorldGeneration.generateModWorldGen();
        ModEntities.registerModEntities();

        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.2f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES, 0.1f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.DRIFTWOOD_SAPLING.asItem(), 0.1f);

        FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(ModItems.STARLIGHT_ASHES, 4 * 10 * 20));

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
        ServerTickEvents.END_SERVER_TICK.register(new ArmorEffectHandler());

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION)
        );

        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);

        FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
    }
}