package com.ah.colocation.managered.server;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Part {
	
	private String uuid = UUID.randomUUID().toString();
	private Server server;
	
	public Part(Server server) {
		this.server = server;
	}
	

	public String getId() {
		return uuid;
	}
	
	public String getSpot() {
		return server.getSpotFromPart(this);
	}
	
	public Server getServer() {
		return server;
	}
	
	public abstract Texture getTexture();
	public abstract int getLayer();
	public abstract Vector2 getPostion();
	public abstract String getName();
	public abstract Part clone(Server server) ;
	

}
