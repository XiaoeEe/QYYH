package net.qyyh.item;

import net.minecraft.item.Item;
import net.qyyh.loader.CreativeTabsLoader;

public class ItemPowder extends Item{

	public ItemPowder(){
		super();
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderItems);
	}
}
