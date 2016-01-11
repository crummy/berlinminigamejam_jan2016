package com.malcolmcrum.berlinminijamjan2016.actions;

import com.malcolmcrum.berlinminijamjan2016.Human;

/**
 * Created by crummy on 10.01.16.
 */
public class Pray extends Action {
	@Override
	public Action perform(Human human) {
		human.didPray();
		return null;
	}
}
