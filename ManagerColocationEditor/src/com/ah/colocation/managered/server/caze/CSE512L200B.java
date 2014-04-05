package com.ah.colocation.managered.server.caze;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.motherboard.MotherBoard.FormFactor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class CSE512L200B extends Case {
	
	private Vector2 mbvec;
	private Vector2 drive1;
	private Vector2 drive2;
	private Vector2 pos;

	public CSE512L200B(Server server) {
		super(server, new Texture("data/CSE512L200B.png"));
		mbvec = new Vector2(227, 218);
		drive1 = new Vector2(20, 300);
		drive2 = new Vector2(500, 300);
		pos = new Vector2(500, 300);
	}

	@Override
	public Vector2 getMotherBoardSpot() {
		return mbvec;
	}

	@Override
	public Vector2 getDrivedSpot(int spot) {
		if(spot <= 0 || spot >= 3) {
			return null;
		}
		if(spot == 1) {
			return drive1;
		} else {
			return drive2;
		}
		
	}

	@Override
	public FormFactor getFormFactor() {
		return FormFactor.ATX;
	}

	@Override
	public int getMaxDrives() {
		return 2;
	}

	@Override
	public int getLayer() {
		return 1;
	}

	@Override
	public Vector2 getPostion() {
		return pos;
	}

	@Override
	public String getName() {
		return "Supermicro CSE-512L-200B";
	}

	@Override
	public Part clone(Server server) {
		CSE512L200B p = new CSE512L200B(server);
		return p;
	}

}
