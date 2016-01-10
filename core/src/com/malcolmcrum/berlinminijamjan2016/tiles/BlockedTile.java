package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by Crummy on 1/10/2016.
 */
public class BlockedTile extends Tile {
	public BlockedTile(int x, int y) {
		super(x, y);
	}

	@Override public Type getType() {
		return Type.Blocked;
	}
}
