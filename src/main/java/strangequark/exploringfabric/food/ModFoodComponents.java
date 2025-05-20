package strangequark.exploringfabric.food;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent HONEY_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
}
