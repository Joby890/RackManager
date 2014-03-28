package com.admixhosting.colocation;

import com.ah.colocation.Editor;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ManagerColocationEditor";
		cfg.useGL20 = true;
		cfg.width = 1920;
		cfg.height = 1080;
		
		new LwjglApplication(new Editor(), cfg);
	}
}
