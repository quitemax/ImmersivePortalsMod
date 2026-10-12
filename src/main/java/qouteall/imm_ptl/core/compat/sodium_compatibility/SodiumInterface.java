package qouteall.imm_ptl.core.compat.sodium_compatibility;

import net.minecraft.client.multiplayer.ClientLevel;

// NOTE: The portal rendering is not ported to Minecraft 26.x yet.
// This is a minimal stub that keeps the non-rendering code compiling.
// The original implementation is in src/main/disabled.
public class SodiumInterface {
    public static class Invoker {
        public boolean isSodiumPresent() {
            return false;
        }

        public void onClientChunkLoaded(ClientLevel world, int chunkX, int chunkZ) {

        }

        public void onClientChunkUnloaded(ClientLevel world, int chunkX, int chunkZ) {

        }
    }

    public static Invoker invoker = new Invoker();
}