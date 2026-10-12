package qouteall.imm_ptl.core.ducks;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.extract.LevelExtractor;

public interface IEMinecraftClient {
    Screen ip_getCurrentScreen();
    
    void ip_setWorldRenderer(LevelExtractor r);
    
    Thread ip_getRunningThread();
}
