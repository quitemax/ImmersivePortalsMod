package qouteall.imm_ptl.core.render.context_management;

import java.util.List;
import java.util.UUID;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class WorldRenderInfo {
    public static boolean isRendering() {
        return false;
    }

    public static List<UUID> getRenderingDescription() {
        return List.of();
    }
}