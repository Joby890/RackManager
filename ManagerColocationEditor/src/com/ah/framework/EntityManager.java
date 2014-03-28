package com.ah.framework;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface EntityManager {

	
	public Entity getEntityById(String id);
	
	public Entity[] getEntityWithGame(Scene game);
	
	public Entity[] getEntityWithClass(Class<?> clazz);
	
	public Entity removeEntity(Entity entity);
	
	public Entity addEntity(Entity entity);
	
	public void tick(Double delta);
	
	public void render(SpriteBatch batch, Double delta);
	
	public void closing();
	
	public void starting();
	
	
	
}
