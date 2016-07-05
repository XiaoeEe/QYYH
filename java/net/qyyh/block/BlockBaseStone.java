package net.qyyh.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.qyyh.loader.CreativeTabsLoader;

public class BlockBaseStone extends Block {

	public BlockBaseStone() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderBlocks);
		this.setHardness(1.0F);
		this.setStepSound(SoundType.STONE);
	}

}

//setHardness方法用于设定方块的硬度，如黑曜石是50，铁块5，金块3，圆石2，石头1.5，南瓜1，泥土0.5，甘蔗0，基岩-1。
//setHarvestLevel方法用于设定方块的可挖掘等级，如钻石镐是3，铁2，石1，木金0。 pickaxe稿 axe斧 shovel铲
//setLightLevel方法用于设定方块的光照，其周围的光照为设定值x15，如岩浆1.0，对应15，红石火把0.5，对应7.5。
//setLightOpacity方法用于设定方块的透光率，数值越大透光率越低，如树叶和蜘蛛网是1，水和冰3。
//setResistance方法用于设定方块的爆炸抗性，如木头的抗性为4，石头为10，黑曜石为2000，基岩为6000000。
//setStepSound方法用于设定走在方块上的响声。
//setTickRandomly方法用于设定方块是否会接受随机Tick（如农作物）。
