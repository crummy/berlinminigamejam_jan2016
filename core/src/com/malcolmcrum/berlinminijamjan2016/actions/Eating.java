package com.malcolmcrum.berlinminijamjan2016.actions;

import com.malcolmcrum.berlinminijamjan2016.Human;

/**
 * Created by crummy on 11.01.16.
 */
public class Eating extends Action {
	public static GoToFood goToFood = new GoToFood();

	@Override public Action perform(Human human) {
		return null;
	}

	private class GoToFood extends Action {

		@Override public Action perform(Human human) {
			return null;
		}
	}
}
