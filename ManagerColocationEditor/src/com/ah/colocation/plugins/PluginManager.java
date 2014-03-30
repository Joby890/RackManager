package com.ah.colocation.plugins;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginManager {
	
	private List<Plugin> plugins = new ArrayList<Plugin>();
	

	public void init() {
		File pluginDir = new File("./plugins");
	}
	
	public void loadPlugins(File directory) {
		
	}

}
