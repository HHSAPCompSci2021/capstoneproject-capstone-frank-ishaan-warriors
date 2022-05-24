package characters;


import processing.core.PApplet;
import processing.core.PImage;
import franklin.shapes.*;
/**
 * The Weapon class represents a laser gun that is a Sprite and Mario and Bobs can fire the Sprite once they pick it up as a special ability for a one time use
 * that deals 200 damage at once on the other Sprite. It spawns in when a Mario or Bob has less than 500 health and can shoot.
 * 
 * @version 05/21/22
 * @author Frank An
 *
 */
public class Weapon extends Sprite {
	
	
	/**
	 * Initializes a Weapon with a given PImage (img), given center (x,y) and health.
	 * 
	 * @param img PImage that is drawn onto the DrawingSurface of the game that represents the Weapon.
	 * @param x X-coordinate of top left center.
	 * @param y Y-coordinate of top left center.
	 * @param health health of the Weapon.
	 */
	public Weapon(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
	}

	// METHODS
	/**
	 * Displays a laser that comes out of the weapon.laser does 200 damage to the character it's being shot at.
	 *  
	 * @param surface
	 * @param mx - x coordinate of the mouse click on the screen
	 * @param my - y coordinate of the mouse click on the screen 
	 * @param l  - character that is shooting
	 * @param t - character that is being shot at
	 */
	public void shoot(PApplet surface, double mx, double my, Sprite l, Sprite t) {
		l.setW(false);
	//	surface.line
		surface.stroke(255, 0 , 0);
		surface.strokeWeight(40);
		surface.line((float)l.getX(), (float)l.getY(), (float)mx, (float)my);
		Line laser = new Line((float)l.getX(), (float)l.getY(), (float)mx, (float)my);
		Line a = new Line (t.getX(), t.getY(), t.getX() + t.width, t.getY());
		Line b = new Line (t.getX() + t.width, t.getY(), t.getX() + t.width, t.getY() + t.height);
		Line c = new Line (t.getX() + t.width, t.getY() + t.height, t.getX(), t.getY() + t.height);
		Line d = new Line (t.getX(), t.getY(), t.getX(), t.getY() + t.height);
		if (laser.intersects(a) || laser.intersects(b) || laser.intersects(c) || laser.intersects(d)) {
			t.health -= 200;
		}
	}
	
}
