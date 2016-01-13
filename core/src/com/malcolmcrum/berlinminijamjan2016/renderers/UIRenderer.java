package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.malcolmcrum.berlinminijamjan2016.Button;

/**
 * Created by crummy on 13.01.16.
 */
public class UIRenderer extends Renderer {
	public final static Texture treeTexture = new Texture("tree.png");
	public final static Texture berriesTexture = new Texture("berries.png");
	public final static Texture lightningTexture = new Texture("lightning.png");
	private Button treeButton;
	private Button berriesButton;
	private Button lightningButton;

	UIRenderer(SpriteBatch batch) {
		super(batch);

		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		resize(width, height);
	}

	public void render() {
		renderButton(treeTexture, treeButton.getRectangle());
		renderButton(berriesTexture, berriesButton.getRectangle());
		renderButton(lightningTexture, lightningButton.getRectangle());
	}

	private void renderButton(Texture texture, Rectangle rect) {
		batch.draw(texture, rect.x, rect.y, rect.width, rect.height);
	}

	public void resize(int width, int height) {
		berriesButton = new Button(width/2, 0, 64, 64);
		treeButton = new Button(width/4, 0, 64, 64);
		lightningButton = new Button(3 * width/4, 0, 64, 64);
	}
}
