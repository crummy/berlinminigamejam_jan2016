package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.World;
import com.malcolmcrum.berlinminijamjan2016.tiles.EmptyTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.Tile;

/**
 * Created by crummy on 10.01.16.
 */
public class WorldRenderer extends Renderer {
	private Texture ground;
	private TileRenderer tileRenderer;
	private HumanRenderer humanRenderer;
	private GridPoint2 highlightedTileLocation;
	private Tile.Type selectedType;

	public WorldRenderer(SpriteBatch batch) {
		super(batch);
		ground = new Texture("world.png");
		tileRenderer = new TileRenderer(batch);
		humanRenderer = new HumanRenderer(batch);
		highlightedTileLocation = null;
		selectedType = Tile.Type.House;
	}

	public void render(World world, int width, int height) {
		batch.draw(ground, 0, 0, width, height);
		for (Tile tile : world.getTiles()) {
			tileRenderer.render(tile.getType(), tile.x, tile.y);
		}
		if (highlightedTileLocation != null) {
			Tile highlightedTile = world.getTile((int)highlightedTileLocation.x, (int)highlightedTileLocation.y);
			if (highlightedTile instanceof EmptyTile && selectedType != null) {
				tileRenderer.render(selectedType, highlightedTile.x, highlightedTile.y);
			}
		}
		for (Human human : world.getHumans()) {
			humanRenderer.render(human.getAction(), human.getX(), human.getY());
		}
	}

	public boolean mouseOver(int x, int y) {
		highlightedTileLocation = PixelToTile(x, y);
		return true;
	}

	public boolean click(int x, int y) {
		return true;
	}
}
