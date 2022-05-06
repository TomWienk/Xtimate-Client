package xtimate.ui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import xtimate.Xtimate;

public class XtimateMainMenu extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("Xtimate/main_menu.jpg"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		Gui.drawRect(0, 0, 225, this.height, new Color(170,170,170, 0).getRGB());
		GlStateManager.pushMatrix();
		GlStateManager.scale(3, 3, 1);
		this.drawCenteredString(fontRendererObj, Xtimate.INSTANCE.NAME, 36, height / 2 -207, -1);
		GlStateManager.popMatrix();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 10, height / 2 - 40, "Singleplayer"));
		this.buttonList.add(new GuiButton(2, 10, height / 2 - 15, "Multiplayer"));
		this.buttonList.add(new GuiButton(3, 10, height / 2 + 10, "Settings"));
		this.buttonList.add(new GuiButton(4, 10, height / 2 + 35, "Rage Quit"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		super.actionPerformed(button);
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if(button.id == 4) {
			mc.shutdown();
		}
		super.actionPerformed(button);
}
}