package characters;


import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Ishaan Musunuri, Frank An
 * @version 05/18/22
 * 
 *
 */
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
	/**
	 * allows  Bob to move 
	 * @param obstacles - obstacles that Bob my encounter on the map 
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
	 * changes the image of Bob to invisible mode
	 */
	public void special(PApplet surface) {
		specialImgName = "image/bobInvisible.png";
		super.special(surface);
	}

}