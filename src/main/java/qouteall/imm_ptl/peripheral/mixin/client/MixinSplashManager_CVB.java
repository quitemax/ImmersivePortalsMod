package qouteall.imm_ptl.peripheral.mixin.client;
import java.util.ArrayList;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mutable;

import net.minecraft.client.resources.SplashManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SplashManager.class)
public class MixinSplashManager_CVB {
    @Shadow
    @Mutable
    private List<Component> splashes;
    
    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("RETURN"))
    private void onApply(
        List<Component> list, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci
    ) {
        List<Component> newSplashes = new ArrayList<>(splashes);
        if (newSplashes.removeIf(c -> c.getString().equals("Euclidian!"))) {
            newSplashes.add(Component.literal("Non-Euclidian!"));
        }
        if (newSplashes.removeIf(c -> c.getString().equals("Slow acting portals!"))) {
            newSplashes.add(Component.literal("Fast acting portals!"));
            newSplashes.add(Component.literal("Immersive Portals!"));
        }
        splashes = List.copyOf(newSplashes);
    }
}
