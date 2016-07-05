package net.qyyh.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.qyyh.loader.EntityRenderLoader;
import net.qyyh.loader.ItemRenderLoader;


public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		new EntityRenderLoader();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		new ItemRenderLoader();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
