package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.actions.Action;
import com.malcolmcrum.berlinminijamjan2016.actions.Sleeping;

/**
 * Created by Crummy on 1/10/2016.
 */
public class Human {
	private final World world;
	private Vector2 position;

	private Action currentAction;

	private Need foodNeed;
	private Need sleepNeed;
	private boolean isAlive;

	private static Sleeping sleeping = new Sleeping();
	private static Eating eating = new Eating();

	public Human(int x, int y, World world) {
		this.world = world;
		position = new Vector2(x, y);
		currentAction = sleeping;
		foodNeed = new Need();
		sleepNeed = new Need();
		isAlive = true;
	}

	public void update() {
		foodNeed.update();
		sleepNeed.update();
		if (foodNeed.isMax() || sleepNeed.isMax()) {
			isAlive = false;
			return;
		}
		currentAction = currentAction.perform(this);
		if (currentAction == null) {
			if (foodNeed.isCritical()) {
				currentAction = eating;
			}
		}
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

	public void didPray() {
		world.humanPrayed();
	}

	private class Need {
		private int min = 0;
		private int max = 100;
		private int value = 20;
		private int importantLevel = 50;
		private int criticalLevel = 100;

		public void update() {
			value++;
			if (value > max) {
				value = max;
			}
		}

		public boolean isImportant() {
			return value >= importantLevel && value < criticalLevel;
		}

		public boolean isCritical() {
			return value >= criticalLevel;
		}

		public boolean isMax() {
			return value == max;
		}
	}

	private class Resource {
		int min = 0;
		int max = 10;
		int value = 0;

		public boolean collect() {
			value++;
			if (value >= max) {
				value = max;
				return true;
			} else {
				return false;
			}
		}

		public boolean consume() {
			value--;
			if (value <= min) {
				value = min;
				return true;
			} else {
				return false;
			}
		}
	}
}
