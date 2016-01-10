package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.malcolmcrum.berlinminijamjan2016.actions.Action;

/**
 * Created by crummy on 10.01.16.
 */
public class HumanRenderer extends Renderer {
	Texture texture;

	HumanRenderer(SpriteBatch batch) {
		super(batch);
		texture = new Texture("human.png");
	}

	public void render(Action action, float x, float y) {
		GridPoint2 position = TileToPixel(x, y);
		batch.draw(texture, position.x, position.y);
	}
}
