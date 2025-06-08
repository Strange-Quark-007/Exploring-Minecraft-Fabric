package strangequark.exploringfabric.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.entity.custom.MantisEntity;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> MANTIS_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, createIdentifier("mantis"));

    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE, createIdentifier("mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build(MANTIS_KEY));

    public static void registerModEntities() {
        ExploringFabric.LOGGER.info("Registering Mod Entities for " + ExploringFabric.MOD_ID);
    }
}
