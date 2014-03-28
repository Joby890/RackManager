package com.ah.colocation.plugins;

import com.ah.framework.Framework;

public abstract class Plugin {

	
	public abstract void onEnable();
	public abstract void onDisable();
	
	
	public Framework getFrameWork() {
		return Framework.getFrameWork();
	}
	
	public String getName() {
		return getClass().getName();
	}

}
