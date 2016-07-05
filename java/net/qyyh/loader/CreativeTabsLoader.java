package net.qyyh.loader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {

    public static CreativeTabs tabTheBuilderItems;
    public static CreativeTabs tabTheBuilderBlocks;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	tabTheBuilderItems = new CreativeTabs("tabTheBuilderItems")
        {
            @Override
            public Item getTabIconItem()
            {
                return ItemLoader.builderMager;
            }
        };
        tabTheBuilderBlocks = new CreativeTabs("tabTheBuilderBlocks")
        {
            @Override
            public Item getTabIconItem()
            {
                return Item.getItemFromBlock(BlockLoader.blockA);
            }
        };
    }
}
