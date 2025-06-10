package strangequark.exploringfabric.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import strangequark.exploringfabric.entity.custom.TomahawkProjectileEntity;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity, EntityRenderState> {
    protected TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new TomahawkProjectileModel(ctx.getPart(TomahawkProjectileModel.TOMAHAWK));
    }


    @Override
    public void render(EntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                this.model.getLayer(createIdentifier("textures/entity/tomahawk/tomahawk.png")),
                false,
                false);

        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(state, matrices, vertexConsumers, light);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}