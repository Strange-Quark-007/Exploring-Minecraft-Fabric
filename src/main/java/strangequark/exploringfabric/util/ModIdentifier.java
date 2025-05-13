package strangequark.exploringfabric.util;

import net.minecraft.util.Identifier;
import strangequark.exploringfabric.ExploringFabric;

public class ModIdentifier {
    public static Identifier createIdentifier(String name) {
        return Identifier.of(ExploringFabric.MOD_ID, name);
    }
}
