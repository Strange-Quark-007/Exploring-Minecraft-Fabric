package strangequark.exploringfabric.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import strangequark.exploringfabric.enchantment.ModEnchantments;

@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonEntityMixin extends HostileEntity {

    protected SkeletonEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    /*
     * Gives skeletons a chance to spawn with bows enchanted with the custom Lightning Striker enchantment.
     *
     * Notes:
     * - Tried making skeletons spawn with the custom Quark Bow and overriding related methods, but couldn’t get it to work reliably.
     * - Current implementation uses vanilla bows with custom Lightning Striker enchantment.
     *
     * Future improvements:
     * - Could potentially add the Lightning Striker enchantment to bows via the `non_treasure` tag.
     */

    @Inject(method = "initEquipment", at = @At("TAIL"))
    private void injectCustomBowEquipment(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        DynamicRegistryManager registryManager = this.getEntityWorld().getRegistryManager();
        RegistryEntry<Enchantment> lightningStrikerEntry = registryManager.getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(ModEnchantments.LIGHTNING_STRIKER);

        if (this.getType() != EntityType.SKELETON) {
            return;
        }

        float customEnchantChance = 0.3f;
        int enchantLevel = random.nextBetween(1, 5);

        if (random.nextFloat() < customEnchantChance) {
            ItemStack stack = new ItemStack(Items.BOW);
            stack.addEnchantment(lightningStrikerEntry, enchantLevel);

            this.equipStack(EquipmentSlot.MAINHAND, stack);
            this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.1F);
        }
    }
}