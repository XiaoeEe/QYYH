package net.qyyh;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.qyyh.proxy.CommonProxy;

@Mod(modid = "qyyh", name = "The World of QYYH", version = "0.1")
public class Qyyh {
	
	public static final String MODID = "qyyh";
	public static final String NAME = "The World of QYYH";
	public static final String VERSION = "0.1";


	@SidedProxy(clientSide = "net.qyyh.proxy.ClientProxy", serverSide = "net.qyyh.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(MODID)
	public static Qyyh instance;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        proxy.serverStarting(event);
    }
}
