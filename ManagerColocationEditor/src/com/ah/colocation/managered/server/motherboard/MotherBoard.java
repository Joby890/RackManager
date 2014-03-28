package com.ah.colocation.managered.server.motherboard;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.badlogic.gdx.math.Vector2;

public abstract class MotherBoard extends Part {

	public MotherBoard(Server server) {
		super(server);
	}
	
	
	public abstract FormFactor getFormFactor();
	public abstract Vector2 getCpuPosition(int spot);
	public abstract Vector2 getRamPostion(int spot);
	

	
	public enum FormFactor {
		MICROATX,
		ATX,
		ITX,
	}

}
