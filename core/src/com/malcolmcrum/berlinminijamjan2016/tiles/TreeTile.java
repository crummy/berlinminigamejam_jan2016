package com.malcolmcrum.berlinminijamjan2016.tiles;

/**
 * Created by Crummy on 1/10/2016.
 */
public class TreeTile extends Tile {
	private static final int max = 20;
	private int wood;

	public TreeTile(int x, int y) {
		super(x, y);
		wood = max;
	}

	@Override public Type getType() {
		return Type.Tree;
	}

	public void getWood() {
		wood--;
	}

	public boolean hasWood() {
		return wood > 0;
	}
}
