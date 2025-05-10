package strangequark.exploringfabric.food;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent CAULIFLOWER = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 1),
                            new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 1)
                    ),
                    0.25f
            ))
            .build();
}
