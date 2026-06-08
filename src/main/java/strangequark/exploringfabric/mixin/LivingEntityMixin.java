package strangequark.exploringfabric.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import strangequark.exploringfabric.effect.ModEffects;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    // Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/src/main/java/samebutdifferent/trickortreat/effect/ClimbingEffect.java
    // MIT License!
    @Inject(method = "travel", at = @At("HEAD"))
    private void applySlimeyClimbing(Vec3 movementInput, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.hasEffect(ModEffects.SLIMEY)) {
            if (entity.horizontalCollision) {
                Vec3 initialVec = entity.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
                entity.setDeltaMovement(climbVec.x * 0.91D, climbVec.y * 0.98D, climbVec.z * 0.91D);
            }
        }
    }
}