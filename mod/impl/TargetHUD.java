package xtimate.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import xtimate.hud.mod.HudMod;

public class TargetHUD extends HudMod{
	
	private EntityLivingBase target;

	public TargetHUD() {
		super("TargetHUD", 150, 150);
	}
	
	@Override
	public void draw() {
		target = (EntityLivingBase) mc.pointedEntity;
		renderTargetHud();
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		GuiInventory.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), new Color(0,0,0, 170).getRGB());
		fr.drawStringWithShadow(mc.thePlayer.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow((int) mc.thePlayer.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(mc.thePlayer.getName()) + 30, getY() + 30, 20, 50, 0, mc.thePlayer);
		
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		if(target != null)
			return fr.getStringWidth(target.getName() + 70);
		else
			return super.getWidth();
	}
	
	@Override
	public int getHeight() {
		if(target != null)
			return fr.FONT_HEIGHT * 2 + 15;
		else
			return super.getHeight();
	}
	
	private void renderTargetHud() {
		if(target != null) {
			fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
			fr.drawStringWithShadow((int) target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
			GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName()) + 25, getY() + 30, 20, 50, 0, target);
		}
	}

}