package com.ah.framework.v1;

import java.util.ArrayList;
import java.util.List;

import com.ah.framework.Entity;
import com.ah.framework.Scene;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityManager implements com.ah.framework.EntityManager {
	
	private List<Entity> entitys = new ArrayList<Entity>();

	@Override
	public Entity getEntityById(String id) {
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(e.checkId(id)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Entity[] getEntityWithGame(Scene game) {
		if(game == null) {
			throw new IllegalArgumentException("Game can not be null");
		}
		List<Entity> entit = new ArrayList<Entity>();
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(game.getId().equals(game.getId())) {
				entit.add(e);
			}
		}
		return entit.toArray(new Entity[entit.size()]);
	}

	@Override
	public Entity removeEntity(Entity entity) {
		entity.onRemove();
		entitys.remove(entity);
		return entity;
		
	}

	@Override
	public Entity addEntity(Entity entity) {
		if(entitys.contains(entity)) {
			throw new IllegalArgumentException("Entity already managed..");
		}
		entity.onCreate();
		entitys.add(entity);
		return entity;
	}

	@Override
	public void tick(Double delta) {
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(e.getGame() != null) {
				if(e.getGame().isRunning()) {
					e.tick(delta);
				}
			}
		}
		
	}

	@Override
	public void render(SpriteBatch batch, Double delta) {
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(e.getGame() != null) {
				if(e.getGame().isRunning()) {
					batch.draw(e.getTexture(), e.getPostion().x, e.getPostion().y);
				}
			}

		}
		
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(e.getGame() != null) {
				if(e.getGame().isRunning()) {
					e.render(batch, delta);
				}
			}
		}
		
		
	}

	@Override
	public Entity[] getEntityWithClass(Class<?> clazz) {
		List<Entity> entit = new ArrayList<Entity>();
		for(int i = 0; i < entitys.size(); i++) {
			Entity e = entitys.get(i);
			if(e.getClass().isAssignableFrom(clazz)) {
				entit.add(e);
			}
		}
		return entit.toArray(new Entity[entit.size()]);
	}

	@Override
	public void closing() {
		for(Entity e : entitys) {
			e.onRemove();
		}
		entitys.clear();
	}

	@Override
	public void starting() {
		entitys = new ArrayList<Entity>();
	}

}
