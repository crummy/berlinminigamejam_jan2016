package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.berlinminijamjan2016.renderers.WorldRenderer;

import java.util.HashSet;
import java.util.Set;

public class MinijamGame extends ApplicationAdapter {
	SpriteBatch batch;

	World world;
	WorldRenderer worldRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		world = new World();
		worldRenderer = new WorldRenderer(batch);

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchUp(int x, int y, int pointer, int button) {
				return worldRenderer.click(x, y);
			}

			@Override
			public boolean mouseMoved(int x, int y) {
				return worldRenderer.mouseOver(x, y);
			}
		});
	}

	@Override
	public void resize (int width, int height) {
		worldRenderer.resize(width, height);
	}

	@Override
	public void render () {
		world.update();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		worldRenderer.render(world, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}
}
