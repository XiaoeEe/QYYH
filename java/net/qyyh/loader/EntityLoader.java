package net.qyyh.loader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.qyyh.Qyyh;
import net.qyyh.entity.EntityMaid;
import net.qyyh.entity.render.RenderEntityMaid;

public class EntityLoader {
	
    public EntityLoader(){
        registerEntity(EntityMaid.class, "Mide", 80, 3, true);
        registerEntityEgg(EntityMaid.class, 0xffffff, 0x000000);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerEntityRender(EntityMaid.class, new IRenderFactory<EntityMaid>()
        {
            @Override
            public Render<? super EntityMaid> createRenderFor(RenderManager manager)
            {
                return new RenderEntityMaid(manager);
            }
        });
    }
    
    private static void registerEntityEgg(Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(entityClass, eggPrimary, eggSecondary);
    }

	private void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(entityClass, name, name.hashCode(), Qyyh.instance, trackingRange, updateFrequency,sendsVelocityUpdates);
	}
	
    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, IRenderFactory<T> renderFactory)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }
}
