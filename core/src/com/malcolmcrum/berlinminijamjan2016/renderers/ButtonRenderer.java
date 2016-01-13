package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.berlinminijamjan2016.Button;

/**
 * Created by crummy on 13.01.16.
 */
public class ButtonRenderer extends Renderer {

	public final static float width = 64;
	public final static float height = 64;

	ButtonRenderer(SpriteBatch batch) {
		super(batch);
	}

	public void render(Button button, int x, int y, Texture texture) {
	}
}
