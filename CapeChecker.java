package xtimate.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {

	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("Xtimate")) {
			return true;
		}else if(entitylivingbaseIn.getName().equals("JumpShootLegoMan")) {
			return true;
		}
		
		
		
		else return false;
	}
	
}
