package com.ah.colocation.managered.server.motherboard;

import java.util.HashMap;
import java.util.Map;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.caze.Case;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MBDX9SCLFO extends MotherBoard {
	
	private Texture texture;
	private Vector2 vecCpu;
	private Map<Integer, Vector2> vecs;

	public MBDX9SCLFO(Server server) {
		super(server);
		texture = new Texture("data/MBDX9SCLFO.png");
		vecCpu = new Vector2(375, 375);
		vecs = new HashMap<Integer, Vector2>();
	}

	@Override
	public FormFactor getFormFactor() {
		return FormFactor.MICROATX;
	}

	@Override
	public Vector2 getCpuPosition(int spot) {
		if(spot != 1) {
			return null;
		}
		return vecCpu;
	}

	@Override
	public Vector2 getRamPostion(int spot) {
		if(vecs.get(spot) == null) {
			vecs.put(spot, new Vector2(spot * 50 + 200, 300));
		}
		return vecs.get(spot);
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public int getLayer() {
		return 2;
	}

	@Override
	public Vector2 getPostion() {
		return ((Case)getServer().getPart("case")).getMotherBoardSpot();
	}

	@Override
	public String getName() {
		return "Supermicro MBD-X9SCL+-F-O";
	}

	@Override
	public Part clone(Server server) {
		if(getServer() != null) {
			return null;
		}
		MBDX9SCLFO p = new MBDX9SCLFO(server);
		return p;
	}

}
