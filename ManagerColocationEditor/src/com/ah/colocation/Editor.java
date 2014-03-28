package com.ah.colocation;

import com.ah.colocation.managered.ManageredEditor;
import com.ah.framework.Framework;
import com.ah.framework.User;
import com.ah.framework.admix.AdmixUser;
import com.ah.framework.permission.Action;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Editor implements ApplicationListener {

	private SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		

		User u = Framework.getUserManager().newUser("1jf7fjh6");
		u.addPermission("U10", Action.EXECUTE);
		u.addPermission("U10", Action.READ);
		u.addPermission("U10", Action.WRITE);
		
		Framework.getSceneManager().setSceneRunning(Framework.getSceneManager().registerScene(new ManageredEditor(u)), true);

	}

	@Override
	public void dispose() {
		try {
			
			Framework.getEntityManager().closing();
			Framework.getSceneManager().closing();
		
		} catch (Throwable t) {
			System.out.println("CAUGHT: error thrown in dispose loop");
			t.printStackTrace();
		}
	}

	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		try {
			//Tick
			Framework.getSceneManager().tick(0.0D);
			Framework.getEntityManager().tick(0.0D);
			
			//Render
			Framework.getSceneManager().render(batch, 0.0D);
			Framework.getEntityManager().render(batch, 0.0D);
		} catch (Throwable t) {
			System.out.println("CAUGHT: error thrown in render loop");
			t.printStackTrace();
		}

		batch.end();

		

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}