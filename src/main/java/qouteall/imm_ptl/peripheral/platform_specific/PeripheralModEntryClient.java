package qouteall.imm_ptl.peripheral.platform_specific;

import net.fabricmc.api.ClientModInitializer;
import qouteall.imm_ptl.peripheral.PeripheralModMain;

public class PeripheralModEntryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // In 26.x the block render layer is defined by the block/model, not registered here.

        PeripheralModMain.initClient();
    }
}
