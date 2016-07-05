package net.qyyh.loader;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.qyyh.command.CommandSet;

public class CommandLoader {
 
	public CommandLoader(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandSet());
	}
}
