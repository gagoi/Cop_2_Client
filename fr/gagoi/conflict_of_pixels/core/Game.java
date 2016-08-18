package fr.gagoi.conflict_of_pixels.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.gagoi.conflict_of_pixels.core.screens.MainMenuScreen;
import fr.gagoi.pwal_graphics.display.Screen;
import fr.gagoi.pwal_graphics.display.Window;
import fr.gagoi.pwal_translate.io.TranslationLoader;
import fr.gagoi.pwal_translate.lang.TranslationFile;

public class Game implements Runnable {

	private Window display;
	public static final String PATH = "Z:/Conflict of Pixels/";
	public static String VERSION = "";
	private static Screen main_menu_screen, game_screen, loading_screen;

	public static final TranslationLoader TRANSLATION_LOADER = new TranslationLoader("Translation loader", PATH + "resources/langs/");
	private static TranslationFile translationFile;

	public Game() {
		pre_init();
		main_menu_screen = new MainMenuScreen(640, 360, 2);
		display = new Window(getTranslationOf("lbl_title"), 640, 360, 2);
		display.setScreen(main_menu_screen);
		post_init();
	}

	private void pre_init() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "version.ver"));
			VERSION = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TRANSLATION_LOADER.load();
		setLanguage("fr");
	}

	private void post_init() {
		display.addCustomFont(PATH + "resources/fonts/zekton rg.ttf");
		display.addCustomFont(PATH + "resources/fonts/Perfect DOS VGA 437.ttf");
	}

	@Override
	public void run() {
		while (true) {
			if (Window.getScreen() != null) Window.getScreen().render();
		}
	}

	public static void main(String args[]) {
		new Thread(new Game()).start();
	}

	public static void setLanguage(String key) {
		translationFile = new TranslationFile(key, PATH + "/resources/langs/");
	}

	public static String getTranslationOf(String key) {
		return translationFile.getTranslationOf(key, "ERROR - MISSING NAME");

	}
}
