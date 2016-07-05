package net.qyyh.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.qyyh.loader.BlockLoader;
import net.qyyh.loader.CommandLoader;
import net.qyyh.loader.ConfigLoader;
import net.qyyh.loader.CraftingLoader;
import net.qyyh.loader.CreativeTabsLoader;
import net.qyyh.loader.EntityLoader;
import net.qyyh.loader.EventLoader;
import net.qyyh.loader.ItemLoader;

public class CommonProxy {
	
    public void preInit(FMLPreInitializationEvent event){
    	new ConfigLoader(event);
    	new CreativeTabsLoader(event);
    	new ItemLoader(event);
    	new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event){
    	new CraftingLoader();
    	new EventLoader();
    	new EntityLoader();
    }

    public void postInit(FMLPostInitializationEvent event){

    }

	public void serverStarting(FMLServerStartingEvent event) {
		new CommandLoader(event);
	}

}
