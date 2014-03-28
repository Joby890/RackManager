package com.ah.framework.admix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ah.framework.Entity;
import com.ah.framework.Scene;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SceneManager implements com.ah.framework.SceneManager {

	private Map<Scene, Boolean> scenes = new HashMap<Scene, Boolean>();
	
	@Override
	public Scene registerScene(Scene scene) {
		for(int i = 0; i < scenes.size(); i++) {
			Scene s = getScenes()[i];
			if(s.getId().equals(scene)) {
				throw new IllegalArgumentException("Game is already registered to manager");
			}
		}
		scene.start();
		scenes.put(scene, false);
		return scene;
		
	}

	@Override
	public Scene removeScene(Scene scene) {
		scene.stop();
		scenes.remove(scene);
		return scene;
	}

	@Override
	public Scene getSceneById(String id) {
		for(int i = 0; i < scenes.size(); i++) {
			Scene scene = getScenes()[i];
			if(scene.getId().equals(id)) {
				return scene;
			}
		}
		return null;
	}

	@Override
	public Scene[] getScenes() {
		List<Scene> scen = new ArrayList<Scene>(scenes.keySet());
		return scen.toArray(new Scene[scen.size()]);
	}

	@Override
	public Scene[] getSceneWithEntity(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void starting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closing() {
		for(int i = 0; i < scenes.size(); i++) {
			Scene g = getScenes()[i];
			g.stop();
		}
		scenes.clear();
		
	}

	@Override
	public void tick(Double delta) {
		for(int i = 0; i < scenes.size(); i++) {
			Scene s = getScenes()[i];
			if(s.isRunning()) {
				s.tick(delta);
			}
		}
		
	}

	@Override
	public void render(SpriteBatch batch, double d) {
		for(int i = 0; i < scenes.size(); i++) {
			Scene s = getScenes()[i];
			if(s.isRunning()) {
				batch.draw(s.getBackRound().getTexture(), s.getBackRound().getX(), s.getBackRound().getY());
				
			}

		}
		for(int i = 0; i < scenes.size(); i++) {
			Scene s = getScenes()[i];
			if(s.isRunning()) {
				s.render(batch, d);
			}
		}
		
	}

	@Override
	public Scene getSceneWithName(String name) {
		for(int i = 0; i < scenes.size(); i++) {
			Scene s = getScenes()[i];
			if(s.getName().equals(name)) {
				return s;
			}
		}
		return null;
		
	}

	@Override
	public void setSceneRunning(Scene scene, Boolean bol) {
		if(!scenes.containsKey(scene)) {
			throw new IllegalArgumentException("Scene is not managered by manager.");
		}
		scenes.put(scene, bol);
		scene.onSceneChange(bol);
		
	}

	@Override
	public boolean isSceneRunning(Scene scene) {
		if(scenes.containsKey(scene)) {
			return scenes.get(scene);
		}
		return false;
	}
	
	
	


}
