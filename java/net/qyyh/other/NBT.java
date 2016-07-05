package net.qyyh.other;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.qyyh.entity.EntityMaid;

public class NBT {
	public static NBTTagCompound getTag(EntityPlayerMP player) {
		NBTTagCompound abc = new NBTTagCompound();
		if (player.getEntityData().hasKey("PlayerPersisted")) {
			abc = player.getEntityData().getCompoundTag("PlayerPersisted");
		}
		player.getEntityData().setTag("PlayerPersisted", abc);
		return abc;
	}
	
	public static void setPosToNBT(BlockPos pos, EntityPlayer player, String flag) {
		NBTTagCompound compound = getTag((EntityPlayerMP) player);
		compound.setBoolean("ready"+ flag, true);
		compound.setInteger("x" + flag, pos.getX());
		compound.setInteger("y" + flag, pos.getY());
		compound.setInteger("z" + flag, pos.getZ());
	}

	public static BlockPos getPosForm(EntityPlayer player, String flag) {

		NBTTagCompound compound = getTag((EntityPlayerMP) player);
		int x = compound.getInteger("x" + flag);
		int y = compound.getInteger("y" + flag);
		int z = compound.getInteger("z" + flag);
		return new BlockPos(x, y, z);
	}

	public static boolean setIsReady(EntityPlayer player) {
		NBTTagCompound compound = getTag((EntityPlayerMP) player);
		return compound.getBoolean("ready1");
	}
	
	public static void logout(EntityPlayer player){
		NBTTagCompound compound = getTag((EntityPlayerMP) player);
		compound.removeTag("ready1");
		compound.removeTag("x1");
		compound.removeTag("y1");
		compound.removeTag("z1");
		compound.removeTag("x2");
		compound.removeTag("y2");
		compound.removeTag("z2");
	}

}
