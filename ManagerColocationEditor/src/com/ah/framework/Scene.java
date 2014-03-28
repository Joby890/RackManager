package com.ah.framework;

import java.util.UUID;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {
	
	private final String uuid = UUID.randomUUID().toString();

	public abstract void start();
	
	public abstract void stop();
	
	public abstract void tick(double delta);
	
	public abstract String getName();
	
	
	public String getId() {
		return uuid ;
	}

	public abstract BackRound getBackRound();
	
	public abstract void render(SpriteBatch batch, Double delta);

	public boolean isRunning() {
		return Framework.getSceneManager().isSceneRunning(this);
	}

	public abstract void onSceneChange(Boolean bol);
	
	
	
}
