package com.ah.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ah.colocation.managered.server.Server;

public class Rack {
	
	private List<Unit> units = new ArrayList<Unit>();
	private String uuid = UUID.randomUUID().toString();
	
	public Rack(int size) {
		for(int i = 0; i < size; i++) {
			Unit u = new Unit(this, i);
			units.add(u);
		}
	}
	
	public Unit getUnit(int i) {
		for(Unit u : units) {
			if(u.getSpot() == i) {
				return u;
			}
		}
		return null;
	}
	
	public int getRackSize() {
		return units.size();
	}
	
	public Server getServerInU(int u) {
		return getUnit(u).getServer();
	}
	
	public String getId() {
		return uuid ;
	}
	
	
	

}
