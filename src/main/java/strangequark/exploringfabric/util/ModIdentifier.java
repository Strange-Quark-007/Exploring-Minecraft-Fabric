package strangequark.exploringfabric.util;


import net.minecraft.resources.Identifier;
import strangequark.exploringfabric.ExploringFabric;

public class ModIdentifier {
    public static Identifier createIdentifier(String name) {
        return Identifier.fromNamespaceAndPath(ExploringFabric.MOD_ID, name);
    }
}
