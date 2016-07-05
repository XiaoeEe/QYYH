package net.qyyh.loader;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader {
	
    private static Configuration config;

    public static boolean lockBuilderMager;
    public static int BuilderMagerLevel;

    public ConfigLoader(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        registerConfig();

        config.save();
    }

    private static void registerConfig()
    {
    	lockBuilderMager = config.get(Configuration.CATEGORY_GENERAL, "LockBuilderMager", false).getBoolean();
    	BuilderMagerLevel = config.get(Configuration.CATEGORY_GENERAL, "LockBuilderMager", 4).getInt();
    }
    
}
