package com.xenon.state;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import com.xenon.engine.Xenon;
import com.xenon.engine.World;
import com.xenon.entity.Player;

/**
 * Project Xenon
 * 
 * PlayState
 * 
 * @author ThorniestXxMason
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PlayState extends BasicGameState {

	int stateID = -1;

	int w = Xenon.WIDTH;
	int h = Xenon.HEIGHT;
	float s = Xenon.SCALE;

	Image map;
	World world;
	SpriteSheet playerSheet;
	Animation playerAnimation;

	public PlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		map = new Image("gfx/world/map.png");
		world = new World(3200, 3200);

		playerSheet = new SpriteSheet("gfx/world/player_sprites.png", 64, 64);
		playerAnimation = new Animation(playerSheet, 200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.draw(0, 0);
		world.render(gc, g);

		playerAnimation.draw(100, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		playerAnimation.update(delta);
		world.update(gc, delta);
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
