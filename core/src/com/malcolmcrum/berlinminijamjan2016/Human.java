package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.actions.*;
import com.malcolmcrum.berlinminijamjan2016.tiles.*;

import java.util.Optional;

/**
 * Created by Crummy on 1/10/2016.
 */
public class Human {
	private static final double BIRTH_CHANCE = 0.05;
	private final World world;
	private Vector2 position;

	private Action currentAction;

	public final Need foodNeed;
	public final Need sleepNeed;
	public final Resource food;
	public final Resource wood;
	private boolean isAlive;
	private Optional<HouseTile> house;

	public Human(int x, int y, World world) {
		this.world = world;
		position = new Vector2(x, y);
		currentAction = null;
		foodNeed = new Need();
		sleepNeed = new Need();
		food = new Resource();
		wood = new Resource();
		isAlive = true;
		house = Optional.empty();
	}

	public void update() {
		foodNeed.update();
		sleepNeed.update();
		if (foodNeed.isMax() || sleepNeed.isMax()) {
			isAlive = false;
			return;
		}
		if (currentAction == null) {
			if (foodNeed.isCritical()) {
				currentAction = new GoEat();
			} else if (sleepNeed.isCritical()) {
				currentAction = new GoToSleep();
			} else if (foodNeed.isImportant()) {
				currentAction = new GoEat();
			} else if (sleepNeed.isImportant()) {
				currentAction = new GoToSleep();
			} else {
				if (Math.random() > 1 - BIRTH_CHANCE) {
					world.spawnNewHuman();
				}
				currentAction = new Pray();
			}
		}
		currentAction = currentAction.perform(this);
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

	public Optional<HouseTile> getHouse() {
		return house;
	}

	public void moveTowards(Tile tile) {
		position.add(tile.x, tile.y)
				.setLength(0.1f);
	}

	public Optional<TreeTile> nearestTree() {
		return world.nearestWoodTile(position.x, position.y);
	}

	public Optional<BerriesTile> nearestFood() {
		return world.nearestFoodTile(position.x, position.y);
	}

	public Optional<EmptyTile> randomEmptyTile() {
		return world.getEmptyTileForHouse();
	}

	public void buildHouse(int x, int y) {
		HouseTile house = new HouseTile(x, y);
		world.placeTile(house);
		this.house = Optional.of(house);
	}

	public class Need {
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

		public void fulfill() {
			value -= 5;
			if (value < min) {
				value = min;
			}
		}

		public boolean isEmpty() {
			return value == min;
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

	public class Resource {
		int min = 0;
		int max = 10;
		int value = 0;

		public boolean isFull() {
			return value >= max;
		}

		public boolean isEmpty() {
			return value <= min;
		}

		public void increase() {
			value++;
			if (value >= max) {
				value = max;
			}
		}

		public boolean decrease() {
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
