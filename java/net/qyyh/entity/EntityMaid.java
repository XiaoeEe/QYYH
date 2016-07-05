package net.qyyh.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.qyyh.entity.ai.EntityAIStop;
import net.qyyh.loader.ItemLoader;
import net.qyyh.other.NBT;

public class EntityMaid extends EntityCow {
	public static final DataParameter<Integer> ICON_TYPE = EntityDataManager.<Integer>createKey(EntityMaid.class, DataSerializers.VARINT);
	public static final DataParameter<Boolean> IS_STOP = EntityDataManager.<Boolean>createKey(EntityMaid.class, DataSerializers.BOOLEAN);
	public EntityMaid(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.8F);
	}
	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIStop(this));
        this.tasks.addTask(2, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ItemLoader.catTeaser, false));
        this.tasks.addTask(4, new EntityAIWander(this, 1.1D,150));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }
    
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
	}
	@Override
	 public void onUpdate(){
		super.onUpdate();
		if(this.getHealth()!=this.getMaxHealth()){
			this.setHealth(this.getMaxHealth());
		}
	}
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand p_184645_2_, ItemStack stack) {
		if(stack != null){
			if (stack.getItem() == ItemLoader.catTeaser && player.isSneaking()){
				int b=this.getDataManager().get(ICON_TYPE);
				this.getDataManager().set(ICON_TYPE,(b+1)%5);
			} 
			else if(stack.getItem() == ItemLoader.catTeaser){
			    this.getDataManager().set(IS_STOP, !this.getDataManager().get(IS_STOP));
	        }
			else if(stack.getItem() != Items.bucket){
	            return super.processInteract(player, p_184645_2_, stack);
	        }
		}	
		else{
        	return super.processInteract(player, p_184645_2_, stack);
        }
		return true;
	}
	
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(ICON_TYPE, 0);
        this.getDataManager().register(IS_STOP, false);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound){
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("iconType", this.getDataManager().get(ICON_TYPE));
        tagCompound.setBoolean("isStop", this.getDataManager().get(IS_STOP));
        
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompound){
        super.readEntityFromNBT(tagCompound);
        this.getDataManager().set(ICON_TYPE, tagCompound.getInteger("iconType"));
        this.getDataManager().set(IS_STOP, tagCompound.getBoolean("isStop"));
    }
    
	@Override
    public boolean isBreedingItem(ItemStack stack)
    {
		return false;
    }
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.entity_cat_ambient;
	}

	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.entity_cat_hurt;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.entity_cat_death;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.entity_wolf_step, 0.15F, 1.0F);
	}
	
	@Override
	protected boolean canDropLoot() {
		return false;
	}
	
}
