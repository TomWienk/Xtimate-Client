package xtimate.mod.impl;

import xtimate.mod.Category;
import xtimate.mod.Mod;

public class FPSMod extends Mod {

	public FPSMod() {
		super("TestMod", "Test Mod", Category.Misc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("THIS MOD IS ONNNNNNNN");
		
	}
	
}
