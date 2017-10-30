package com.gildedgames.orbis.common;

import com.gildedgames.aether.api.orbis.IWorldObjectManagerProvider;
import com.gildedgames.aether.api.orbis.management.IProjectManager;
import com.gildedgames.aether.common.capabilities.world.WorldObjectManagerProvider;
import com.gildedgames.aether.common.network.NetworkingAether;
import com.gildedgames.orbis.common.data.management.OrbisProjectManager;
import com.gildedgames.orbis.common.network.packets.projects.PacketSendProjectListing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.io.File;
import java.io.IOException;

public class OrbisCore
{

	private static final GameRegistrar GAME_REGISTRAR = new GameRegistrar();

	private static IProjectManager projectManager;

	private static IWorldObjectManagerProvider worldObjectManagerProvider;

	@SubscribeEvent
	public static void onPlayerLogin(final PlayerEvent.PlayerLoggedInEvent event)
	{
		/**
		 * Will only send if the server is a dedicated server.
		 * This ensures that on singleplayer, the client uses the same
		 * directory/data as the integrated server (instead of having to
		 * "download" data from the integrated server).
		 */
		if (isServer() && event.player.getServer() != null && event.player.getServer().isDedicatedServer())
		{
			NetworkingAether.sendPacketToPlayer(new PacketSendProjectListing(), (EntityPlayerMP) event.player);
		}
	}

	public static void startWorldObjectManagerProvider()
	{
		if (worldObjectManagerProvider != null)
		{
			return;
		}

		try
		{
			worldObjectManagerProvider = new WorldObjectManagerProvider(new File(DimensionManager.getCurrentSaveRootDirectory(), "/data/orbis/"));
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		if (isServer())
		{
			worldObjectManagerProvider.read();
		}
	}

	public static void stopWorldObjectManagerProvider()
	{
		if (worldObjectManagerProvider != null)
		{
			worldObjectManagerProvider.write();
			worldObjectManagerProvider = null;
		}
	}

	public static IWorldObjectManagerProvider getWorldObjectManagerProvider()
	{
		if (worldObjectManagerProvider == null)
		{
			startWorldObjectManagerProvider();
		}

		return worldObjectManagerProvider;
	}

	public static void startProjectManager()
	{
		if (projectManager != null)
		{
			return;
		}

		if (isClient())
		{
			final ServerData data = Minecraft.getMinecraft().getCurrentServerData();

			if (data != null)
			{
				projectManager = new OrbisProjectManager(
						new File(Minecraft.getMinecraft().mcDataDir, "/orbis/servers/" + data.serverIP.replace(":", "_") + "/projects/"));
			}
		}

		if (projectManager == null)
		{
			projectManager = new OrbisProjectManager(new File(Minecraft.getMinecraft().mcDataDir, "/orbis/local/projects/"));
		}

		projectManager.scanAndCacheProjects();
	}

	public static void stopProjectManager()
	{
		if (projectManager != null)
		{
			projectManager.flushProjects();
			projectManager = null;
		}
	}

	public static IProjectManager getProjectManager()
	{
		if (projectManager == null)
		{
			startProjectManager();
		}

		return projectManager;
	}

	public static boolean isClient()
	{
		return FMLCommonHandler.instance().getSide().isClient();
	}

	public static boolean isServer()
	{
		return FMLCommonHandler.instance().getSide().isServer();
	}

	public static GameRegistrar getRegistrar()
	{
		return OrbisCore.GAME_REGISTRAR;
	}

	public static void onServerStopping(final FMLServerStoppingEvent event)
	{
		stopProjectManager();
		stopWorldObjectManagerProvider();
	}

	public static void onServerStarted(final FMLServerStartedEvent event)
	{
		startWorldObjectManagerProvider();
		startProjectManager();
	}
}
