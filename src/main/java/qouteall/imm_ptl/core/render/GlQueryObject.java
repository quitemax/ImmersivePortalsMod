package qouteall.imm_ptl.core.render;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class GlQueryObject {
    public static GlQueryObject acquireQueryObject() {
        return new GlQueryObject();
    }

    public void performQueryAnySamplePassed(Runnable renderingFunc) {
        renderingFunc.run();
    }
    
    public boolean fetchQueryResult() {
        return true;
    }
    
    public static void returnQueryObject(GlQueryObject object) {

    }
}