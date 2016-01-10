package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by Crummy on 1/10/2016.
 */
public abstract class Tile {
	public final int x;
	public final int y;


	public enum Type {
		Blocked,
		Church,
		Empty,
		Berries,
		House,
		Tree
	}

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract Type getType();
}
