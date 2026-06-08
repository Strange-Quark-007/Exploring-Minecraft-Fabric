package strangequark.exploringfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.entity.client.*;
import strangequark.exploringfabric.tooltip.ModTooltips;

public class ExploringFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModTooltips.registerModTooltips();
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, ModBlocks.PINK_GARNET_DOOR, ModBlocks.PINK_GARNET_TRAPDOOR);
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, ModBlocks.CAULIFLOWERS, ModBlocks.HONEY_BERRY_BUSH);
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, ModBlocks.DRIFTWOOD_SAPLING);

        EntityRenderers.register(ModEntities.MANTIS, MantisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::createBodyLayer);

        EntityRenderers.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::createBodyLayer);

        EntityRenderers.register(ModEntities.CHAIR, ChairRenderer::new);
    }
}
