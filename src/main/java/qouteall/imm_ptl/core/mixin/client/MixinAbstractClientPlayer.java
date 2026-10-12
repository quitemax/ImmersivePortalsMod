package qouteall.imm_ptl.core.mixin.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import qouteall.imm_ptl.core.ducks.IEAbstractClientPlayer;
import qouteall.imm_ptl.core.ducks.IEEntity;

@Mixin(AbstractClientPlayer.class)
public class MixinAbstractClientPlayer implements IEAbstractClientPlayer {
    // the client level is stored in the entity level field in 26.x
    @Override
    public void ip_setClientLevel(ClientLevel clientWorld) {
        ((IEEntity) (Object) this).ip_setWorld(clientWorld);
    }
}
