package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.tiles.EmptyTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.Tile;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Crummy on 1/10/2016.
 */
public class TileMap {
	private Tile[] tiles;
	private final int height;
	private final int width;

	public TileMap(int width, int height) {
		this.height = height;
		this.width = width;
		tiles = new Tile[width * height];
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				setTile(x, y, new EmptyTile(x, y));
			}
		}
	}

	public void setTile(int x, int y, Tile tile) {
		if (tile.x != x || tile.y != y) {
			throw new RuntimeException("Tried to set tile with coordinates that don't match internal tile coordinates");
		}
		try {
			tiles[x * height + y] = tile;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("Tried to set tile at " + x + ", " + y, e);
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x > width || y < 0 || y > width) {
			return null;
		} else {
			return tiles[x * height + y];
		}
	}

	public Optional<Tile> nearestTileTo(float x, float y, Class desiredType) {
		return Arrays.stream(tiles)
				.filter(tile -> tile.getClass() == desiredType)
				.sorted((a, b) -> Float.compare(Vector2.dst(a.x, a.y, x, y), Vector2.dst(b.x, b.y, x, y)))
				.findFirst();
	}

	public Optional<Tile> getRandomTile(Class emptyTileClass) {
		return Arrays.stream(tiles)
				.filter(tile -> tile.getClass() == emptyTileClass)
				.sorted((a, b) -> Double.compare(Math.random(), Math.random()))
				.findFirst();
	}

	public Tile[] getTiles() {
		return tiles;
	}
}
