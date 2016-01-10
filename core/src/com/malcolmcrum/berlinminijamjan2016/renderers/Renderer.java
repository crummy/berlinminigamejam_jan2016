package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by crummy on 10.01.16.
 */
public class Renderer {
	final SpriteBatch batch;

	final static Vector2 tileOffset = new Vector2(25, 242);
	final static Vector2 tileSize = new Vector2(64, 64);

	Renderer(SpriteBatch batch) {
		this.batch = batch;
	}

	static Vector2 PixelToTile(int x, int y) {
		int tileX = (int)((x - tileOffset.x) / tileSize.x);
		int tileY = (int)((y - tileOffset.y) / tileSize.y);
		return new Vector2(tileX, tileY);
	}

	static Vector2 TileToPixel(int x, int y) {
		int pixelX = (int)(x * tileSize.x + tileOffset.x);
		int pixelY = (int)(y * tileSize.y + tileOffset.y);
		return new Vector2(pixelX, pixelY);
	}
}
