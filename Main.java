package me.tom.xtimate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import me.tom.xtimate.util.OSHelper;
import me.tom.xtimate.util.UnzipUtility;

public class Main {
	
	public static void main(String [] args) {
		launch();
	}
	
	public static void launch() {
		
		File minecraftDirectory = new File(OSHelper.getOS().getMc());
		File minecraftAssets = new File(minecraftDirectory.toString() + "assets");
		
		File natives = new File(System.getProperty("user.dir") + File.separator + "natives.zip");
		File libraries = new File(System.getProperty("user.dir") + File.separator + "libraries.zip");
		File jar = new File(System.getProperty("user.dir") + File.separator + "Xtimate.jar");
		
		try {
			FileUtils.copyURLToFile(new URL("https://github.com/TomWienk/Xtimate-Client/raw/main/natives.zip"), natives);
			FileUtils.copyURLToFile(new URL("https://github.com/TomWienk/Xtimate-Client/raw/main/Libraries.zip"), libraries);
			FileUtils.copyURLToFile(new URL("https://github.com/TomWienk/Xtimate-Client/raw/main/Xtimate.jar"), jar);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	
	UnzipUtility unzipper = new UnzipUtility();
	
	try {
		unzipper.unzip(natives.toString(), System.getProperty("user.dir") + File.separator + "natives.zip");
		natives.delete();
		
		unzipper.unzip(libraries.toString(), System.getProperty("user.dir") + File.separator + "libraries.zip");
		libraries.delete();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		
		Process process = Runtime.getRuntime().exec("java -"
				
				
				+ "Xms1024M "
				+ "-Xmx4096M "
				+ "-Djava.library.path=\"" + System.getProperty("user.dir") + File.separator + "natives" + "\" "
				+ "-cp \"" + System.getProperty("user.dir") + File.separator + "libraries" + File.separator + "*" + ";" + jar.toString() + "\" "
				+ "net.minecraft.client.main.Main "
				+ "--width 854 "
				+ "--height 480 "
				+ "--username Xtimateuser"
				+ "--version 1.8.8"
				+ "--gameDir " + minecraftDirectory.toString() + " "
				+ "--assetsDir " + minecraftAssets.toString() + " "
				+ "assetIndex 1.8.8 "
				+ "uuid N/A "
				+ "--accessToken aeef7bc935f9420eb6314dea7ad7e1e5 "
				+ "--userType mojang");
		
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		String s = null;
		while((s = stdInput.readLine()) != null) {
			System.out.println(s);
		} 
		while((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
		
	} catch (Exception e) { 
		e.printStackTrace();
	}
	}
}
