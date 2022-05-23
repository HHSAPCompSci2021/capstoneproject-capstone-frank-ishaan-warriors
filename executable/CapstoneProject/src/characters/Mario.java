package characters;


import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 250;
	public static final int MARIO_HEIGHT = 300;

	private double xVel, yVel;

	public Mario(PImage img, int x, int y, int health) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS
	/**
	 * changes the image of Bob to invisible mode
	 */
	public void special(PApplet surface) {
		specialImgName = "image/marioInvisible.png";
		super.special(surface);
	}

	/**
	 * allows  Mario to move 
	 * @param obstacles - obstacles that Mario my encounter on the map 
	 */
	public void act(List<Sprite> obstacles) {
		
		x += xVel;
		y += yVel;
		
		for(Sprite s : obstacles) {
			if (s.intersects(this)) {
				yVel = 0;
				super.y = s.y - super.height;
			}
		}
		

	}


}
