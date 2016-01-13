package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import com.malcolmcrum.berlinminijamjan2016.tiles.Tile;

/**
 * Created by crummy on 10.01.16.
 */
public class TileRenderer extends Renderer {
	Texture berries, church, house, tree, empty;

	TileRenderer(SpriteBatch batch) {
		super(batch);
		berries = new Texture("berries.png");
		church = new Texture("church.png");
		house = new Texture("house.png");
		tree = new Texture("tree.png");
		empty = new Texture("empty.png");
	}

	public void render(Tile.Type type, int x, int y) {
		Texture texture = getTexture(type);
		GridPoint2 position = TileToPixel(x, y);
		batch.draw(texture, position.x, position.y);
	}

	private Texture getTexture(Tile.Type type) {
		switch (type) {
		case Church:
			return church;
		case Berries:
			return berries;
		case House:
			return house;
		case Tree:
			return tree;
		case Blocked:
		case Empty:
			return empty;
		}
		throw new RenderException("Unrecognized tile: " + type);
	}

	public static Rectangle getRectangle(Tile tile) {
		GridPoint2 center = TileToPixel(tile.x, tile.y);
		return new Rectangle(center.x - 32, center.y - 32, 64, 64);
	}
}
