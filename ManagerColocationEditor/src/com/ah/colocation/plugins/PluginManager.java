package com.ah.colocation.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginManager {
	
	private List<Plugin> plugins = new ArrayList<Plugin>();
	

	public void init() {
		final File pluginDir = new File("./plugins");
		plugins.add(new Plugin() {
			
			@Override
			public void onEnable() {
				pluginDir.canExecute();
				
			}
			
			@Override
			public void onDisable() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void loadPlugins(File directory) {
		
	}

}
