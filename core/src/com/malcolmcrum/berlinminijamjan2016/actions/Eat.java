package com.malcolmcrum.berlinminijamjan2016.actions;

import com.malcolmcrum.berlinminijamjan2016.Human;
import com.malcolmcrum.berlinminijamjan2016.World;

/**
 * Created by crummy on 11.01.16.
 */
public class Eat extends Action {
	@Override
	public Action perform(Human human) {
		return null;
	}

	private class GoToFood extends Action {

		@Override public Action perform(Human human) {
			return null;
		}
	}
}
