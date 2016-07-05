package net.qyyh.loader;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.qyyh.block.BlockBaseDirt;
import net.qyyh.block.BlockBaseGrass;
import net.qyyh.block.BlockBaseSnow;
import net.qyyh.block.BlockBaseStone;
import net.qyyh.block.BlockBaseTile;
import net.qyyh.other.StringConversion;

public class BlockLoader {
	
    public static Block blockA = new BlockBaseStone();
    public static Block blackBrick = new BlockBaseStone();
    public static Block blueBrick= new BlockBaseStone();
    public static Block greyBrick= new BlockBaseStone();
    public static Block darkGreyBrick= new BlockBaseStone();
    public static Block bigRedBrick = new BlockBaseStone();
    public static Block smallRedBrick = new BlockBaseStone();
    public static Block whiteBrick = new BlockBaseStone();
    
    public static Block bell =new BlockBaseSnow();
    public static Block santaClaus =new BlockBaseSnow();
    public static Block sonwman =new BlockBaseSnow();
    public static Block snowflake1 =new BlockBaseSnow();
    public static Block snowflake2 =new BlockBaseSnow();
    public static Block snowflake3 =new BlockBaseSnow();
    public static Block snowflake4 =new BlockBaseSnow();
    public static Block snowflake5 =new BlockBaseSnow();
    public static Block snowflake6 =new BlockBaseSnow();
    
    public static Block tileA =new BlockBaseTile();
    public static Block tileB =new BlockBaseTile();
    public static Block tileC =new BlockBaseTile();
    public static Block tileD =new BlockBaseTile();
    public static Block tileE =new BlockBaseTile();
    public static Block tileF =new BlockBaseTile();
    public static Block tileG =new BlockBaseTile();
    public static Block tileH =new BlockBaseTile();
    public static Block tileI =new BlockBaseTile();
    public static Block tileJ =new BlockBaseTile();
    public static Block tileK =new BlockBaseTile();
    public static Block tileL =new BlockBaseTile();
    public static Block tileM =new BlockBaseTile();
    public static Block tileN =new BlockBaseTile();
    public static Block tileO =new BlockBaseTile();
    public static Block tileP =new BlockBaseTile();
    public static Block tileQ =new BlockBaseTile();
    
    public static Block tileModel = new BlockBaseDirt();
    public static Block strawMat= new BlockBaseGrass();
    
    public BlockLoader(FMLPreInitializationEvent event){
        register(blockA,"block_a");
        register(blackBrick,"black_brick");
        register(blueBrick,"blue_brick");
        register(greyBrick,"grey_brick");
        register(darkGreyBrick,"dark_grey_brick");
        register(bigRedBrick,"big_red_brick");
        register(smallRedBrick,"small_red_brick");
        register(whiteBrick,"white_brick");
        register(bell,"bell");
        register(santaClaus,"santa_claus");
        register(sonwman,"snowman");
        register(snowflake1,"snowflake1");
        register(snowflake2,"snowflake2");
        register(snowflake3,"snowflake3");
        register(snowflake4,"snowflake4");
        register(snowflake5,"snowflake5");
        register(snowflake6,"snowflake6");
        register(tileA,"tile_a");
        register(tileB,"tile_b");
        register(tileC,"tile_c");
        register(tileD,"tile_d");
        register(tileE,"tile_e");
        register(tileF,"tile_f");
        register(tileG,"tile_g");
        register(tileH,"tile_h");
        register(tileI,"tile_i");
        register(tileJ,"tile_j");
        register(tileK,"tile_k");
        register(tileL,"tile_l");
        register(tileM,"tile_m");
        register(tileN,"tile_n");
        register(tileO,"tile_o");
        register(tileP,"tile_p");
        register(tileQ,"tile_q");
        register(tileModel,"tile_model");
        register(strawMat,"straw_mat");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        registerRender(blockA);
        registerRender(blackBrick);
        registerRender(blueBrick);
        registerRender(greyBrick);
        registerRender(darkGreyBrick);
        registerRender(bigRedBrick);
        registerRender(smallRedBrick);
        registerRender(whiteBrick);
        registerRender(bell);
        registerRender(santaClaus);
        registerRender(sonwman);
        registerRender(snowflake1);
        registerRender(snowflake2);
        registerRender(snowflake3);
        registerRender(snowflake4);
        registerRender(snowflake5);
        registerRender(snowflake6);
        registerRender(tileA);
        registerRender(tileB);
        registerRender(tileC);
        registerRender(tileD);
        registerRender(tileE);
        registerRender(tileF);
        registerRender(tileG);
        registerRender(tileH);
        registerRender(tileI);
        registerRender(tileJ);
        registerRender(tileK);
        registerRender(tileL);
        registerRender(tileM);
        registerRender(tileN);
        registerRender(tileO);
        registerRender(tileP);
        registerRender(tileQ);
        registerRender(tileModel);
        registerRender(strawMat);
    }

    private static void register(Block block, String name){
    	block.setUnlocalizedName(StringConversion.to(name));
    	block.setRegistryName(name);
    	ItemBlock itemBlock = new ItemBlock(block);
    	itemBlock.setUnlocalizedName(StringConversion.to(name));
    	itemBlock.setRegistryName(name);
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}

