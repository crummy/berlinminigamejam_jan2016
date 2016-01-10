package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by crummy on 10.01.16.
 */
public class HouseTile extends Tile {
	public HouseTile(int x, int y) {
		super(x, y);
	}

	@Override public Type getType() {
		return Type.House;
	}
}
