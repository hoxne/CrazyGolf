package nl.dke13.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import nl.dke13.screens.CrazyGolf;
import nl.dke13.screens.MainMenu;
import nl.dke13.screens.MenuScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new CrazyGolf(), config);
		new LwjglApplication(new MainMenu(), config);
		//new LwjglApplication(new MenuScreen(null), config);
	}
}