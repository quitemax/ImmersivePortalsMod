package qouteall.imm_ptl.core.render.context_management;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import qouteall.imm_ptl.core.McHelper;
import qouteall.imm_ptl.core.portal.Portal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class RenderStates {
    public static int frameIndex = 0;

    public static ResourceKey<Level> originalPlayerDimension;
    public static Vec3 originalPlayerPos = Vec3.ZERO;
    public static Vec3 originalPlayerLastTickPos = Vec3.ZERO;

    private static float partialTick = 0;

    public static List<List<WeakReference<Portal>>> lastPortalRenderInfos = new ArrayList<>();

    public static long renderStartNanoTime;

    public static void updatePreRenderInfo(float newPartialTick) {
        Entity cameraEntity = Minecraft.getInstance().getCameraEntity();

        if (cameraEntity == null) {
            return;
        }

        originalPlayerDimension = cameraEntity.level().dimension();
        originalPlayerPos = cameraEntity.position();
        originalPlayerLastTickPos = McHelper.lastTickPosOf(cameraEntity);
        partialTick = newPartialTick;
        renderStartNanoTime = System.nanoTime();
    }

    public static void setPartialTick(float partialTick_) {
        partialTick = partialTick_;
    }

    /**
     * This does not always equal the vanilla partial tick.
     * It will be 0 right after ticking.
     */
    public static float getPartialTick() {
        return partialTick;
    }

    public static List<String> collectDebugText() {
        List<String> result = new ArrayList<>();
        result.add("Portal rendering is disabled (not ported yet)");
        return result;
    }
}