package net.qyyh.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.qyyh.loader.CreativeTabsLoader;

public class BlockBaseTile extends Block {

	public BlockBaseTile() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderBlocks);
		this.setHardness(0.5F);
		this.setStepSound(SoundType.GLASS);
	}


}
