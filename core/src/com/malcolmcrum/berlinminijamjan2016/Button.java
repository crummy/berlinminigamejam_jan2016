package com.malcolmcrum.berlinminijamjan2016;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by crummy on 13.01.16.
 */
public class Button {
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle rectangle;

	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		generateRectangle();
	}

	private void generateRectangle() {
		this.rectangle = new Rectangle(x, y, width, height);
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
}
