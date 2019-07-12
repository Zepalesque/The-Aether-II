package com.gildedgames.aether.common.network.packets;

import com.gildedgames.aether.common.capabilities.entity.player.PlayerAether;
import com.gildedgames.aether.common.capabilities.entity.player.modules.PlayerProgressModule;
import com.gildedgames.aether.common.network.MessageHandlerClient;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketProgressModule implements IMessage
{

	private PlayerProgressModule module;

	private CompoundNBT tag;

	public PacketProgressModule()
	{

	}

	public PacketProgressModule(PlayerProgressModule module)
	{
		this.module = module;
	}

	@Override
	public void fromBytes(final ByteBuf buf)
	{
		this.tag = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(final ByteBuf buf)
	{
		CompoundNBT tag = new CompoundNBT();

		this.module.write(tag);

		ByteBufUtils.writeTag(buf, tag);
	}

	public static class HandlerClient extends MessageHandlerClient<PacketProgressModule, IMessage>
	{
		@Override
		public IMessage onMessage(final PacketProgressModule message, final PlayerEntity player)
		{
			if (player == null || player.world == null)
			{
				return null;
			}

			final PlayerAether playerAether = PlayerAether.getPlayer(player);
			playerAether.getModule(PlayerProgressModule.class).read(message.tag);

			return null;
		}
	}
}
