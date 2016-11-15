package com.gildedgames.aether.common.registry;

import com.gildedgames.aether.api.AetherAPI;
import com.gildedgames.aether.api.registry.simple_crafting.ISimpleRecipe;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.blocks.BlocksAether;
import com.gildedgames.aether.common.blocks.construction.BlockAetherPlanks;
import com.gildedgames.aether.common.blocks.containers.BlockAetherCraftingTable;
import com.gildedgames.aether.common.blocks.natural.BlockAercloud;
import com.gildedgames.aether.common.entities.blocks.EntityParachute;
import com.gildedgames.aether.common.items.ItemsAether;
import com.gildedgames.aether.common.items.tools.ItemSkyrootTool;
import com.gildedgames.aether.common.items.weapons.ItemDart;
import com.gildedgames.aether.common.items.weapons.ItemDartType;
import com.gildedgames.aether.common.recipes.simple.OreDictionaryRequirement;
import com.gildedgames.aether.common.recipes.simple.SimpleRecipe;
import com.gildedgames.aether.common.util.helpers.RecipeUtil;
import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class RecipesAether
{

	private static int nextId;

	private static boolean hasInit;

	private RecipesAether()
	{

	}

	public static void preInit()
	{
		if (hasInit)
		{
			return;
		}

		List<ISimpleRecipe> recipes = Lists.newArrayList();

		top: for (IRecipe recipe : CraftingManager.getInstance().getRecipeList())
		{
			if (recipe instanceof ShapedRecipes)
			{
				ShapedRecipes shaped = (ShapedRecipes)recipe;

				List<ItemStack> req = Lists.newArrayList();

				outer: for (ItemStack stack : shaped.recipeItems)
				{
					if (stack != null)
					{
						for (ItemStack reqStack : req)
						{
							if (RecipeUtil.areEqual(reqStack, stack))
							{
								reqStack.stackSize += stack.stackSize;
								continue outer;
							}
						}

						req.add(stack);
					}
				}

				SimpleRecipe simpleRecipe = new SimpleRecipe(shaped.getRecipeOutput(), req.toArray(new ItemStack[req.size()]));

				for (ISimpleRecipe r : recipes)
				{
					if (r.equals(simpleRecipe))
					{
						continue top;
					}
				}

				recipes.add(simpleRecipe);

				AetherAPI.crafting().registerRecipe(nextId++, simpleRecipe);
			}
			else if (recipe instanceof ShapelessRecipes)
			{
				ShapelessRecipes shapeless = (ShapelessRecipes) recipe;

				List<ItemStack> req = Lists.newArrayList();

				outer: for (ItemStack stack : shapeless.recipeItems)
				{
					if (stack != null)
					{
						for (ItemStack reqStack : req)
						{
							if (RecipeUtil.areEqual(reqStack, stack))
							{
								reqStack.stackSize += stack.stackSize;
								continue outer;
							}
						}

						req.add(stack);
					}
				}

				SimpleRecipe simpleRecipe = new SimpleRecipe(shapeless.getRecipeOutput(), req.toArray(new ItemStack[req.size()]));

				for (ISimpleRecipe r : recipes)
				{
					if (r.equals(simpleRecipe))
					{
						continue top;
					}
				}

				recipes.add(simpleRecipe);

				AetherAPI.crafting().registerRecipe(nextId++, simpleRecipe);
			}
		}

		AetherAPI.crafting().finalizeRecipes();

		hasInit = true;
	}

	private static void add(ItemStack result, Object... required)
	{
		AetherAPI.crafting().registerRecipe(nextId++, new SimpleRecipe(result, required));
	}

}
