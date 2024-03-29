package com.ah.colocation.managered.server.edit;

import java.util.List;

import com.ah.colocation.managered.ManageredEditor;
import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.caze.Case;
import com.ah.colocation.managered.server.motherboard.MotherBoard;
import com.ah.colocation.managered.server.parts.cpu.CPU;
import com.ah.colocation.util.SimpleButton;
import com.ah.framework.BackRound;
import com.ah.framework.Framework;
import com.ah.framework.Scene;
import com.ah.framework.User;
import com.ah.framework.permission.Action;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.math.Vector2;

public class ServerEditor extends Scene {

	private BackRound backround;
	private Server current;
	private ManageredEditor me;
	@SuppressWarnings("unused")
	private List<Part> parts;
	private User currentu;
	
	
	private SimpleButton save;
	private boolean wasTouched;

	@Override
	public void start() {
		backround = new BackRound("data/editor.png", new Vector2(0, 0));
		save = new SimpleButton("Save Server", new BitmapFont());
		save.setWidth(100);
		save.setHeight(100);
		//save.leftOn(0);
		//save.bottomOn(1.0f);
		save.setAlignment(HAlignment.CENTER);

	}

	private void updateButtons(double delta) {
		boolean justTouched = Gdx.input.justTouched();
		boolean isTouched = Gdx.input.isTouched();
		boolean justReleased = wasTouched && !isTouched;
		wasTouched = isTouched;
		save.update((float) delta, justTouched, isTouched, justReleased, Gdx.input.getX(), Gdx.input.getY());
	}

	@Override
	public void stop() {
		backround.getTexture().dispose();
	}

	@Override
	public void tick(double delta) {
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			close(current);
		}
		updateButtons(delta);
		if(current == null) {
			close(current);
		} else {
			if(current.getPart("case") == null){
				
			}
		}
		if(save.wasPressed()) {
			System.out.println("Pressed");
		}
	}

	@Override
	public String getName() {
		return "Editor";
	}

	@Override
	public BackRound getBackRound() {
		return backround;
	}

	@Override
	public void render(SpriteBatch batch, Double delta) {

		if(current == null) {
			close(current);
		} else {
			//Case
			if(!currentu.hasPermission(Action.CHANGE_CASE, current.getUnit())) {
				return;
			}
			if(current.getPart("case") == null){
				BitmapFont font = new BitmapFont();
				font.setColor(Color.WHITE);
				font.draw(batch, "Please pick a case!", 50, 50);
				return;
			} else {
				Case caze = (Case) current.getPart("case");
				batch.draw(caze.getTexture(), caze.getPostion().x, caze.getPostion().y);
				//Motherboard
				if(!currentu.hasPermission(Action.CHANGE_MOTHERBOARD, current.getUnit())) {
					return;
				}
				if(current.getPart("motherboard") == null) {
					BitmapFont font = new BitmapFont();
					font.draw(batch, "Please select a motherboard", caze.getMotherBoardSpot().x, caze.getMotherBoardSpot().y);
					return;
				} else {
					MotherBoard mb = (MotherBoard) current.getPart("motherboard");
					batch.draw(mb.getTexture(), mb.getPostion().x, mb.getPostion().y);
					//CPU
					if(!currentu.hasPermission(Action.CHANGE_CPU, current.getUnit())) {
						return;
					}
					if(current.getPart("cpu") == null) {
						BitmapFont font = new BitmapFont();
						font.draw(batch, "Please select a CPU.", mb.getCpuPosition(1).x, mb.getCpuPosition(1).y);
						return;
					} else {
						CPU cpu = (CPU) current.getPart("cpu");
						batch.draw(cpu.getTexture(), cpu.getPostion().x, cpu.getPostion().y);
					}
				}
				
			}
			
			
		}
		
		save.draw(batch);
	}


	@Override
	public void onSceneChange(Boolean bol) {
	}

	public void load(ManageredEditor me, Server s) {
		this.me = me;
		current = s;
		Framework.getSceneManager().setSceneRunning(me, false);
		Framework.getSceneManager().setSceneRunning(this, true);

		parts = Framework.getPartManager().getPartsForServer(current);
		currentu = me.currentUser;
		
	}
	
	public void close(Server server) {
		if(server != null) {
			
		}
		Framework.getSceneManager().setSceneRunning(me, true);
		Framework.getSceneManager().setSceneRunning(this, false);
	}

}
