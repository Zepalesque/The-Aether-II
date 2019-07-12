package com.gildedgames.aether.common.items.armor;

import com.gildedgames.aether.common.AetherCore;
import com.gildedgames.aether.common.capabilities.entity.player.PlayerAether;
import com.gildedgames.aether.common.capabilities.entity.player.modules.PlayerPatronRewardModule;
import com.gildedgames.aether.common.init.CreativeTabsAether;
import com.gildedgames.aether.common.patron.armor.PatronRewardArmor;
import com.gildedgames.aether.common.util.helpers.EntityUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class ItemAetherGloves extends Item
{
	private final GloveType gloveType;

	public ItemAetherGloves(GloveType type)
	{
		this.gloveType = type;

		this.setMaxStackSize(1);

		this.setCreativeTab(CreativeTabsAether.TAB_ARMOR);
	}

	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getGloveTexture(PlayerEntity player)
	{
		String skinType = EntityUtil.getSkin(player);

		boolean slim = skinType.equals("slim");

		PlayerAether playerAether = PlayerAether.getPlayer(player);

		PatronRewardArmor armorChoice = playerAether.getModule(PlayerPatronRewardModule.class).getChoices().getArmorChoice();

		if (armorChoice != null)
		{
			return armorChoice.getArmorGloveTexture(slim);
		}

		return slim ? this.gloveType.getTextureSlim() : this.gloveType.getTexture();
	}

	public enum GloveType
	{
		TAEGOREHIDE("taegore_hide_gloves"),
		ZANITE("zanite_gloves"),
		ARKENIUM("arkenium_gloves"),
		GRAVITITE("gravitite_gloves"),
		VALKYRIE("valkyrie_gloves"),
		NEPTUNE("neptune_gloves"),
		PHOENIX("phoenix_gloves"),
		OBSIDIAN("obsidian_gloves");

		private final ResourceLocation texture, textureSlim;

		GloveType(String texture)
		{
			this.texture = AetherCore.getResource("textures/armor/" + texture + ".png");
			this.textureSlim = AetherCore.getResource("textures/armor/" + texture + "_slim.png");
		}

		public ResourceLocation getTextureSlim()
		{
			return this.textureSlim;
		}

		public ResourceLocation getTexture()
		{
			return this.texture;
		}
	}
}
