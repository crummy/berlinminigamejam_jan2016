package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by Crummy on 1/10/2016.
 */
public class BerriesTile extends Tile{
	private static final int max = 20;
	private int berries;

	public BerriesTile(int x, int y) {
		super(x, y);
		berries = max;
	}

	@Override public Type getType() {
		return Type.Berries;
	}

	public boolean hasBerries() {
		return berries > 0;
	}

	public void getBerries() {
		berries--;
	}
}
