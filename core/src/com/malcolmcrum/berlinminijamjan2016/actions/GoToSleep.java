package com.malcolmcrum.berlinminijamjan2016.actions;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.tiles.EmptyTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.HouseTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.TreeTile;

import java.util.Optional;

/**
 * Created by crummy on 10.01.16.
 */
public class GoToSleep extends Action {

	@Override
	public Action perform(Human human) {
		if (human.getHouse().isPresent()) {
			HouseTile house = human.getHouse().get();
			float distanceToHouse = Vector2.dst(human.getX(), human.getY(), house.x, house.y);
			if (distanceToHouse < 0.2) {
				return new GoToSleep();
			} else {
				human.moveTowards(house);
				return this;
			}
		} else {
			return new GoToTree().perform(human);
		}
	}

	public class GoToTree extends Action {
		@Override
		public Action perform(Human human) {
			if (human.nearestTree().isPresent()) {
				TreeTile tree = human.nearestTree().get();
				float distanceToTree = Vector2.dst(human.getX(), human.getY(), tree.x, tree.y);
				if (distanceToTree < 0.2) {
					return new ChopWood(tree);
				} else {
					human.moveTowards(tree);
					return this;
				}
			} else {
				return null;
			}
		}
	}

	public class ChopWood extends Action {
		private final TreeTile tree;

		public ChopWood(TreeTile tree) {
			this.tree = tree;
		}

		@Override
		public Action perform(Human human) {
			if (human.wood.isFull()) {
				return new FindHouseTile();
			} else if (tree.hasWood()) {
				tree.getWood();
				human.wood.increase();
				return this;
			} else {
				return new GoToTree();
			}
		}
	}

	public class FindHouseTile extends Action {
		Optional<EmptyTile> tile = null;

		@Override
		public Action perform(Human human) {
			tile = tile.isPresent() ? tile : human.randomEmptyTile();
			if (tile.isPresent()) {
				float distance = Vector2.dst(tile.get().x, tile.get().y, human.getX(), human.getY());
				if (distance < 0.2) {
					return new BuildHouse(tile.get());
				} else {
					human.moveTowards(tile.get());
					return this;
				}
			} else {
				return null;
			}
		}
	}

	private class BuildHouse extends Action {
		public EmptyTile tile;
		public BuildHouse(EmptyTile tile) {
			this.tile = tile;
		}

		@Override
		public Action perform(Human human) {
			human.buildHouse(tile.x, tile.y);
			return new Sleep();
		}
	}

	private class Sleep extends Action {
		@Override
		public Action perform(Human human) {
			human.sleepNeed.fulfill();
			if (human.sleepNeed.isEmpty()) {
				return null;
			} else {
				return this;
			}
		}
	}
}