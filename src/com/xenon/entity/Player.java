package com.xenon.entity;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.xenon.engine.World;

/**
 * Project Xenon
 * 
 * Player
 * 
 * @author ThorniestXxMason
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Player extends Entity {

	Image image;

	public Player(int x, int y, World world) {
		super(x, y, world);
		w = 32;
		h = 32;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
		image = new Image("gfx/world/player.png");
		g.drawImage(image, x, y);
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);

		Input i = gc.getInput();

		if (i.isKeyDown(Keyboard.KEY_W)) {
			setDy(-2);
		} else if (i.isKeyDown(Keyboard.KEY_A)) {
			setDx(-2);
		} else if (i.isKeyDown(Keyboard.KEY_S)) {
			setDy(2);
		} else if (i.isKeyDown(Keyboard.KEY_D)) {
			setDx(2);
		} else {
			setDy(0);
			setDx(0);
		}
	}
}
