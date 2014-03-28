package com.ah.colocation.managered.server.caze;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.motherboard.MotherBoard.FormFactor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class CSE512L200B extends Case {

	public CSE512L200B(Server server) {
		super(server);
	}

	@Override
	public Vector2 getMotherBoardSpot() {
		return new Vector2(20, 20);
	}

	@Override
	public Vector2 getDrivedSpot(int spot) {
		if(spot <= 0 || spot >= 3) {
			return null;
		}
		if(spot == 1) {
			return new Vector2(20, 300);
		} else {
			return new Vector2(500, 300);
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
	public Texture getTexture() {
		return new Texture("data/CSE512L200B.png");
	}

	@Override
	public int getLayer() {
		return 1;
	}

	@Override
	public Vector2 getPostion() {
		return new Vector2(0, 0);
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
