package com.ah.colocation.managered.server.parts.cpu;

import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.motherboard.MotherBoard;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class E31230V2 extends CPU {

	private Texture texture;

	public E31230V2(Server server) {
		super(server);
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public int getLayer() {
		return 5;
	}

	@Override
	public String getName() {
		return "E3-1230V2";
	}

	@Override
	public Part clone(Server server) {
		if(getServer() != null) {
			return null;
		}
		E31230V2 p = new E31230V2(server);
		return p;
	}

	@Override
	public String getSpeed() {
		return "3.3GHZ";
	}

	@Override
	public int getCores() {
		return 4;
	}

	@Override
	public SocketType getSocketType() {
		return SocketType.LGA1155;
	}

	@Override
	public Vector2 getPostion() {
		return ((MotherBoard) getServer().getPart("motherboard")).getCpuPosition(1);
	}

}
