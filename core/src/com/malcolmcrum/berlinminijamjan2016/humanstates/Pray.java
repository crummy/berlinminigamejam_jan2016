package com.malcolmcrum.berlinminijamjan2016.humanstates;

import com.malcolmcrum.berlinminijamjan2016.Human;

/**
 * Created by crummy on 10.01.16.
 */
public class Pray extends HumanState {
	@Override
	public HumanState perform(Human human) {
		human.didPray();
		return null;
	}
}
