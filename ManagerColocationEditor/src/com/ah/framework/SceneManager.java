package com.ah.framework;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface SceneManager {
	
	/**
	 * Adds a game to the Manager to be run by the framework
	 * 
	 * @param game 
	 * 			- The Game being registered to the manager of the framework
	 */
	public Scene registerScene(Scene scene);
	
	/**
	 * Removes game from Manager being run by the framework
	 * 
	 * @param game
	 * 			- Game being removed by manager.
	 */
	public Scene removeScene(Scene scene);
	
	/**
	 * 
	 * 
	 * @param id
	 * 			- Id of the Game
	 * @return Game
	 * 			- Returns the game with that id, null if no game with id is registered.
	 */
	public Scene getSceneById(String id);
	
	/**
	 * Get the current games being mangered by the framework.
	 * 
	 * @return a copy of Games being mangered by the framework.
	 */
	public Scene[] getScenes();
	
	/**
	 * Gets a game having a certain entity
	 * @param entity
	 * @return
	 */
	public Scene[] getSceneWithEntity(Entity entity);
	/**
	 * Called when the manager is starting
	 */
	public void starting();
	/**
	 * Called when the manager is stoping
	 */
	public void closing();
	/**
	 * A method to update the manager
	 * @param delta
	 */
	public void tick(Double delta);

	public void render(SpriteBatch batch, double d);
	
	public Scene getSceneWithName(String name);
	
	public void setSceneRunning(Scene scence, Boolean bol);

	public boolean isSceneRunning(Scene scene);	
	
	
	
	
}
