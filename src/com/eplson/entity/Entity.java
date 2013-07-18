package com.eplson.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.epslon.engine.World;

public abstract class Entity {

	protected int x, y, w, h, dx, dy;

	protected World world;

	public Entity(int x, int y, World world) {
		this.x = x;
		this.y = y;
		this.world = world;
		dx = 0;
		dy = 0;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, int delta) throws SlickException {
		x += dx;
		y += dy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
}
