package com.gildedgames.aether.client;

import com.gildedgames.aether.api.AetherAPI;
import com.gildedgames.aether.api.entity.IMount;
import com.gildedgames.aether.api.entity.IMountProcessor;
import com.gildedgames.aether.api.items.IItemProperties;
import com.gildedgames.aether.api.items.ItemRarity;
import com.gildedgames.aether.api.items.equipment.ItemEquipmentSlot;
import com.gildedgames.aether.api.items.equipment.effects.EffectInstance;
import com.gildedgames.aether.api.items.equipment.effects.IEffectFactory;
import com.gildedgames.aether.api.items.equipment.effects.IEffectPool;
import com.gildedgames.aether.api.items.equipment.effects.IEffectProvider;
import com.gildedgames.aether.client.gui.GuiUtils;
import com.gildedgames.aether.client.gui.PerformanceIngame;
import com.gildedgames.aether.client.gui.misc.BlackScreenRenderer;
import com.gildedgames.aether.client.gui.misc.GuiBlackScreen;
import com.gildedgames.aether.client.sound.AetherMusicManager;
import com.gildedgames.aether.common.capabilities.entity.player.PlayerAether;
import com.gildedgames.aether.common.containers.slots.SlotAmbrosium;
import com.gildedgames.aether.common.containers.slots.SlotEquipment;
import com.gildedgames.aether.common.containers.slots.SlotFlintAndSteel;
import com.gildedgames.aether.common.containers.slots.SlotMoaEgg;
import com.gildedgames.aether.common.entities.util.mounts.FlyingMount;
import com.gildedgames.aether.common.network.NetworkingAether;
import com.gildedgames.aether.common.network.packets.PacketSpecialMovement;
import com.gildedgames.aether.common.registry.content.DimensionsAether;
import com.gildedgames.aether.common.registry.content.SoundsAether;
import com.gildedgames.orbis.client.gui.util.GuiFrameUtils;
import com.gildedgames.orbis.common.util.InputHelper;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEventHandler
{
	private static final PerformanceIngame PERFORMANCE_LOGGER = new PerformanceIngame();

	public static boolean DRAW_BLACK_SCREEN = false;

	private static boolean DRAWING_BLACK_FADE = false;

	private static double TIME_STARTED_FADE = -1;

	private static boolean PREV_JUMP_BIND_STATE;

	private static Minecraft mc = Minecraft.getMinecraft();

	public static void drawBlackFade()
	{
		DRAWING_BLACK_FADE = true;
	}

	@SubscribeEvent
	public static void onRenderGameOverlay(RenderGameOverlayEvent event)
	{
		if (mc.world != null)
		{
			if (mc.world.provider.getDimensionType() == DimensionsAether.AETHER || mc.world.provider.getDimensionType() == DimensionsAether.NECROMANCER_TOWER)
			{
				if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE)
				{
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event)
	{
		if (mc.world != null)
		{
			if (mc.world.provider.getDimensionType() == DimensionsAether.AETHER || mc.world.provider.getDimensionType() == DimensionsAether.NECROMANCER_TOWER)
			{
				if (event.getType() == RenderGameOverlayEvent.ElementType.AIR || event.getType() == RenderGameOverlayEvent.ElementType.HEALTH
						|| event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.getType() == RenderGameOverlayEvent.ElementType.ARMOR
						|| event.getType() == RenderGameOverlayEvent.ElementType.FOOD)
				{
					GlStateManager.translate(0.0, 6D, 0.0);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event)
	{
		if (mc.world != null)
		{
			if (mc.world.provider.getDimensionType() == DimensionsAether.AETHER || mc.world.provider.getDimensionType() == DimensionsAether.NECROMANCER_TOWER)
			{
				if (event.getType() == RenderGameOverlayEvent.ElementType.AIR || event.getType() == RenderGameOverlayEvent.ElementType.HEALTH
						|| event.getType() == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.getType() == RenderGameOverlayEvent.ElementType.ARMOR
						|| event.getType() == RenderGameOverlayEvent.ElementType.FOOD)
				{
					GlStateManager.translate(0.0, -6D, 0.0);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onOpenGui(final GuiOpenEvent event)
	{
		if (DRAW_BLACK_SCREEN && event.getGui() instanceof GuiDownloadTerrain)
		{
			event.setGui(new GuiBlackScreen());
		}
	}

	private static double getSecondsSinceStart()
	{
		return (System.currentTimeMillis() - TIME_STARTED_FADE) / 1000.0D;
	}

	@SubscribeEvent
	public static void onRenderTick(final TickEvent.RenderTickEvent event)
	{
		if (event.phase == TickEvent.Phase.END)
		{
			if (DRAW_BLACK_SCREEN)
			{
				GlStateManager.pushMatrix();

				GlStateManager.disableDepth();

				GuiUtils.drawGradientRect(0, 0, (int) InputHelper.getScreenWidth(), (int) InputHelper.getScreenHeight(), 0xFF000000, 0xFF000000);

				GlStateManager.enableDepth();

				GlStateManager.popMatrix();
			}

			if (DRAWING_BLACK_FADE)
			{
				if (TIME_STARTED_FADE == -1)
				{
					TIME_STARTED_FADE = System.currentTimeMillis();
				}

				final float bgAlpha = Math.max(0.0F, 1.0F - (float) (getSecondsSinceStart() / 10.0D));

				final int bg = GuiFrameUtils.changeAlpha(0xFF000000, (int) (bgAlpha * 255));

				GlStateManager.pushMatrix();

				GlStateManager.disableDepth();

				GuiUtils.drawGradientRect(0, 0, (int) InputHelper.getScreenWidth(), (int) InputHelper.getScreenHeight(), bg, bg);

				GlStateManager.enableDepth();

				GlStateManager.popMatrix();

				if (getSecondsSinceStart() >= 10.0D)
				{
					DRAWING_BLACK_FADE = false;
					TIME_STARTED_FADE = -1;
				}
			}
		}
	}

	@SubscribeEvent
	public static void onTick(final ClientTickEvent event)
	{
		if (event.phase == TickEvent.Phase.END)
		{
			if (Minecraft.getMinecraft().loadingScreen.getClass() == LoadingScreenRenderer.class)
			{
				Minecraft.getMinecraft().loadingScreen = new BlackScreenRenderer(Minecraft.getMinecraft(), Minecraft.getMinecraft().loadingScreen);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void onRenderGui(final RenderGameOverlayEvent event)
	{
		final Minecraft mc = Minecraft.getMinecraft();

		final ScaledResolution scaledRes = new ScaledResolution(mc);

		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
		{
			if (mc.player.isRiding())
			{
				if (mc.player.getRidingEntity() instanceof IMount)
				{
					final IMount mount = (IMount) mc.player.getRidingEntity();
					final IMountProcessor processor = mount.getMountProcessor();

					if (processor instanceof FlyingMount)
					{
						final FlyingMount flyingMount = (FlyingMount) processor;

						mc.ingameGUI.drawCenteredString(mc.fontRenderer, String.valueOf((int) (flyingMount.getData().getRemainingAirborneTime())),
								scaledRes.getScaledWidth() / 2, scaledRes.getScaledHeight() - 30, 0xFFFFFF);
					}
				}
			}

			PERFORMANCE_LOGGER.renderIcon();
		}
	}

	@SubscribeEvent
	@SuppressWarnings("unchecked")
	public static void onTooltipConstruction(final ItemTooltipEvent event)
	{
		final IItemProperties properties = AetherAPI.content().items().getProperties(event.getItemStack().getItem());

		// Equipment Properties
		if (properties.getEquipmentSlot() != ItemEquipmentSlot.NONE)
		{
			final ItemEquipmentSlot slot = properties.getEquipmentSlot();

			// Equipment Effects
			for (final IEffectProvider provider : properties.getEffectProviders())
			{
				final IEffectFactory<IEffectProvider> factory = AetherAPI.content().effects().getFactory(provider.getFactory());

				final EffectPoolTemporary pool = new EffectPoolTemporary(event.getItemStack(), provider);
				factory.createInstance(pool).addInformation(event.getToolTip());
			}

			// Slot Type
			event.getToolTip().add("");
			event.getToolTip().add(I18n.format(slot.getUnlocalizedName()));
		}

		// Rarity
		if (properties.getRarity() != ItemRarity.NONE)
		{
			event.getToolTip().add(I18n.format(properties.getRarity().getUnlocalizedName()));
		}
	}

	@SubscribeEvent
	public static void onClientTick(final ClientTickEvent event)
	{
		if (event.phase != TickEvent.Phase.END)
		{
			return;
		}

		final Minecraft mc = FMLClientHandler.instance().getClient();

		final World world = FMLClientHandler.instance().getWorldClient();

		final EntityPlayerSP player = FMLClientHandler.instance().getClientPlayerEntity();

		if (world != null && player != null)
		{
			final PlayerAether aePlayer = PlayerAether.getPlayer(player);

			if (aePlayer != null)
			{
				if (aePlayer.getAbilitiesModule().getMidAirJumpsAllowed() > 0)
				{
					if (mc.gameSettings.keyBindJump.isKeyDown() && !PREV_JUMP_BIND_STATE)
					{
						if (!player.isInWater() && aePlayer.getAbilitiesModule().getTicksAirborne() > 2
								&& !player.capabilities.isCreativeMode)
						{
							if (aePlayer.getAbilitiesModule().performMidAirJump())
							{
								NetworkingAether.sendPacketToServer(new PacketSpecialMovement(PacketSpecialMovement.Action.EXTRA_JUMP));

								world.playSound(player.posX, player.posY, player.posZ, SoundsAether.generic_wing_flap, SoundCategory.PLAYERS, 0.4f,
										0.8f + (world.rand.nextFloat() * 0.6f), false);
							}
						}
					}
				}

				PREV_JUMP_BIND_STATE = mc.gameSettings.keyBindJump.isKeyDown();

				AetherMusicManager.INSTANCE.update(aePlayer);
			}
		}
	}

	@SubscribeEvent
	public static void onTextureStitchPre(final TextureStitchEvent.Pre event)
	{
		SlotEquipment.registerIcons(event);
		SlotAmbrosium.registerIcons(event);
		SlotMoaEgg.registerIcons(event);
		SlotFlintAndSteel.registerIcons(event);
	}

	private static class EffectPoolTemporary<T extends IEffectProvider> implements IEffectPool<T>
	{
		private final ItemStack stack;

		private final T provider;

		public EffectPoolTemporary(final ItemStack stack, final T provider)
		{
			this.stack = stack;
			this.provider = provider;
		}

		@Override
		public ItemStack getProvider(final IEffectProvider instance)
		{
			return this.provider == instance ? this.stack : ItemStack.EMPTY;
		}

		@Override
		public Collection<T> getActiveProviders()
		{
			return Collections.singleton(this.provider);
		}

		@Override
		public Optional<EffectInstance> getInstance()
		{
			return Optional.empty();
		}

		@Override
		public boolean isEmpty()
		{
			return false;
		}
	}

}
