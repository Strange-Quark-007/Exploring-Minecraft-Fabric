package strangequark.exploringfabric.entity.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import strangequark.exploringfabric.entity.custom.MantisVariant;

public class MantisRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public MantisVariant variant;
}