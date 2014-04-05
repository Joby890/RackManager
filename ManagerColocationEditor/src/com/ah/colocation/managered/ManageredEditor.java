package com.ah.colocation.managered;

import java.util.ArrayList;
import java.util.List;

import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.edit.ServerEditor;
import com.ah.framework.BackRound;
import com.ah.framework.Entity;
import com.ah.framework.Framework;
import com.ah.framework.Rack;
import com.ah.framework.Scene;
import com.ah.framework.User;
import com.ah.framework.permission.Action;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ManageredEditor extends Scene {
	
	private BackRound backround;
	private Rack rack;
	private String sercereditorid;
	private List<String> units;
	public User currentUser;
	private int adjust;
	

	public ManageredEditor() {
		this.currentUser = Framework.getUserManager().newUser("Joby890");
	}

	@Override
	public void start() {
		units = new ArrayList<String>();
		sercereditorid = Framework.getSceneManager().registerScene(new ServerEditor()).getId();
		System.out.println(sercereditorid);
		backround = new BackRound("data/datacenter.png", new Vector2(0, 0));
		rack = new Rack(currentUser.getRackSize());
		for(int i = 0; i < rack.getRackSize(); i++) {
			Server ser = (Server) Framework.getEntityManager().addEntity(new Server(this));
			ser.setSpot(rack.getUnit(i));
			currentUser.addPermission(rack.getUnit(i));
		}
		
	}

	@Override
	public void stop() {
		backround.getTexture().dispose();
		
	}

	@Override
	public void tick(double delta) {

		if(Gdx.input.isTouched()) {
			int x = Gdx.input.getX();
			double y = (double) Gdx.input.getY();

			for(Entity e : Framework.getEntityManager().getEntityWithClass(Server.class)) {
				Server s = (Server) e;
				Vector2 pos = e.getPostion();
				if(inRange((double) (x - pos.x) + 800, 800, 1050)) {
					double d = (y - 60) / 20D;
					boolean b = inRange(d, s.getUSpot(), s.getUSpot() + 1);
					if(b) {
						units.clear();
						if(currentUser.hasPermission(Action.OPEN, s.getUnit())) {
							System.out.println("Opening server " + s.getUSpot());
							units.add("Opening U"+s.getUSpot());
							((ServerEditor) Framework.getSceneManager().getSceneById(sercereditorid)).load(this, s);
						} else {
							units.add("U"+s.getUSpot());
						}
						
						
					}
				}
			}
			
		}
	}
	
	private boolean inRange(Double i, int min, int max) {
		return i > min && i < max;
	}
	
	@Deprecated
	public int getRackSize() {
		return rack.getRackSize();
	}
	
	public Rack getRack() {
		return rack;
	}

	@Override
	public String getName() {
		return "Rack View";
	}

	@Override
	public BackRound getBackRound() {
		return backround;
	}

	@Override
	public void render(SpriteBatch batch, Double delta) {
		getBackRound().setX(getBackRound().getX() + adjust);
		getBackRound().setY(getBackRound().getY() + adjust);
		adjust = 0;
		BitmapFont font = new BitmapFont();
		font.setColor(Color.BLACK);
		User[] users = Framework.getUserManager().getCurrentUsers();
		for(int i = 0; i < users.length; i++) {
			font.draw(batch, users[i].getName() + ": " + users[i].getRackSize()+ ". Delta " + delta + ".", 100, Gdx.graphics.getHeight() - (i * 20));
		}
		for(int i = 1; i < units.size() + 1; i++) {
			font.draw(batch, units.get(i - 1), 100, Gdx.graphics.getHeight() - (i * 40));
		}
		

	}

	@Override
	public void onSceneChange(Boolean bol) {
		
	}

}
