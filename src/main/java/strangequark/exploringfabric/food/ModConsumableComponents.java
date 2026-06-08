package strangequark.exploringfabric.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.world.item.component.Consumables.defaultFood;

public class ModConsumableComponents {
    public static final Consumable CAULIFLOWER = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.WEAKNESS, 300, 1),
                            new MobEffectInstance(MobEffects.SLOWNESS, 300, 1)
                    ),
                    0.25f
            ))
            .build();
}