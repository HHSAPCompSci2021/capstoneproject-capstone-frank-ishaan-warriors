package characters;


import processing.core.PApplet;
import processing.core.PImage;
/**
 * The HealthBoost class represents a health pack that is similar to a first aid kit for the characters, allowing them to "attack" as ways of healing 50 points of health on the map.
 * The HealthBoost class is a Sprite.
 * 
 * @author Frank An
 * @version 05/23/22
 */
public class HealthBoost extends Sprite {
	
	/**
	 * Initializes a HealthBoost with a given PImage (img), given center (x,y) and health.
	 * 
	 * @param img PImage that is drawn onto the DrawingSurface of the game that represents the HealthBoost.
	 * @param x X-coordinate of top left center.
	 * @param y Y-coordinate of top left center.
	 * @param health health of the HealthBoost.
	 */
	public HealthBoost(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
	}
	
}