package characters;


import java.awt.geom.Rectangle2D;
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
	public void special(PApplet surface) {
		specialImgName = "image/sad.jpg";
		super.special(surface);
	}

	public void act(List<Sprite> obstacles) {
	//	yVel += 0.2;
		
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
