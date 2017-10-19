package com.gildedgames.orbis.client.gui.util;

import com.gildedgames.orbis.client.util.rect.Rect;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiTexture extends GuiAdvanced
{
	private final ResourceLocation texture;

	public GuiTexture(final Rect rect, final ResourceLocation texture)
	{
		super(rect);

		this.texture = texture;
	}

	public ResourceLocation getResourceLocation()
	{
		return this.texture;
	}

	@Override
	public void init()
	{

	}

	@Override
	public void draw()
	{
		GlStateManager.pushMatrix();

		this.mc.getTextureManager().bindTexture(this.texture);

		Gui.drawModalRectWithCustomSizedTexture((int) this.dim().x(), (int) this.dim().y(), 0, 0, (int) this.dim().width(), (int) this.dim().height(),
				(int) this.dim().width(), (int) this.dim().height());

		GlStateManager.popMatrix();
	}
}