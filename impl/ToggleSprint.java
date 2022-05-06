package xtimate.mod.impl;

import xtimate.event.EventTarget;
import xtimate.event.impl.EventUpdate;
import xtimate.mod.Category;
import xtimate.mod.Mod;

public class ToggleSprint extends Mod {

	public ToggleSprint() {
		super("ToggleSprint", "Toggle your sprinting status", Category.Misc);
		
	}
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isEnabled() && !mc.thePlayer.isBlocking()) {
			mc.thePlayer.setSprinting(true);
		}

	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSprinting(false);
	}
	
}
