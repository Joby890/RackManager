package com.ah.framework;

import com.ah.colocation.plugins.PluginManager;
import com.ah.framework.admix.PartManager;

public class Framework {
	
	private static Framework frame;
	
	public SceneManager scenemanager;
	public EntityManager entitymanager;
	public PartManager partsmanager;
	private PluginManager pm;
	private UserManager um;
	
	public Framework() {
		entitymanager = new com.ah.framework.admix.EntityManager();
		scenemanager = new com.ah.framework.admix.SceneManager();
		partsmanager = new PartManager();
		partsmanager.starting();
		um = new com.ah.framework.admix.UserManager();
		pm = new PluginManager();
		pm.init();
	}

	public static SceneManager getSceneManager(){
		return getFrameWork().getLocalSceneManager();
	}
	
	public static PartManager getPartManager(){
		return getFrameWork().getLocalPartManager();
	}

	private PartManager getLocalPartManager() {
		return partsmanager;
	}

	public static EntityManager getEntityManager() {
		return getFrameWork().getLocalEntityManager();
	}
	
	public static int getFrameWorkVersion() {
		return 1;
	}

	private EntityManager getLocalEntityManager() {
		return entitymanager;
	}
	
	private SceneManager getLocalSceneManager() {
		return scenemanager;
	}
	
	public static Framework getFrameWork() {
		if(frame == null) {
			frame = new Framework();
		}
		return frame;
	}
	
	public static PluginManager getPluginManager() {
		return getFrameWork().pm;
	}
	
	public static UserManager getUserManager() {
		return getFrameWork().um;
	}

}
