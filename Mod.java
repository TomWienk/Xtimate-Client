package xtimate.mod;

import net.minecraft.client.Minecraft;
import xtimate.Xtimate;

public class Mod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public String name, description;
	public boolean enabled;
	public Category category;
	
	public Mod(String description, String name, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		
		this.enabled = true;
	}
	
	public void onEnable() {
		Xtimate.INSTANCE.eventManager.register(this);

	}
	
	public void onDisable() {
		Xtimate.INSTANCE.eventManager.unregister(this);

	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Category getCategory() {
		return category;
	}

	public void toggle() {
		setEnabled(!this.enabled);
	}
}
