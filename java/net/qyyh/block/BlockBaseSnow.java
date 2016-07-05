package net.qyyh.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.qyyh.loader.CreativeTabsLoader;

public class BlockBaseSnow extends Block {
	
	public BlockBaseSnow() {
		super(Material.ground);
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderBlocks);
		this.setHardness(0.2F);
		this.setStepSound(SoundType.SNOW);
	}

}
