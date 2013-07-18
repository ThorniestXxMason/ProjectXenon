package com.xenon.engine;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.xenon.entity.Entity;
import com.xenon.entity.Player;

public class World {

	private int w, h;

	private List<Entity> entities = new ArrayList<Entity>();
	private Player player;

	public World(int w, int h) {
		this.w = w;
		this.h = h;
		init();
	}

	public void init() {
		player = new Player(64, 64, this);
		entities.add(player);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(gc, g);
		}
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(gc, delta);
		}
	}
}
