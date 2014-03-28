package com.ah.colocation.managered.server.parts.cpu;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;

public abstract class CPU extends Part {

	public CPU(Server server) {
		super(server);
	}
	
	public abstract String getSpeed();
	public abstract int getCores();
	public abstract SocketType getSocketType();
	
	
	public enum SocketType {
		LGA1155,
	}

}
