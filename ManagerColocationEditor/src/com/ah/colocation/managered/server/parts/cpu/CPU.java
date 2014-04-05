package com.ah.colocation.managered.server.parts.cpu;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.badlogic.gdx.graphics.Texture;

public abstract class CPU extends Part {

	
	public CPU(Server server, String texture) {
		super(server, texture);
	}
	public CPU(Server server, Texture texture) {
		super(server, texture);
	}
	
	public abstract String getSpeed();
	public abstract int getCores();
	public abstract SocketType getSocketType();
	
	
	public enum SocketType {
		LGA1155,
	}

}
