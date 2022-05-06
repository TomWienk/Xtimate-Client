package xtimate;

import net.minecraft.client.Minecraft;
import xtimate.event.EventManager;
import xtimate.event.EventTarget;
import xtimate.event.impl.ClientTick;
import xtimate.hud.HUDConfigScreen;
import xtimate.hud.mod.HudManager;
import xtimate.mod.ModManager;
import xtimate.util.SessionChanger;

public class Xtimate {

	public String NAME = "Xtimate", VERSION = "1.0.0", AUTHOR = "Xtimate", NAMEVER = NAME + " " + VERSION;
	public static Xtimate INSTANCE = new Xtimate();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public ModManager modManager;
	public HudManager hudManager;
	
	public void startup() {
		eventManager = new EventManager();
		modManager = new ModManager();
		hudManager = new HudManager();
		
		SessionChanger.getInstance().setUserOffline("Xtimate");
		
		System.out.println("Starting " + NAMEVER + " by " + AUTHOR);
	
		eventManager.register(this);

		
		
	}
	public void shutdown() {
		System.out.println("Shutting Down " + NAMEVER);
		
		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.TEST_MOD.isPressed()) {
			modManager.testMod.toggle();
		}
		if(mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(mc.gameSettings.keyBindSprint.isPressed()) {
			modManager.toggleSprint.toggle();
		}
	}
	
}
