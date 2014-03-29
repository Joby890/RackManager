package com.ah.framework;

public interface RackManager {
	
	public void addRack(Rack rack);
	
	public Rack getRackWithId(String id);
	
	public boolean hasRackWithId(String id);
	
	public void removeRack(Rack rack);
	
	public Rack[] getRacks();

}
