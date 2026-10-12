package qouteall.q_misc_util.mixin.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qouteall.q_misc_util.CustomTextOverlay;

@Mixin(Hud.class)
public abstract class MixinGui_Overlay {
    @Shadow
    public abstract boolean isHidden();
    
    @Inject(
        method = "extractRenderState", at = @At("RETURN")
    )
    private void onRender(
        GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci
    ) {
        if (!this.isHidden()) {
            CustomTextOverlay.render(guiGraphics, deltaTracker);
        }
    }
}
