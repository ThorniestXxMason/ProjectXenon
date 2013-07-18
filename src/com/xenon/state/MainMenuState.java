package com.xenon.state;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.xenon.engine.Xenon;

/**
 * Project Xenon
 * 
 * MainMenuState
 * 
 * @author ThorniestXxMason
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class MainMenuState extends BasicGameState {

	int stateID = -1;

	int w = Xenon.WIDTH;
	int h = Xenon.HEIGHT;
	float s = Xenon.SCALE;

	public static Image background = null;
	public static Image play = null;
	public static Image options = null;
	public static Image quit = null;

	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("gfx/main_menu/background.png");
		play = new Image("gfx/main_menu/play.png");
		options = new Image("gfx/main_menu/options.png");
		quit = new Image("gfx/main_menu/quit.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// Background
		g.setColor(Color.white);
		g.drawImage(background, 0, 0);
		// Background

		play.draw((w / 2 - play.getWidth() / 2) * s, 50 * s, s);
		options.draw((w / 2 - play.getWidth() / 2) * s, (play.getHeight() + 50)
				* s, s);
		quit.draw((w / 2 - play.getWidth() / 2) * s, (play.getHeight()
				+ options.getHeight() + 50)
				* s, s);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mX = input.getMouseX();
		int mY = input.getMouseY();

		if (mouseHover(mX, mY, (w / 2 - play.getWidth() / 2) * s, 50 * s,
				play.getHeight() * s, play.getWidth() * s)) {
			play = new Image("gfx/main_menu/play_hover.png");
			if (input.isMousePressed(0)) {
				sbg.enterState(Xenon.PLAYSTATE, new FadeOutTransition(),
						new FadeInTransition());
			}
		} else {
			play = new Image("gfx/main_menu/play.png");
		}
		if (mouseHover(mX, mY, (w / 2 - play.getWidth() / 2) * s,
				(play.getHeight() + 50) * s, play.getHeight() * s,
				play.getWidth() * s)) {
			options = new Image("gfx/main_menu/options_hover.png");
			if (input.isMousePressed(0)) {
				sbg.enterState(Xenon.OPTIONSSTATE, new FadeOutTransition(),
						new FadeInTransition());
			}
		} else {
			options = new Image("gfx/main_menu/options.png");
		}
		if (mouseHover(mX, mY, (w / 2 - play.getWidth() / 2) * s,
				(play.getHeight() + options.getHeight() + 50) * s,
				play.getHeight() * s, play.getWidth() * s)) {
			quit = new Image("gfx/main_menu/quit_hover.png");
			if (input.isMousePressed(0)) {
				System.exit(0);
			}
		} else {
			quit = new Image("gfx/main_menu/quit.png");

		}

	}

	@Override
	public int getID() {
		return stateID;
	}

	public boolean mouseHover(int mx, int my, float x, float y, float height,
			float width) {
		if ((mx >= x && mx <= x + width && my >= y && my <= y + height)) {
			return true;
		} else {
			return false;
		}
	}

}
