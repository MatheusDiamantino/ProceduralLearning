package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ProceduralHorror;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Procedural Horror Learning";
		config.height = 480;
		config.width = 800;
		config.vSyncEnabled = true;
		
		new LwjglApplication(new ProceduralHorror(), config);
	}
}
