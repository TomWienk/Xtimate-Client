package xtimate.hud;

import net.minecraft.client.gui.GuiScreen;
import xtimate.Xtimate;
import xtimate.hud.mod.HudMod;

public class HUDConfigScreen extends GuiScreen {

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		for(HudMod m : Xtimate.INSTANCE.hudManager.hudMods) {
			m.renderDummy(mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}
