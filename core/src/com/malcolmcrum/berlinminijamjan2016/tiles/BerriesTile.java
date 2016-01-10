package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by Crummy on 1/10/2016.
 */
public class BerriesTile extends Tile{
	public BerriesTile(int x, int y) {
		super(x, y);
	}

	@Override public Type getType() {
		return Type.Berries;
	}
}
