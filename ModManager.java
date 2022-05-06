package xtimate.mod;

import java.util.ArrayList;

import xtimate.mod.impl.*;

public class ModManager {
	
	public TestMod testMod;
	public ToggleSprint toggleSprint;

	public ArrayList <Mod> nods;
	
	public ModManager() {
		nods = new ArrayList<>();
		
		//misc
		nods.add(testMod = new TestMod());
		nods.add(toggleSprint = new ToggleSprint());
	}
	

	
}
