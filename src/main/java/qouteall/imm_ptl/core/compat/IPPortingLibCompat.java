package qouteall.imm_ptl.core.compat;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import qouteall.imm_ptl.core.ducks.IEFrameBuffer;
import qouteall.q_misc_util.Helper;

import java.lang.reflect.Field;

public class IPPortingLibCompat {
    
    public static boolean isPortingLibPresent = false;
    
    private static Field f_port_lib$stencilEnabled;
    
    public static void init() {
        if (FabricLoader.getInstance().isModLoaded("porting_lib")) {
            Helper.log("Porting Lib is present");
            isPortingLibPresent = true;
            
            if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
                f_port_lib$stencilEnabled = Helper.noError(
                    () -> RenderTarget.class.getDeclaredField("port_lib$stencilEnabled")
                );
                f_port_lib$stencilEnabled.setAccessible(true);
            }
        }
    }
    
    
}
