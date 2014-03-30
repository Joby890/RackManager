package com.ah.framework;

import com.ah.colocation.managered.server.Server;

public class Unit {

	private int spot;
	private final Rack rack;
	private Server server;

	public Unit(Rack rack, int spot) {
		this.rack = rack;
		this.spot = spot;
	}
	
	public Unit(Rack rack, Server server, int spot) {
		this.rack = rack;
		this.server = server;
		this.spot = spot;
	}
	
	public Rack getRack() {
		return rack;
	}
	
	public int getSpot() {
		return spot;
	}
	
	public void setServer(Server server) {
		this.server = server;
	}
	
	public Server getServer() {
		return server;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Unit) {
			Unit u = (Unit) obj;
			if(u.getSpot() == getSpot() || u.getRack().equals(getRack())) {
				return true;
			}
		} else if(obj instanceof Integer) {
			Integer i = (Integer) obj;
			if(i == getSpot()) {
				return true;
			}
		}
		return false;
	}

}
