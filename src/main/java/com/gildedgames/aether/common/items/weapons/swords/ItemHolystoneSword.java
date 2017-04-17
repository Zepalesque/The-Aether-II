package com.gildedgames.aether.common.items.weapons.swords;

import com.gildedgames.aether.common.items.ItemAbilityType;
import com.gildedgames.aether.common.items.ItemsAether;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class ItemHolystoneSword extends ItemAetherSword
{
	public ItemHolystoneSword()
	{
		super(ToolMaterial.STONE, ItemAbilityType.PASSIVE);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		ItemHolystoneSword.trySpawnAmbrosium(stack, target, attacker);

		return super.hitEntity(stack, target, attacker);
	}

	public static void trySpawnAmbrosium(ItemStack stack, Entity target, EntityLivingBase attacker)
	{
		if (!target.world.isRemote && target.world.rand.nextInt(100) <= 3)
		{
			EntityItem entityItem = new EntityItem(target.world, target.posX, target.posY, target.posZ);
			entityItem.setEntityItemStack(new ItemStack(ItemsAether.ambrosium_shard, 1));

			target.world.spawnEntity(entityItem);
		}
	}
}
