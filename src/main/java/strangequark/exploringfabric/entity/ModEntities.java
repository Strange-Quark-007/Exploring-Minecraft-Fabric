package strangequark.exploringfabric.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.entity.custom.ChairEntity;
import strangequark.exploringfabric.entity.custom.MantisEntity;
import strangequark.exploringfabric.entity.custom.TomahawkProjectileEntity;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModEntities {
    private static final ResourceKey<EntityType<?>> MANTIS_KEY = ResourceKey.create(Registries.ENTITY_TYPE, createIdentifier("mantis"));
    private static final ResourceKey<EntityType<?>> TOMAHAWK_KEY = ResourceKey.create(Registries.ENTITY_TYPE, createIdentifier("tomahawk"));
    private static final ResourceKey<EntityType<?>> CHAIR_KEY = ResourceKey.create(Registries.ENTITY_TYPE, createIdentifier("chair_entity"));

    public static final EntityType<MantisEntity> MANTIS = Registry.register(BuiltInRegistries.ENTITY_TYPE, createIdentifier("mantis"),
            EntityType.Builder.of(MantisEntity::new, MobCategory.CREATURE).sized(1f, 2.5f).build(MANTIS_KEY));

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(BuiltInRegistries.ENTITY_TYPE, createIdentifier("tomahawk"),
            EntityType.Builder.<TomahawkProjectileEntity>of(TomahawkProjectileEntity::new, MobCategory.MISC).sized(0.5f, 1.15f).build(TOMAHAWK_KEY));

    public static final EntityType<ChairEntity> CHAIR = Registry.register(BuiltInRegistries.ENTITY_TYPE, createIdentifier("chair_entity"),
            EntityType.Builder.of(ChairEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build(CHAIR_KEY));

    public static void registerModEntities() {
        ExploringFabric.LOGGER.info("Registering Mod Entities for " + ExploringFabric.MOD_ID);
    }
}