package com.xenon.engine;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.xml.sax.SAXException;

import com.xenon.file.SettingsFile;
import com.xenon.state.MainMenuState;
import com.xenon.state.OptionsState;
import com.xenon.state.PlayState;

/**
 * Project Xenon
 * 
 * Xenon
 * 
 * @author ThorniestXxMason
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Xenon extends StateBasedGame {

	public static final String NAME = "Project Xenon";
	public static final int WIDTH = 1920;
	public static final int HEIGHT = (WIDTH / 16) * 9;
	public static float SCALE = 1f;

	public static final int MAINMENUSTATE = 0;
	public static final int OPTIONSSTATE = 1;
	public static final int PLAYSTATE = 2;

	public Xenon() {
		super(NAME);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new OptionsState(OPTIONSSTATE));
		this.addState(new PlayState(PLAYSTATE));
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Xenon());

		init();

		app.setDisplayMode((int) (WIDTH * SCALE), (int) (HEIGHT * SCALE), false);
		app.setFullscreen(OptionsState.fullToggle);
		app.setVSync(true);
		app.start();
	}

	public static void init() {
		try {
			SettingsFile.load();
		} catch (ClassNotFoundException | IOException
				| ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} finally {
			switch (OptionsState.resPos) {
			case 1:
				SCALE = 0.5F;
				break;
			case 2:
				SCALE = 0.667F;
				break;
			case 3:
				SCALE = 0.7119F;
				break;
			case 4:
				SCALE = 0.8334F;
				break;
			case 5:
				SCALE = 1.0F;
				break;
			}
		}
	}
}
