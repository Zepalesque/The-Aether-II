package com.gildedgames.aether.common.entities.animals;

import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.entities.ai.EntityAIForcedWander;
import com.gildedgames.aether.common.entities.flying.EntityFlying;
import com.gildedgames.aether.common.entities.flying.PathNavigateFlyer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAerwhale extends EntityFlying
{

	public EntityAerwhale(final World world)
	{
		super(world);

		this.setSize(3.0F, 3.0F);
	}

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();

		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(250);
	}

	@Override
	protected PathNavigator createNavigator(final World worldIn)
	{
		PathNavigateFlyer navigateFlyer = new PathNavigateFlyer(this, worldIn);

		navigateFlyer.setAvoidGround(true);

		return navigateFlyer;
	}

	@Override
	protected void registerGoals()
	{
		final MoveTowardsRestrictionGoal moveTowardsRestriction = new MoveTowardsRestrictionGoal(this, 0.4D);
		final EntityAIForcedWander wander = new EntityAIForcedWander(this, 0.4D, 10, 12, 7);

		wander.setMutexBits(3);
		moveTowardsRestriction.setMutexBits(3);

		this.goalSelector.addGoal(1, moveTowardsRestriction);
		this.goalSelector.addGoal(2, wander);
	}

	@Override
	public int getTalkInterval()
	{
		return 2000;
	}

	@Override
	protected float getSoundVolume()
	{
		return 10.0F;
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return new SoundEvent(AetherCore.getResource("mob.aerwhale.ambient"));
	}

	@Override
	protected SoundEvent getHurtSound(final DamageSource src)
	{
		return new SoundEvent(AetherCore.getResource("mob.aerwhale.ambient"));
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return new SoundEvent(AetherCore.getResource("mob.aerwhale.death"));
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}
}
