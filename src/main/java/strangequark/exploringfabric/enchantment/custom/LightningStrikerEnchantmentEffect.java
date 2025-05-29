package strangequark.exploringfabric.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        Random random = Random.create();
        var userPos = user.getBlockPos();
        int strikes = (int) Math.round(Math.pow(level, 2));

        if (!world.isSkyVisibleAllowingSea(userPos)) {
            return;
        }

        for (int i = 0; i < strikes; i++) {
            var blockPos = user.getBlockPos();
            int offset = random.nextBetween(-1, 1);
            var strikePos = blockPos.add(offset, 0, offset);
            EntityType.LIGHTNING_BOLT.spawn(world, strikePos, SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
