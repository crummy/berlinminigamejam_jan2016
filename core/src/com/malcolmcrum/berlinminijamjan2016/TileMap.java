package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.tiles.Tile;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Crummy on 1/10/2016.
 */
public class TileMap {
    private Tile[][] tiles;

    public TileMap(int width, int height) {
        tiles = new Tile[width][height];
    }

    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }

    public Optional<Tile> nearestTileTo(int x, int y, Class desiredType) {
        Tile nearestTile = null;
        float nearestDistance = Float.MAX_VALUE;
        for (int i = 0; i < tiles.length; ++i) {
            for (int j = 0; j < tiles[i].length; ++j) {
                Tile tile = tiles[i][j];
                if (tile.getClass() == desiredType) {
                    float distance = Vector2.dst(x, y, tile.x, tile.y);
                    if (distance < nearestDistance) {
                        nearestDistance = distance;
                        nearestTile = tile;
                    }
                }
            }
        }
        return Optional.ofNullable(nearestTile);
    }

    public Optional<Tile> getRandomTile(Class emptyTileClass) {
        return Arrays.stream(tiles)
                .flatMap(Arrays::stream)
                .filter(tile -> tile.getClass() == emptyTileClass)
                .sorted((a, b) -> Double.compare(Math.random(), Math.random()))
                .findFirst();
    }
}
