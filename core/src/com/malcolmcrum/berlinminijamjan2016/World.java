package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.Gdx;
import com.malcolmcrum.berlinminijamjan2016.tiles.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Crummy on 1/10/2016.
 */
public class World {
	private static final int worldWidth = 11;
	private static final int worldHeight = 5;

	private ChurchTile churchTile;
	private TileMap tileMap;
	private int prayerPoints;
	Set<Human> humans;


	public World() {
		tileMap = new TileMap(worldWidth, worldHeight);
		initializeBlockedTiles();
		churchTile = new ChurchTile(5, 2);
		placeTile(churchTile);

		humans = new HashSet<>();
		spawnNewHuman();
	}

	void spawnNewHuman() {
		humans.add(new Human(churchTile.x, churchTile.y, this));
	}

	public void humanPrayed() {
		prayerPoints++;
	}

	public Optional<BerriesTile> nearestFoodTile(float x, float y) {
		return Optional.ofNullable((BerriesTile)tileMap.nearestTileTo(x, y, BerriesTile.class).orElse(null));
	}

	public Optional<TreeTile> nearestWoodTile(float x, float y) {
		return Optional.ofNullable((TreeTile)tileMap.nearestTileTo(x, y, BerriesTile.class).orElse(null));
	}

	public Optional<EmptyTile> getEmptyTileForHouse() {
		return Optional.ofNullable((EmptyTile)tileMap.getRandomTile(EmptyTile.class).get());
	}


	public void placeTile(Tile tile) {
		tileMap.setTile(tile.x, tile.y, tile);
	}


	private void initializeBlockedTiles() {
		placeTile(new BlockedTile(0, 0));
		placeTile(new BlockedTile(0, 1));
		placeTile(new BlockedTile(1, 0));
		placeTile(new BlockedTile(1, 1));
		placeTile(new BlockedTile(2, 0));
		placeTile(new BlockedTile(3, 0));
		placeTile(new BlockedTile(7, 0));
		placeTile(new BlockedTile(8, 0));
		placeTile(new BlockedTile(9, 0));
		placeTile(new BlockedTile(10, 0));
		placeTile(new BlockedTile(9, 1));
		placeTile(new BlockedTile(10, 1));

		placeTile(new BlockedTile(0, 3));
		placeTile(new BlockedTile(0, 4));
		placeTile(new BlockedTile(1, 3));
		placeTile(new BlockedTile(1, 4));
		placeTile(new BlockedTile(2, 4));
		placeTile(new BlockedTile(3, 4));
		placeTile(new BlockedTile(4, 4));
		placeTile(new BlockedTile(6, 4));
		placeTile(new BlockedTile(7, 4));
		placeTile(new BlockedTile(8, 3));
		placeTile(new BlockedTile(8, 4));
		placeTile(new BlockedTile(9, 3));
		placeTile(new BlockedTile(9, 4));
		placeTile(new BlockedTile(10, 3));
		placeTile(new BlockedTile(10, 4));
	}

	public Tile[] getTiles() {
		return tileMap.getTiles();
	}

	public void update() {
		float elapsedTime = Gdx.graphics.getDeltaTime();
		for(Human human : humans) {
			human.update(elapsedTime);
		}
	}

	public Tile getTile(int x, int y) {
		return tileMap.getTile(x, y);
	}

	public Set<Human> getHumans() {
		return humans;
	}
}
