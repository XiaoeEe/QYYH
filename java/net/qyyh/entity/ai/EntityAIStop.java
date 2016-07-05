package net.qyyh.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.qyyh.entity.EntityMaid;

public class EntityAIStop extends EntityAIBase{
	private final EntityMaid entity;
	
	public EntityAIStop(EntityMaid entity)
    {
        this.entity = entity;
    }
	
    @Override
    public boolean shouldExecute()
    {
        return entity.getDataManager().get(EntityMaid.IS_STOP);
//    	return false;
    }

    @Override
    public void updateTask()
    {
    	this.entity.getNavigator().clearPathEntity();
    }
}
