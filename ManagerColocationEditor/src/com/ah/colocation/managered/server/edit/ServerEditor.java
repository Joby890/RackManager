package com.ah.colocation.managered.server.edit;

import java.util.List;

import com.ah.colocation.managered.ManageredEditor;
import com.ah.colocation.managered.server.Part;
import com.ah.colocation.managered.server.Server;
import com.ah.colocation.managered.server.caze.Case;
import com.ah.colocation.managered.server.motherboard.MotherBoard;
import com.ah.colocation.managered.server.parts.cpu.CPU;
import com.ah.framework.BackRound;
import com.ah.framework.Framework;
import com.ah.framework.Scene;
import com.ah.framework.User;
import com.ah.framework.permission.Action;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ServerEditor extends Scene {

	private BackRound backround;
	private Server current;
	private ManageredEditor me;
	@SuppressWarnings("unused")
	private List<Part> parts;
	private User currentu;

	@Override
	public void start() {
		backround = new BackRound("data/libgdx.png", new Vector2(0, 0));
		/*Object[] objs = new Object[47];
		for(int i = 0; i < 47; i++) {
			objs[i] = i;
		}
		ListStyle style = new ListStyle();
		style.selection = 
		style.font = new BitmapFont();
		com.badlogic.gdx.scenes.scene2d.ui.List list = new com.badlogic.gdx.scenes.scene2d.ui.List(objs, style);
		list.setVisible(true);*/
	}

	@Override
	public void stop() {
		backround.getTexture().dispose();
	}

	@Override
	public void tick(double delta) {
		if(current == null) {
			close(current);
		} else {
			if(current.getPart("case") == null){
				
			}
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
				font.draw(batch, "Please pick a case!", 0, 0);
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
		

	}
	
	/*private Stage stage;
	private TextButton button;
	private int i;*/


	@Override
	public void onSceneChange(Boolean bol) {
		/*if(false) {
			Skin skin =new Skin(Gdx.files.internal("data/uiskin.json"));
			stage = new Stage();
			button = new TextButton("Test Me", skin);
			stage.addActor(button);
			button.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					i++;
					button.setText("Clicked " + i + "times.");
				}
			});
			
			
		}*/
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
			
		} else {
			Framework.getSceneManager().setSceneRunning(me, true);
			Framework.getSceneManager().setSceneRunning(this, false);
		}
	}

}
