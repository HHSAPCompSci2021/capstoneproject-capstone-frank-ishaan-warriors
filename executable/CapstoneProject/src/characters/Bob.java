package characters;


import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

public class Bob extends Sprite {

	public static final int BOB_WIDTH = 250;
	public static final int BOB_HEIGHT = 300;

	private double xVel, yVel;

	public Bob(PImage img, int x, int y, int health) {
		super(img, x, y, BOB_WIDTH, BOB_HEIGHT, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS
	public void walk(int dir) {
		
	}

	public void jump() {
		
	}

	public void act(List<Sprite> obstacles) {
		yVel += 0.2;
		
		x += xVel;
		y += yVel;
		
		for(Sprite s : obstacles) {
			if (s.intersects(this)) {
				yVel = 0;
				super.y = s.y - super.height;
			}
		}
		
	}

	public void special(PApplet surface) {
		specialImgName = "image/angry.jpg";
		super.special(surface);
	}

}