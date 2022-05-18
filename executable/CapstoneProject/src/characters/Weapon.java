package characters;


import java.awt.geom.Rectangle2D;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class Weapon extends Sprite {

	public static final int MARIO_WIDTH = 250;
	public static final int MARIO_HEIGHT = 300;

	private double xVel, yVel;

	public Weapon(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS

}
