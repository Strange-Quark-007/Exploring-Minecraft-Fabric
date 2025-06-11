package strangequark.exploringfabric.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WardenEntity.class)
public class WardenEntityMixin extends HostileEntity {
    private final ServerBossBar bossbar = new ServerBossBar(Text.literal("Warden"), BossBar.Color.PURPLE, BossBar.Style.NOTCHED_20);

    protected WardenEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossbar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossbar.removePlayer(player);
    }

    @Inject(method = "mobTick", at = @At("HEAD"))
    public void mobTick(ServerWorld world, CallbackInfo ci) {
        this.bossbar.setPercent(this.getHealth() / this.getMaxHealth());
    }
}
