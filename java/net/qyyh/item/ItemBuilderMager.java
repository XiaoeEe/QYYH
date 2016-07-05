package net.qyyh.item;

import net.minecraft.client.renderer.block.model.multipart.Selector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.qyyh.loader.CreativeTabsLoader;
import net.qyyh.other.NBT;

public class ItemBuilderMager extends Item {
	
	public ItemBuilderMager() {
		super();
		this.setCreativeTab(CreativeTabsLoader.tabTheBuilderItems);
	}

	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		if (!player.getEntityWorld().isRemote) {
			NBT.setPosToNBT(pos, player, "1");
			NBT.setPosToNBT(pos, player, "2");
			player.addChatMessage(new TextComponentTranslation("commands.msg.select1",pos.getX(), pos.getY() , pos.getZ()));
		}
		return true;
	}

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if(NBT.setIsReady(player)){
				NBT.setPosToNBT(pos,player, "2");
				player.addChatMessage(new TextComponentTranslation("commands.msg.select2",pos.getX(), pos.getY() , pos.getZ()));
			}
			else{
				player.addChatMessage(new TextComponentTranslation("commands.msg.NoReady"));
			}
		}
		return EnumActionResult.PASS;
	}
	
}
