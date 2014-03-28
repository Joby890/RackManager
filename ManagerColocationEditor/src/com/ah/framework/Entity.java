package com.ah.framework;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	private String uuid = UUID.randomUUID().toString();
	private Scene game;
	
	public Entity(Scene game) {
		this.game = game;
	}
	
	public Entity() {
		//We allow for both..
	}
	
	public abstract void tick(Double delta);

	public abstract void render(SpriteBatch batch, Double delta);
	
	public abstract void onCreate();
	
	public abstract void onRemove();
	
	public abstract Texture getTexture();
	
	public abstract Vector2 getPostion();

	public String getId() {
		return uuid;
	}
	
	public Scene getGame() {
		return game;
	}
	
	public void setGame(Scene game) {
		if(game == null) {
			this.game = game;
		}
	}
	
	public boolean checkId(String id) {
		return getId().equals(id);
	}

}
