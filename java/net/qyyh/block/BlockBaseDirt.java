package net.qyyh.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.qyyh.loader.CreativeTabsLoader;

public class BlockBaseDirt extends Block{
	
	public BlockBaseDirt(){
		super(Material.ground);
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderBlocks);
		this.setHardness(0.2F);
		this.setStepSound(SoundType.GROUND);
	}
}
