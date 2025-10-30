package strangequark.exploringfabric.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItems;

import static strangequark.exploringfabric.component.ModDataComponentTypes.BLOCK;
import static strangequark.exploringfabric.component.ModDataComponentTypes.COORDINATES;

public class ModTooltips {
    public static void registerModTooltips() {
        ExploringFabric.LOGGER.info("Registering Mod Tooltips for " + ExploringFabric.MOD_ID);

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {


            if (itemStack.isOf(ModItems.CHISEL)) {
                if (!MinecraftClient.getInstance().isShiftPressed()) {
                    list.add(Text.translatable("item.exploringfabric.chisel.tooltip"));
                    return;
                }

                list.add(Text.translatable("item.exploringfabric.chisel.tooltip_expanded"));

                if (itemStack.get(COORDINATES) != null && itemStack.get(BLOCK) instanceof Block block) {
                    list.add(Text.literal("Last Block changed: " + block.getName().getString() + " at " + itemStack.get(COORDINATES)));
                }
            }
            if (itemStack.isOf(ModBlocks.MAGIC_BLOCK.asItem())) {
                if (MinecraftClient.getInstance().isShiftPressed()) {
                    list.add(Text.translatable("item.exploringfabric.magic_block.tooltip_expanded"));
                } else {
                    list.add(Text.translatable("item.exploringfabric.magic_block.tooltip"));
                }
            }
        });
    }
}
