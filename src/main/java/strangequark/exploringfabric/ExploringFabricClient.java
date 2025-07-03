package strangequark.exploringfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.entity.client.*;
import strangequark.exploringfabric.tooltip.ModTooltips;

public class ExploringFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModTooltips.registerModTooltips();
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_TRAPDOOR);
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.CAULIFLOWERS, ModBlocks.HONEY_BERRY_BUSH);
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.DRIFTWOOD_SAPLING);

        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);
    }
}
