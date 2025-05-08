package strangequark.exploringfabric.utils;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import strangequark.exploringfabric.ExploringFabric;

public class ModIdentifier {
    public static @NotNull Identifier createIdentifier(String name) {
        return Identifier.of(ExploringFabric.MOD_ID, name);
    }
}
