package com.malcolmcrum.berlinminijamjan2016.humanstates;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.tiles.BerriesTile;

/**
 * Created by crummy on 11.01.16.
 */
public class GoEat extends HumanState {
	@Override
	public HumanState perform(Human human) {
		if (human.nearestFood().isPresent()) {
			BerriesTile food = human.nearestFood().get();
			float distance = Vector2.dst(food.x, food.y, human.getX(), human.getY());
			if (distance < 0.2) {
				return new Eat(food);
			} else {
				human.moveTowards(food);
				return this;
			}
		} else {
			return null;
		}
	}

	private class Eat extends HumanState {
		private BerriesTile food;

		public Eat(BerriesTile food) {
			this.food = food;
		}

		@Override
		public HumanState perform(Human human) {
			if (human.food.isFull()) {
				return null;
			} else if (food.hasBerries()) {
				food.getBerries();
				human.food.increase();
				return this;
			} else {
				return new GoEat();
			}
		}
	}
}
