package com.ah.colocation.managered.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ah.colocation.managered.server.caze.CSE512L200B;
import com.ah.colocation.managered.server.motherboard.MBDX9SCLFO;
import com.ah.colocation.managered.server.parts.cpu.E31230V2;
import com.ah.framework.Entity;
import com.ah.framework.Scene;
import com.ah.framework.Unit;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Server extends Entity {

	private Texture texture;
	private Vector2 postion;
	private Unit u;
	private Map<String, Part> currentParts = new HashMap<String	, Part>();
	
	public Server(Scene scene) {
		super(scene);
	}

	@Override
	public void tick(Double delta) {
		//System.out.println(uSpot);
	}

	@Override
	public void render(SpriteBatch batch, Double delta) {
		
	}

	@Override
	public void onCreate() {
		//uSpot = Framework.getEntityManager().getEntityWithClass(Server.class).length + 1;

		texture = new Texture("data/server.png");
		currentParts.put("cpu", new E31230V2(this));
		currentParts.put("motherboard", new MBDX9SCLFO(this));
		currentParts.put("case", new CSE512L200B(this));
		
	}

	@Override
	public void onRemove() {
		texture.dispose();
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public Vector2 getPostion() {
		return postion;
	}
	//Return the converted spot..
	public int getUSpot() {
		return u.getRack().getRackSize() - u.getSpot();
	}
	
	public void setSpot(Unit u) {
		this.u = u;
		u.setServer(this);
		//Make sure we change the postion of the vector
		postion = new Vector2(900, u.getSpot() * 20 + 10);
	}
	
	
	public void setPart(String place, Part part) {
		currentParts.put(place, part);
	}
	
	public Part getPart(String part) {
		if(currentParts.containsKey(part)) {
			return currentParts.get(part);
		}
		return null;
	}
	
	protected String getSpotFromPart(Part part) {
		for(Entry<String, Part> en : currentParts.entrySet()) {
			if(en.getValue().getId().equals(part.getId())) {
				return en.getKey();
			}
		}
		return null;
	}
	
	
	public boolean isInRack() {
		return u != null && u.getRack() != null;
	}
	
	public Unit getUnit() {
		return u;
	}

}
