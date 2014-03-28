package com.ah.framework.admix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.caze.CSE512L200B;
import com.ah.colocation.managered.server.motherboard.MBDX9SCLFO;
import com.ah.colocation.managered.server.parts.cpu.E31230V2;
import com.ah.colocation.plugins.Plugin;

public class PartManager {
	
	
	private Map<Part, String> originalParts = new HashMap<Part, String>();
	
	
	public void starting() {
		try {
			originalParts.put(new E31230V2(null), null);
			originalParts.put(new MBDX9SCLFO(null), null);
			originalParts.put(new CSE512L200B(null), null);
		} catch (Exception e) {
			System.out.println("Error adding new part to Part manager.." + e.toString());
		}

	}
	
	
	public List<Part> getPartsForServer(Server server) {
		List<Part> parts = new ArrayList<Part>();
		for(Entry<Part, String> p : originalParts.entrySet()) {
			parts.add(p.getKey().clone(server));
		}
		return parts;
	}

	public Part getPartFromPart(Part part) {
		for(Entry<Part, String> p : originalParts.entrySet()) {
			if(p.getKey().getName().equals(part.getName())) {
				return p.getKey().clone(part.getServer());
			}
		}
		return null;
	}
	
	public void addPart(Plugin plugin, Part part) {
		if(getPartFromPart(part) != null) {
			return;
		}
		originalParts.put(part, plugin.getName());
		
	}
	


}
