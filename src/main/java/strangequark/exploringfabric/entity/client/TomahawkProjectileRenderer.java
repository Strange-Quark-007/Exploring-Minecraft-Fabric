package strangequark.exploringfabric.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import strangequark.exploringfabric.entity.custom.TomahawkProjectileEntity;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity, TomahawkProjectileRenderState> {
    protected final TomahawkProjectileModel model;
    private static final Identifier TEXTURE = createIdentifier("textures/entity/tomahawk/tomahawk.png");

    public TomahawkProjectileRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        // 1.21+ Mappings: bakeLayer replaces getPart
        this.model = new TomahawkProjectileModel(ctx.bakeLayer(TomahawkProjectileModel.TOMAHAWK));
    }

    @Override
    public void submit(TomahawkProjectileRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraState) {
        super.submit(state, poseStack, collector, cameraState);

        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(state.yaw - 180.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(state.pitch));


        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

        collector.submitModelPart(
                this.model.getTomahawk(),
                poseStack,
                RenderTypes.entityCutout(TEXTURE),
                state.lightCoords,
                OverlayTexture.NO_OVERLAY,
                null,
                false,
                false,
                -1,
                null,
                0
        );

        poseStack.popPose();
    }

    @Override
    public TomahawkProjectileRenderState createRenderState() {
        return new TomahawkProjectileRenderState();
    }

    @Override
    public void extractRenderState(TomahawkProjectileEntity entity, TomahawkProjectileRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yaw = Mth.lerp(partialTick, entity.yRotO, entity.getYRot());
        state.pitch = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());
        state.inGround = entity.onGround();
    }
}