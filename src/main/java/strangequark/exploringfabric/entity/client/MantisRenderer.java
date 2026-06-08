package strangequark.exploringfabric.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import strangequark.exploringfabric.entity.custom.MantisEntity;
import strangequark.exploringfabric.entity.custom.MantisVariant;

import java.util.Map;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class MantisRenderer extends MobRenderer<MantisEntity, MantisRenderState, MantisModel> {
    private static final Map<MantisVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MantisVariant.class), map -> {
                map.put(MantisVariant.DEFAULT,
                        createIdentifier("textures/entity/mantis/mantis.png"));
                map.put(MantisVariant.ORCHID,
                        createIdentifier("textures/entity/mantis/mantis_orchid.png"));
            });


    public MantisRenderer(EntityRendererProvider.Context context) {
        super(context, new MantisModel(context.bakeLayer(MantisModel.MANTIS)), 0.75f);
    }

    @Override
    public Identifier getTextureLocation(MantisRenderState livingEntityRenderState) {
        return LOCATION_BY_VARIANT.get(livingEntityRenderState.variant);
    }

    @Override
    public MantisRenderState createRenderState() {
        return new MantisRenderState();
    }

    @Override
    public void extractRenderState(MantisEntity livingEntity, MantisRenderState livingEntityRenderState, float f) {
        super.extractRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.variant = livingEntity.getVariant();
    }

    @Override
    protected void scale(MantisRenderState livingEntityRenderState, PoseStack poseStack) {
        if (livingEntityRenderState.isBaby) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.scale(livingEntityRenderState, poseStack);
    }
}