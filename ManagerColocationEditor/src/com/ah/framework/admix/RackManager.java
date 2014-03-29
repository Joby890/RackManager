package com.ah.framework.admix;

import java.util.ArrayList;
import java.util.List;

import com.ah.framework.Rack;

public class RackManager implements com.ah.framework.RackManager {
	
	private List<Rack> racks = new ArrayList<Rack>();

	@Override
	public void addRack(Rack rack) {
		if(rack.getId() == null) {
			return;
		}
		racks.add(rack);
	}
	@Override
	public Rack getRackWithId(String id) {
		for(Rack r : racks) {
			if(r.getId().equals(id)) {
				return r;
			}
		}
		return null;
	}
	@Override
	public boolean hasRackWithId(String id) {
		for(Rack r : racks) {
			if(r.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void removeRack(Rack rack) {	
		racks.remove(rack);
	}
	@Override
	public Rack[] getRacks() {
		return racks.toArray(new Rack[racks.size()]);
	}

}
