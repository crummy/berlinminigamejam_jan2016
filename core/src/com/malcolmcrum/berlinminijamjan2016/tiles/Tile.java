package com.malcolmcrum.berlinminijamjan2016.tiles;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Crummy on 1/10/2016.
 */
public abstract class Tile {
    public final int x;
    public final int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
