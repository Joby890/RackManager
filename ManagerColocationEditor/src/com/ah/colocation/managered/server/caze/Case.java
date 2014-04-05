package com.ah.colocation.managered.server.caze;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.motherboard.MotherBoard.FormFactor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Case extends Part {

	public Case(Server server, Texture texture) {
		super(server, texture);
	}
	public Case(Server server, String texture) {
		super(server, texture);
	}
	
	
	public abstract Vector2 getMotherBoardSpot();
	public abstract Vector2 getDrivedSpot(int spot);
	public abstract FormFactor getFormFactor();
	public abstract int getMaxDrives();

}
