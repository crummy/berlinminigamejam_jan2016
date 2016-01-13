package com.malcolmcrum.berlinminijamjan2016.renderers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.malcolmcrum.berlinminijamjan2016.Button;
import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.World;
import com.malcolmcrum.berlinminijamjan2016.tiles.BerriesTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.EmptyTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.Tile;
import com.malcolmcrum.berlinminijamjan2016.tiles.TreeTile;

/**
 * Created by crummy on 10.01.16.
 */
public class WorldRenderer extends Renderer {
	private Texture ground;
	private TileRenderer tileRenderer;
	private HumanRenderer humanRenderer;
	private ButtonRenderer buttonRenderer;
	private GridPoint2 highlightedTileLocation;
	private Tile.Type selectedType;
	private Button treeButton;
	private Button berriesButton;
	private Button lightningButton;

	public WorldRenderer(SpriteBatch batch) {
		super(batch);
		ground = new Texture("world.png");
		tileRenderer = new TileRenderer(batch);
		humanRenderer = new HumanRenderer(batch);
		buttonRenderer = new ButtonRenderer(batch);
		highlightedTileLocation = null;
		selectedType = null;
		berriesButton = new Button();
		treeButton = new Button();
		lightningButton = new Button();
	}

	public void render(World world, int width, int height) {
		batch.draw(ground, 0, 0, width, height);

		buttonRenderer.render(berriesButton, width/2, 0, ButtonRenderer.berriesTexture);
		buttonRenderer.render(treeButton, width/4, 0, ButtonRenderer.treeTexture);
		buttonRenderer.render(lightningButton, 3 * width/4, 0, ButtonRenderer.lightningTexture);

		for (Tile tile : world.getTiles()) {
			tileRenderer.render(tile.getType(), tile.x, tile.y);
		}
		if (highlightedTileLocation != null && selectedType != null) {
			Tile highlightedTile = world.getTile(highlightedTileLocation.x, highlightedTileLocation.y);
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
