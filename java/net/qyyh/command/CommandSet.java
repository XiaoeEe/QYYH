package net.qyyh.command;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.qyyh.loader.ConfigLoader;
import net.qyyh.other.NBT;

public class CommandSet extends CommandBase{

	@Override
	public String getCommandName() {
		return "set";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		 return "commands.msg.set";
	}

    @Override
    public int getRequiredPermissionLevel(){
        return ConfigLoader.BuilderMagerLevel;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args.length == 1)
        {
        	EntityPlayerMP player =  CommandBase.getCommandSenderAsPlayer(sender);
        	World world= player.getEntityWorld();
        	if(NBT.setIsReady(player)){
        		BlockPos pos1=NBT.getPosForm(player, "1");
        		BlockPos pos2=NBT.getPosForm(player, "2");
        		if(args[0].equals("0")){
        			setBolcks(world,player,pos1.getX(),pos1.getY(),pos1.getZ(),pos2.getX(),pos2.getY(),pos2.getZ(),"0",null);
        		}
        		else if(Block.getBlockFromName(args[0])!=null){
        			Block b=Block.getBlockFromName(args[0]);
        			setBolcks(world,player,pos1.getX(),pos1.getY(),pos1.getZ(),pos2.getX(),pos2.getY(),pos2.getZ(),"1",b);
        		}
        		else{
        			player.addChatMessage(new TextComponentTranslation("commands.msg.NoBlock"));
        		}
        	}
        	else{
        		player.addChatMessage(new TextComponentTranslation("commands.msg.NoChick"));
        	}
        }
        else if(args.length == 2){
        	EntityPlayerMP player =  CommandBase.getCommandSenderAsPlayer(sender);
        	World world= player.getEntityWorld();
        	if(NBT.setIsReady(player)){
        		BlockPos pos1=NBT.getPosForm(player, "1");
        		BlockPos pos2=NBT.getPosForm(player, "2");
        		if(Block.getBlockFromName(args[0])!=null){
        			Block b=Block.getBlockFromName(args[0]);
        			setBolcks(world,player,pos1.getX(),pos1.getY(),pos1.getZ(),pos2.getX(),pos2.getY(),pos2.getZ(),args[1],b);
        		}
        		else{
        			player.addChatMessage(new TextComponentTranslation("commands.msg.NoBlock"));
        		}
        	}
        }
        else{
        	throw new WrongUsageException("commands.msg.set", new Object[0]);
        }
	}
	
    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos)
    {
    	if(args.length==1){
    		return getListOfStringsMatchingLastWord(args,Block.blockRegistry.getKeys());
    	}else if(args.length==2){
    		return getListOfStringsMatchingLastWord(args,new String[]{"0","1","2","3"});
    	}
        return null;
    }
	
	private void setBolcks(World world,EntityPlayer player,int x1,int y1,int z1,int x2,int y2,int z2,String mode,Block block) {
    	if(x1>x2){int temp=x1;x1=x2;x2=temp;}
		if(y1>y2){int temp=y1;y1=y2;y2=temp;}
		if(z1>z2){int temp=z1;z1=z2;z2=temp;}
    	switch(mode) {
	 	    case "0":{
	 	    	for(int i=x1;i<=x2;i++){
	    			for(int j=y1;j<=y2;j++){
	    				for(int k=z1;k<=z2;k++){
	    					world.setBlockToAir(new BlockPos(i,j,k));
	    				}
	    			}
	    		}
	 	    	player.addChatMessage(new TextComponentTranslation("commands.msg.setblock",Blocks.air.getLocalizedName(),"模式:清空"));
	 	    	break;
	 	    }
	 	    case "1":{
	 	    	for(int i=x1;i<=x2;i++){
	    			for(int j=y1;j<=y2;j++){
	    				for(int k=z1;k<=z2;k++){
	    					world.setBlockState(new BlockPos(i, j, k), block.getDefaultState());
	    				}
	    			}
	    		}
	 	    	player.addChatMessage(new TextComponentTranslation("commands.msg.setblock",block.getLocalizedName(),"模式:填充模式"));
	 	    	break;
	 	    }
	 	    case "2":{
	 	    	for(int i=x1;i<=x2;i++){
	 	    		world.setBlockState(new BlockPos(i, y1, z1), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(i, y2, z2), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(i, y1, z2), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(i, y2, z1), block.getDefaultState());
	 	    	}
	 	    	for(int j=y1;j<=y2;j++){
	 	    		world.setBlockState(new BlockPos(x1, j, z1), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x2, j, z2), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x1, j, z2), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x2, j, z1), block.getDefaultState());
	 	    	}
	 	    	for(int k=z1;k<=z2;k++){
	 	    		world.setBlockState(new BlockPos(x1, y1, k), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x2, y2, k), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x2, y1, k), block.getDefaultState());
	 	    		world.setBlockState(new BlockPos(x1, y2, k), block.getDefaultState());
	 	    	}
	 	    	player.addChatMessage(new TextComponentTranslation("commands.msg.setblock",block.getLocalizedName(),"模式:框架模式"));
	 	    	break;
	 	    }
	 	    case "3":{
	 	    	for(int i=x1;i<=x2;i++){
	    			for(int j=y1;j<=y2;j++){
	    				for(int k=z1;k<=z2;k++){
	    					world.setBlockState(new BlockPos(i, j, k),block.getDefaultState());
	    				}
	    			}
	    		}
	 	    	for(int i=x1+1;i<x2;i++){
	    			for(int j=y1+1;j<y2;j++){
	    				for(int k=z1+1;k<z2;k++){
	    					world.setBlockToAir(new BlockPos(i, j, k));
	    				}
	    			}
	    		}
	 	    	player.addChatMessage(new TextComponentTranslation("commands.msg.setblock",block.getLocalizedName(),"模式:盒模式"));
	 	    	break;
	 	    }
	 	   default:{
	 		   	player.addChatMessage(new TextComponentTranslation("commands.msg.NoMode"));
	 	    	break;
	 	   }
 	    }
	}
}
