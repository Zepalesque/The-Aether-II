package com.gildedgames.aether.common.items.armor;

import com.gildedgames.aether.api.registrar.BlocksAether;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGravititeArmor extends ItemAetherArmor
{
	public ItemGravititeArmor(EquipmentSlotType armorType)
	{
		super(ArmorMaterial.DIAMOND, "gravitite", armorType);
	}

	@Override
	public boolean getIsRepairable(ItemStack target, ItemStack stack)
	{
		return stack.getItem() == Item.getItemFromBlock(BlocksAether.gravitite_block);
	}
}
