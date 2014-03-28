package com.ah.framework;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BackRound {
	
	private Texture texture;
	private Vector2 vec;

	public BackRound(String texture, Vector2 vec) {
		this.texture = new Texture(texture);
		this.vec = vec;
	}

	public float getY() {
		return vec.y;
	}

	public float getX() {
		return vec.x;
	}

	public Texture getTexture() {
		return texture;
	}
	
	public void setY(float f) {
		this.vec.y = f;
	}
	
	public void setX(float f) {
		this.vec.x = f;
	}
	
	

}
