package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.berlinminijamjan2016.Button;

/**
 * Created by crummy on 13.01.16.
 */
public class ButtonRenderer extends Renderer {
	public final static Texture treeTexture = new Texture("tree.png");
	public final static Texture berriesTexture = new Texture("berries.png");
	public final static Texture lightningTexture = new Texture("lightning.png");

	ButtonRenderer(SpriteBatch batch) {
		super(batch);
	}

	public void render(Button button, int x, int y, Texture texture) {
		batch.draw(texture, x, y);
	}
}
