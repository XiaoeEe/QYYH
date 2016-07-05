package net.qyyh.loader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.qyyh.item.ItemBuilderMager;
import net.qyyh.item.ItemCatTeaser;
import net.qyyh.item.ItemPowder;
import net.qyyh.other.StringConversion;

public class ItemLoader {
	
	public static Item builderMager = new ItemBuilderMager();
	public static Item catTeaser = new ItemCatTeaser();
	public static Item quartzPowder = new ItemPowder();
	public static Item sandPowder = new ItemPowder();
	
    public ItemLoader(FMLPreInitializationEvent event){
        register(builderMager, "builder_mager");
        register(catTeaser, "cat_teaser");
        register(quartzPowder, "quartz_powder");
        register(sandPowder, "sand_powder");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(builderMager);
        registerRender(catTeaser);
        registerRender(quartzPowder);
        registerRender(sandPowder);
    }
    
    private static void register(Item item, String name){
    	item.setUnlocalizedName(StringConversion.to(name));
    	item.setRegistryName(name);
    	GameRegistry.register(item);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
