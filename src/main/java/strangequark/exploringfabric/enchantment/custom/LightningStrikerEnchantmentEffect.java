package strangequark.exploringfabric.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        var userPos = user.getBlockPos();

        if (!world.isSkyVisibleAllowingSea(userPos)) {
            return;
        }
        if (level == 1) {
            EntityType.LIGHTNING_BOLT.spawn(world, userPos, SpawnReason.TRIGGERED);
        }
        if (level == 2) {
            EntityType.LIGHTNING_BOLT.spawn(world, userPos, SpawnReason.TRIGGERED);
            EntityType.LIGHTNING_BOLT.spawn(world, userPos, SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
