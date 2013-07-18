package com.epslon.state;

import java.io.IOException;

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

import com.epslon.engine.Epslon;
import com.epslon.file.SettingsFile;

public class OptionsState extends BasicGameState {

	int stateID = -1;

	int w = Epslon.WIDTH;
	int h = Epslon.HEIGHT;
	float s = Epslon.SCALE;

	public static boolean fullToggle = false;
	public static int resPos = 2;

	public static Image back = null;
	public static Image full = null;
	public static Image res = null;

	public OptionsState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		back = new Image("gfx/options_menu/back.png");
		full = new Image("gfx/options_menu/full.png");
		res = new Image("gfx/options_menu/res_2.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// Background
		g.setColor(Color.white);
		g.fillRect(0, 0, w * s, h * s);
		// Background

		back.draw((w / 2 - back.getWidth() / 2) * s, 50 * s, s);
		full.draw((w / 2 - full.getWidth() / 2) * s, (back.getHeight() + 50)
				* s, s);
		res.draw((w / 2 - res.getWidth() / 2) * s,
				(back.getHeight() + full.getHeight() + 50) * s, s);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		int mX = input.getMouseX();
		int mY = input.getMouseY();

		if (mouseHover(mX, mY, (w / 2 - back.getWidth() / 2) * s, 50 * s,
				back.getHeight() * s, back.getWidth() * s)) {
			back = new Image("gfx/options_menu/back_hover.png");
			if (input.isMousePressed(0)) {
				sbg.enterState(Epslon.MAINMENUSTATE, new FadeOutTransition(),
						new FadeInTransition());
			}
		} else {
			back = new Image("gfx/options_menu/back.png");
		}
		if (mouseHover(mX, mY, (w / 2 - full.getWidth() / 2) * s,
				(back.getHeight() + 50) * s, full.getHeight() * s,
				full.getWidth() * s)) {
			if (input.isMousePressed(0)) {
				try {
					fullChange();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (mouseHover(mX, mY, (w / 2 - res.getWidth() / 2) * s,
				(back.getHeight() + full.getHeight() + 50) * s, res.getHeight()
						* s, (res.getWidth() / 2) * s)) {
			if (input.isMousePressed(0)) {
				try {
					resChange(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (mouseHover(mX, mY, (w / 2 - res.getWidth() / 2)
				+ (res.getWidth() / 2) * s,
				(back.getHeight() + full.getHeight() + 50) * s, res.getHeight()
						* s, (res.getWidth() / 2) * s)) {
			if (input.isMousePressed(0)) {
				try {
					resChange(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (fullToggle == true) {
			gc.setFullscreen(true);
		} else {
			gc.setFullscreen(false);
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

	public static void fullChange() throws SlickException, IOException {
		if (fullToggle) {
			fullToggle = false;
			full = new Image("gfx/options_menu/full.png");
		} else {
			fullToggle = true;
			full = new Image("gfx/options_menu/full_check.png");
		}
		SettingsFile.save();
	}

	public static void resChange(boolean isLeft) throws SlickException,
			IOException {
		if (isLeft) {
			if (resPos >= 2 && resPos <= 5) {
				resPos--;
			}
		} else {
			if (resPos >= 1 && resPos <= 4) {
				resPos++;
			}
		}
		res = new Image("gfx/options_menu/res_" + resPos + ".png");
		SettingsFile.save();
	}
}
