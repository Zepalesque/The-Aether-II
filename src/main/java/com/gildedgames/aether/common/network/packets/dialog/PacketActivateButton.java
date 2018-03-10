package com.gildedgames.aether.common.network.packets.dialog;

import com.gildedgames.aether.api.dialog.IDialogButton;
import com.gildedgames.aether.api.player.IPlayerAether;
import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.capabilities.entity.player.PlayerAether;
import com.gildedgames.aether.common.network.MessageHandlerServer;
import com.google.common.base.Objects;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketActivateButton implements IMessage
{
	private String label;

	public PacketActivateButton()
	{
	}

	public PacketActivateButton(final String label)
	{
		this.label = label;
	}

	@Override
	public void fromBytes(final ByteBuf buf)
	{
		this.label = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(final ByteBuf buf)
	{
		ByteBufUtils.writeUTF8String(buf, this.label);
	}

	public static class HandlerServer extends MessageHandlerServer<PacketActivateButton, PacketActivateButton>
	{
		@Override
		public PacketActivateButton onMessage(final PacketActivateButton message, final EntityPlayer player)
		{
			AetherCore.LOGGER.info("Player requested server to activate dialog button {}", message.label);

			final IPlayerAether aePlayer = PlayerAether.getPlayer(player);

			IDialogButton found = null;

			for (final IDialogButton b : aePlayer.getDialogController().getCurrentNode().getButtons())
			{
				if (Objects.equal(message.label, b.getLabel()))
				{
					found = b;
					break;
				}
			}

			if (found != null)
			{
				aePlayer.getDialogController().activateButton(found);
			}

			return null;
		}
	}
}
