package net.qyyh.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.qyyh.Qyyh;
import net.qyyh.entity.EntityMaid;
import net.qyyh.entity.model.ModelMaid;
import net.qyyh.other.NBT;

public class RenderEntityMaid extends RenderLiving{

    private static final ResourceLocation MAID_TEXTURE1 = new ResourceLocation(Qyyh.MODID + ":" + "textures/entity/maid1.png");
    private static final ResourceLocation MAID_TEXTURE2 = new ResourceLocation(Qyyh.MODID + ":" + "textures/entity/maid2.png");
    private static final ResourceLocation MAID_TEXTURE3 = new ResourceLocation(Qyyh.MODID + ":" + "textures/entity/maid3.png");
    private static final ResourceLocation MAID_TEXTURE4 = new ResourceLocation(Qyyh.MODID + ":" + "textures/entity/maid4.png");
    private static final ResourceLocation MAID_TEXTURE5 = new ResourceLocation(Qyyh.MODID + ":" + "textures/entity/maid5.png");

	public RenderEntityMaid(RenderManager renderManager) {
		super(renderManager, new ModelMaid(0.0F), 0.5F);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		int iconType=entity.getDataManager().get(EntityMaid.ICON_TYPE);
		switch (iconType) {
		case 0:
			return RenderEntityMaid.MAID_TEXTURE1;
		case 1:
			return RenderEntityMaid.MAID_TEXTURE2;
		case 2:
			return RenderEntityMaid.MAID_TEXTURE3;
		case 3:
			return RenderEntityMaid.MAID_TEXTURE4;
		case 4:
			return RenderEntityMaid.MAID_TEXTURE5;
		default:
			return RenderEntityMaid.MAID_TEXTURE5;
		}
	}

}
