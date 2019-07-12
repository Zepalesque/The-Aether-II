package com.gildedgames.aether.common.recipes.altar;

import com.gildedgames.aether.api.recipes.altar.IAltarRecipe;
import com.gildedgames.aether.common.init.MaterialsAether;
import com.gildedgames.aether.common.items.weapons.swords.ItemAetherSword;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ToolItem;

public class AltarRepairRecipe implements IAltarRecipe
{
	@Override
	public boolean matchesInput(final ItemStack stack)
	{
		return (stack.getItem() instanceof ItemSword || stack.getItem() instanceof ToolItem || stack.getItem() instanceof ItemArmor)
				&& stack.isItemDamaged();
	}

	@Override
	public boolean matchesOutput(ItemStack stack)
	{
		return false;
	}

	@Override
	public int getAmbrosiumCost(final ItemStack stack)
	{
		if (stack.getItem() instanceof ItemAetherSword)
		{
			return 6;
		}
		else if (stack.getItem() instanceof ToolItem)
		{
			final ToolItem tool = (ToolItem) stack.getItem();

			switch (tool.getToolMaterialName())
			{
				case "WOOD":
					return 2;
				case "STONE":
					return 3;
				case "IRON":
					return 4;
				case "DIAMOND":
					return 5;
				case "GOLD":
					return 3;
			}
		}
		else if (stack.getItem() instanceof ItemArmor)
		{
			final ItemArmor armor = (ItemArmor) stack.getItem();

			switch (armor.getArmorMaterial())
			{
				case LEATHER:
					return 2;
				case IRON:
					return 3;
				case GOLD:
				case CHAIN:
					return 3;
				case DIAMOND:
					return 5;
			}

			if (armor.getArmorMaterial() == MaterialsAether.LEGENDARY_ARMOR || armor.getArmorMaterial() == MaterialsAether.VALKYRIE_ARMOR)
			{
				return 6;
			}
		}

		return 5;
	}

	@Override
	public ItemStack getOutput(final ItemStack stack)
	{
		stack.setItemDamage(0);

		return stack;
	}

	@Override
	public ItemStack getInput()
	{
		return null;
	}
}
