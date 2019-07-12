package com.gildedgames.aether.common.containers.overlays;

import com.gildedgames.aether.api.registry.tab.ITab;
import com.gildedgames.aether.api.registry.tab.ITabGroupHandler;
import com.gildedgames.aether.api.registry.tab.ITabRegistry;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.containers.overlays.tabs.TabBackpack;
import net.minecraft.client.gui.screen.Screen;

import java.util.HashMap;
import java.util.Map;

/**
 * This is used to implement Tab functionality within various {@link Screen} interfaces.
 * @author Brandon Pearce
 */
public class TabRegistry implements ITabRegistry
{
	private final ITabGroupHandler inventoryTabGroup = new TabGroupHandler();

	private final Map<Integer, ITabGroupHandler> registeredGroups = new HashMap<>();

	private final ITab backpackTab = new TabBackpack();

	private ITabGroupHandler activeGroup;

	public TabRegistry()
	{
		this.getInventoryGroup().registerServerTab(this.getBackpackTab());

		if (AetherCore.isClient())
		{
			this.getInventoryGroup().registerClientTab(new TabBackpack.Client());
		}

		this.registerGroup(this.inventoryTabGroup);
	}

	@Override
	public ITabGroupHandler getInventoryGroup()
	{
		return this.inventoryTabGroup;
	}

	@Override
	public ITab getBackpackTab()
	{
		return this.backpackTab;
	}

	@Override
	public Map<Integer, ITabGroupHandler> getRegisteredTabGroups()
	{
		return this.registeredGroups;
	}

	@Override
	public void registerGroup(ITabGroupHandler tabGroup)
	{
		this.getRegisteredTabGroups().put(this.getRegisteredTabGroups().size(), tabGroup);
	}

	@Override
	public ITabGroupHandler getActiveGroup()
	{
		return this.activeGroup;
	}

	@Override
	public void setActiveGroup(ITabGroupHandler activeGroup)
	{
		this.activeGroup = activeGroup;
	}
}
