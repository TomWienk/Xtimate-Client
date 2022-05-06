package xtimate.hud.mod;

import java.util.ArrayList;

import xtimate.hud.mod.impl.FPSMod;
import xtimate.hud.mod.impl.TargetHUD;
import xtimate.hud.mod.impl.TargetHUD;
import xtimate.hud.mod.impl.TestMod;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public HudManager() {
		
		hudMods.add(new FPSMod());
		hudMods.add(new TargetHUD());
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			m.draw();
		}
	}

}
