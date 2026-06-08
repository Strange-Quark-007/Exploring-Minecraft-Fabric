package strangequark.exploringfabric.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse context, Entity user, Vec3 pos) {
        RandomSource random = RandomSource.create();
        var userPos = user.blockPosition();
        int strikes = (int) Math.round(Math.pow(enchantLevel, 2));

        if (!level.canSeeSky(userPos)) {
            return;
        }

        for (int i = 0; i < strikes; i++) {
            var blockPos = user.blockPosition();
            int offset = random.nextInt(3) - 1;
            var strikePos = blockPos.offset(offset, 0, offset);
            EntityType.LIGHTNING_BOLT.spawn(level, strikePos, EntitySpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}