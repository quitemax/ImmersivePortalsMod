package qouteall.imm_ptl.core.render;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class QueryManager {
    public static int queryStallCounter = 0;

    public static boolean renderAndGetDoesAnySamplePass(Runnable renderingFunc) {
        return true;
    }
}