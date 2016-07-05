package net.qyyh.loader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.qyyh.other.NBT;

public class EventLoader {
	
    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void PlayerLoggedOutEvent(PlayerEvent event)
    {
        if (event.player.isServerWorld())
        {
            NBT.logout(event.player);
        }
    }
}
