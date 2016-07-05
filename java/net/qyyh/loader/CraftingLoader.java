package net.qyyh.loader;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader {
	
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe(){
    	GameRegistry.addRecipe(new ItemStack(BlockLoader.tileModel, 4), new Object[] {"###", "#*#", "XXX", '#', ItemLoader.quartzPowder, 'X', Items.clay_ball,'*',Items.water_bucket});
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.clay_ball, 4), ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,ItemLoader.sandPowder,Items.water_bucket);
    }

    private static void registerSmelting(){
    	GameRegistry.addSmelting(BlockLoader.tileModel, new ItemStack(BlockLoader.blockA), 0.5F);
    }

    private static void registerFuel(){
    	 GameRegistry.registerFuelHandler(new IFuelHandler()
    	    {
    	        @Override
    	        public int getBurnTime(ItemStack fuel)
    	        {
    	            return Items.diamond != fuel.getItem() ? 0 : 12800;
    	        }
    	    });
    }
}
