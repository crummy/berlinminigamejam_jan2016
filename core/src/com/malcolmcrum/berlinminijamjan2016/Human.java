package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.actions.Action;
import com.malcolmcrum.berlinminijamjan2016.actions.Sleeping;

/**
 * Created by Crummy on 1/10/2016.
 */
public class Human {
	private Vector2 position;
	private Action currentAction;

	public Human(int x, int y) {
		position = new Vector2(x, y);
		currentAction = new Sleeping();
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public Action getAction() {
		return currentAction;
	}
}
