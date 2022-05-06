package xtimate.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import xtimate.hud.mod.HudMod;

public class FPSMod extends HudMod{

    public FPSMod() {
        super("FPS", 100, 100);
    }
    
    @Override
    public void draw() {
        Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0, 170).getRGB());
        fr.drawStringWithShadow("FPS " + mc.getDebugFPS(), getX(), getY(), -1);
        super.draw();
    }
    
    @Override
    public void renderDummy(int mouseX, int mouseY) {
       fr.drawString("FPS " + mc.getDebugFPS(), getX(), getY(), -1);
        
        super.renderDummy(mouseX, mouseY);
    }
    
    @Override
    public int getWidth() {
        return super.getWidth();
    }
    
    @Override
    public int getHeight() {
        return super.getHeight();
    }

}