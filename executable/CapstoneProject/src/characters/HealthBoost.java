package characters;


import processing.core.PApplet;
import processing.core.PImage;

public class HealthBoost extends Sprite {

	private double xVel, yVel;

	public HealthBoost(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS
	public void spawn() {
		
	}
	
}
