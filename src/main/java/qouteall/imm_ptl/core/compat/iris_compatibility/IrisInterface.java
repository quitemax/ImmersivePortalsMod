package qouteall.imm_ptl.core.compat.iris_compatibility;

import org.jetbrains.annotations.Nullable;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class IrisInterface {
    public static class Invoker {
        public boolean isIrisPresent() {
            return false;
        }

        public boolean isShaders() {
            return false;
        }

        public boolean isRenderingShadowMap() {
            return false;
        }

        @Nullable
        public String getShaderpackName() {
            return null;
        }
    }

    public static Invoker invoker = new Invoker();
}