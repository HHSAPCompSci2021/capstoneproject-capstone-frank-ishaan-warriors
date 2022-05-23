package characters;


import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Frank An
 *@version 05/21/22
 */
public class HealthBoost extends Sprite {

	public HealthBoost(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
	}

	// METHODS
	public void spawn() {
		
	}
	
}