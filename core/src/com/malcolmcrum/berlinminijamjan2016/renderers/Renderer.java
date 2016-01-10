package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;

/**
 * Created by crummy on 10.01.16.
 */
public class Renderer {
	final SpriteBatch batch;

	final static GridPoint2 tileOffset = new GridPoint2(25, 242);
	final static GridPoint2 tileSize = new GridPoint2(64, 64);

	Renderer(SpriteBatch batch) {
		this.batch = batch;
	}

	static GridPoint2 PixelToTile(int x, int y) {
		int tileX = (x - tileOffset.x) / tileSize.x;
		int tileY = (y - tileOffset.y) / tileSize.y;
		return new GridPoint2(tileX, tileY);
	}

	static GridPoint2 TileToPixel(float x, float y) {
		int pixelX = (int)((x * tileSize.x) + tileOffset.x);
		int pixelY = (int)((y * tileSize.y) + tileOffset.y);
		return new GridPoint2(pixelX, pixelY);
	}
}
