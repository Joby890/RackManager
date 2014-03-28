package com.ah.colocation.managered.server.caze;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.motherboard.MotherBoard.FormFactor;
import com.badlogic.gdx.math.Vector2;

public abstract class Case extends Part {

	public Case(Server server) {
		super(server);
	}
	
	public abstract Vector2 getMotherBoardSpot();
	public abstract Vector2 getDrivedSpot(int spot);
	public abstract FormFactor getFormFactor();
	public abstract int getMaxDrives();

}
