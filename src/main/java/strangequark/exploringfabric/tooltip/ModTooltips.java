package strangequark.exploringfabric.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItems;

public class ModTooltips {
    public static void registerModTooltips() {
        ExploringFabric.LOGGER.info("Registering Mod Tooltips for " + ExploringFabric.MOD_ID);

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.CHISEL)) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("item.exploringfabric.chisel.tooltip_expanded"));
                } else {
                    list.add(Text.translatable("item.exploringfabric.chisel.tooltip"));
                }

            }
            if (itemStack.isOf(ModBlocks.MAGIC_BLOCK.asItem())) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("item.exploringfabric.magic_block.tooltip_expanded"));
                } else {
                    list.add(Text.translatable("item.exploringfabric.magic_block.tooltip"));
                }
            }
        });
    }
}
