package fr.gagoi.conflict_of_pixels.core.screens;

import java.awt.Font;

import fr.gagoi.conflict_of_pixels.core.Game;
import fr.gagoi.pwal_graphics.display.Screen;
import fr.gagoi.pwal_graphics.display.elements.ActionListener;
import fr.gagoi.pwal_graphics.display.elements.Button;
import fr.gagoi.pwal_graphics.display.elements.Label;

@SuppressWarnings("serial")
public class MainMenuScreen extends Screen{
	
	private Label lbl_title, lbl_version;
	private Button but_options, but_play, but_shop, but_profil, but_quit;
	
	
	
	public MainMenuScreen(int width, int height, float scale) {
		super(width, height, scale);
		init();
	}
	
	private void init() {
		lbl_title = new Label(Game.getTranslationOf("lbl_title"), 400, 80);
		lbl_title.setFont(new Font("Perfect DOS VGA 437", 0, 50));
		
		lbl_version = new Label(Game.getTranslationOf("lbl_version") + Game.VERSION, 10, 680);
		
		but_options = new Button(Game.getTranslationOf("button_options"), 20, 250, 300, 45);
		but_options.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed() {
			}
		});
		
		but_play = new Button(Game.getTranslationOf("button_play"), 20, 200, 300, 45);
		but_shop = new Button(Game.getTranslationOf("button_shop"), 20, 300, 300, 45);
		but_profil = new Button(Game.getTranslationOf("button_profil"), 20, 350, 300, 45);
		but_quit = new Button(Game.getTranslationOf("button_quit"), 20, 400, 300, 45);
		
		
		
		addElement(lbl_title);
		addElement(lbl_version);
		addElement(but_options);
		addElement(but_play);
		addElement(but_profil);
		addElement(but_shop);
		addElement(but_quit);
		
	
	}

}
