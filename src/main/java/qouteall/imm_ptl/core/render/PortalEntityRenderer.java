package qouteall.imm_ptl.core.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import qouteall.imm_ptl.core.portal.Portal;

/**
 * The portal entity itself renders nothing. The portal view is rendered by the portal renderer
 * (not ported to 26.x yet).
 */
public class PortalEntityRenderer extends EntityRenderer<Portal, EntityRenderState> {
    public PortalEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}