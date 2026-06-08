package strangequark.exploringfabric.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import strangequark.exploringfabric.item.ModItems;

@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerEntityMixin extends Player {
    @Unique
    @Nullable
    private PlayerInfo playerListEntry;

    public AbstractClientPlayerEntityMixin(ClientLevel world, GameProfile profile) {
        super(world, profile);
    }

    @Override
    public @Nullable GameType gameMode() {
        PlayerInfo playerListEntry = this.getPlayerListEntry();
        return playerListEntry != null ? playerListEntry.getGameMode() : null;
    }

    @Unique
    @Nullable
    protected PlayerInfo getPlayerListEntry() {
        if (this.playerListEntry == null) {
            var networkHandler = Minecraft.getInstance().getConnection();
            if (networkHandler == null) {
                return null;
            }
            this.playerListEntry = networkHandler.getPlayerInfo(this.getUUID());
        }
        return this.playerListEntry;
    }

    // With help from https://github.com/Globox1997/MedievalWeapons/blob/1.21/src/main/java/net/medievalweapons/mixin/client/AbstractClientPlayerEntityMixin.java
    // Under MIT License!
    @Inject(method = "getFieldOfViewModifier", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void getFovMultiplierMixin(boolean firstPerson, float fovEffectScale, CallbackInfoReturnable<Float> info, float f) {
        if (this.isUsingItem()) {
            if (this.getUseItem().is(ModItems.QUARK_BOW)) {
                float h = Math.min(this.getTicksUsingItem() / 20.0F, 1.0F);
                f *= 1.0F - Mth.square(h) * 0.15F;
                info.setReturnValue(Mth.lerp(Minecraft.getInstance().options.fovEffectScale().get().floatValue(), 1.0f, f));
            }
        }
    }
}