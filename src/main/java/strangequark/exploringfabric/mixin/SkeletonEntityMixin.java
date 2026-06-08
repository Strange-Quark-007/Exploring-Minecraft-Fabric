// File: src/main/java/strangequark/exploringfabric/mixin/SkeletonEntityMixin.java

package strangequark.exploringfabric.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import strangequark.exploringfabric.enchantment.ModEnchantments;

@Mixin(AbstractSkeleton.class)
public abstract class SkeletonEntityMixin extends Monster {

    protected SkeletonEntityMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
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

    @Inject(method = "populateDefaultEquipmentSlots", at = @At("TAIL"))
    private void injectCustomBowEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        RegistryAccess registryManager = this.level().registryAccess();
        Holder<Enchantment> lightningStrikerEntry = registryManager.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ModEnchantments.LIGHTNING_STRIKER);

        if (this.getType() != EntityType.SKELETON) {
            return;
        }

        float customEnchantChance = 0.3f;
        int enchantLevel = random.nextInt(1, 6);

        if (random.nextFloat() < customEnchantChance) {
            ItemStack stack = new ItemStack(Items.BOW);

            stack.enchant(lightningStrikerEntry, enchantLevel);

            this.setItemSlot(EquipmentSlot.MAINHAND, stack);
            this.setDropChance(EquipmentSlot.MAINHAND, 0.1F);
        }
    }
}