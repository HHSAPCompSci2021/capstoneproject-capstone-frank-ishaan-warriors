package characters;


import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * The Bob class represents a Bob character that is drawn by an imported image and user controlled by the arrow keys.
 * It is a Sprite and can act and move or use its special ability, which is to become invisible.
 * 
 * 
 * @author Ishaan Musunuri, Frank An
 * @version 05/23/22
 * 
 *
 */
public class Bob extends Sprite {

	public static final int BOB_WIDTH = 250;
	public static final int BOB_HEIGHT = 300;
	private double xVel, yVel;
	
	/**
	 * Initializes a Bob with a given PImage (img), given center (x,y) and health.
	 * 
	 * @param img PImage that is drawn onto the DrawingSurface of the game that represents the Bob.
	 * @param x X-coordinate of top left center.
	 * @param y Y-coordinate of top left center.
	 * @param health health of the Bob.
	 */
	public Bob(PImage img, int x, int y, int health) {
		super(img, x, y, BOB_WIDTH, BOB_HEIGHT, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS
	/**
	 * Allows Bob to move 
	 * @param obstacles - obstacles that Bob may encounter on the map (didn't have time to implement but wanted to add later)
	 */
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
	/**
	 * Changes the image of Bob to invisible mode, which doesn't allow the other Mario to attack(deal damage) to Bob
	 */
	public void special(PApplet surface) {
		specialImgName = "image/bobInvisible.png";
		super.special(surface);
	}

}