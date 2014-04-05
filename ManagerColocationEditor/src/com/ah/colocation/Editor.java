package com.ah.colocation;

import com.ah.colocation.managered.ManageredEditor;
import com.ah.framework.Framework;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Editor implements ApplicationListener {

	private SpriteBatch batch;

	@Override
	public void create() {
		//Init the plugin manager
		Framework.getPluginManager().init();
		
		batch = new SpriteBatch();
		
		Framework.getSceneManager().setSceneRunning(Framework.getSceneManager().registerScene(new ManageredEditor()), true);

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

	private long last = System.nanoTime();

	@Override
	public void render() {

		long current = System.nanoTime();
		double d = (current - last) / (1000.0 * 1000);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		try {
			//Tick
			Framework.getSceneManager().tick(d);
			Framework.getEntityManager().tick(d);

			//Render
			Framework.getSceneManager().render(batch, d);
			Framework.getEntityManager().render(batch, d);
		} catch (Throwable t) {
			System.out.println("CAUGHT: error thrown in render loop");
			t.printStackTrace();
		}
		batch.end();
		last = current;
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