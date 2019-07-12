package com.gildedgames.aether.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class GuiFactoryAether implements IModGuiFactory
{

	@Override
	public void initialize(final Minecraft minecraftInstance)
	{

	}

	@Override
	public boolean hasConfigGui()
	{
		return true;
	}

	@Override
	public Screen createConfigGui(final Screen parentScreen)
	{
		return new GuiConfigAether(parentScreen);
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
	{
		return null;
	}

}
