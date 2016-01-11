package com.malcolmcrum.berlinminijamjan2016.actions;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.World;
import com.malcolmcrum.berlinminijamjan2016.tiles.HouseTile;
import com.malcolmcrum.berlinminijamjan2016.tiles.TreeTile;

/**
 * Created by crummy on 10.01.16.
 */
public class GoToSleep extends Action {

	@Override
	public Action perform(Human human, World world) {
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
			return new GoToTree().perform(human, world);
		}
	}

	public class GoToHouse extends Action {
		@Override
		public Action perform(Human human, World world) {
			human.sleepNeed.fulfill();
			if (human.sleepNeed.isEmpty()) {
				return null;
			} else {
				return this;
			}
		}
	}

	private class GoToTree extends Action {
		@Override
		public Action perform(Human human) {
			if (human.nearestTree().isPresent()) {
				TreeTile tree = human.nearestTree().get();
			}
		}
	}
}