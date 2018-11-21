package edu.isb14.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import edu.isb14.game.GameScreen;
import edu.isb14.game.SunsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SUNs game";	// Заголовок окна
//		config.useGL20 = true;
		config.addIcon("Wa_icon_32.png", Files.FileType.Internal);	// 1 параметр - ссылка на изображение 32х32, 2 параметр - не знаю
		config.width = SunsGame.CONFIG_WIDTH;	// ширина окна
		config.height = SunsGame.CONFIG_HEIGHT; // высота окна
		new LwjglApplication(new SunsGame(), config);
	}
}

