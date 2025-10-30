package strangequark.exploringfabric.entity.client;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import strangequark.exploringfabric.entity.custom.TomahawkProjectileEntity;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class TomahawkProjectileRenderer extends ProjectileEntityRenderer<TomahawkProjectileEntity, ProjectileEntityRenderState> {
    protected TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new TomahawkProjectileModel(ctx.getPart(TomahawkProjectileModel.TOMAHAWK));
    }

    @Override
    protected Identifier getTexture(ProjectileEntityRenderState state) {
        return createIdentifier("textures/entity/tomahawk/tomahawk.png");
    }

    @Override
    public void render(ProjectileEntityRenderState projectileEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        /* TODO: Fix — vertexConsumer context not available in new rendering API (RCA: render() signature changed in 1.21.9+)
        matrices.push();

        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                this.model.getLayer(createIdentifier("textures/entity/tomahawk/tomahawk.png")),
                false,
                false);

        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();*/

        super.render(projectileEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public ProjectileEntityRenderState createRenderState() {
        return new ProjectileEntityRenderState();
    }
}