package qouteall.imm_ptl.core.mixin.client.sync;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * The vanilla loading screen waits until the render section of the player is compiled.
 * ImmPtl uses its own client chunk map, and the section compiling is not tied to it
 * (and the portal rendering is not ported yet), so the vanilla condition may never be met.
 * Consider the level ready when the chunk of the player has arrived.
 */
@Mixin(targets = "net.minecraft.client.multiplayer.LevelLoadTracker$WaitingForPlayerChunk")
public abstract class MixinLevelLoadTracker_WaitingForPlayerChunk {
    @Shadow
    @Final
    private LocalPlayer player;
    
    @Shadow
    @Final
    private ClientLevel level;
    
    @Inject(method = "isReady", at = @At("HEAD"), cancellable = true)
    private void onIsReady(CallbackInfoReturnable<Boolean> cir) {
        if (level.getChunkSource().getChunk(
            player.chunkPosition().x(), player.chunkPosition().z(), ChunkStatus.FULL, false
        ) != null) {
            cir.setReturnValue(true);
        }
    }
}
