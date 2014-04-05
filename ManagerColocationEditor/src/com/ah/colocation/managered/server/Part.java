package com.ah.colocation.managered.server;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Part {
	
	private String uuid = UUID.randomUUID().toString();
	private Server server;
	private Texture texture;
	
	public Part(Server server, Texture texture) {
		this.server = server;
		this.texture = texture;
	}
	
	public Part(Server server, String texture) {
		this.server = server;
		this.texture = new Texture(texture);
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
	
	public Texture getTexture() {
		return texture;
	}
	public abstract int getLayer();
	public abstract Vector2 getPostion();
	public abstract String getName();
	public abstract Part clone(Server server) ;
	

}
