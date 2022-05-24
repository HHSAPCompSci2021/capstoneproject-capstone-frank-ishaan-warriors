package characters;


import java.util.List;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Mario class represents a Mario character that is drawn by an imported image and user controlled by the arrow keys.
 * It is a Sprite and can act and move or use its special ability, which is to become invisible.
 * 
 * 
 * @author frank_an and Ishaan_Musunuri
 * @version 5/23/22
 *  */
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
	 * Changes the image of Bob to invisible mode
	 */
	public void special(PApplet surface) {
		specialImgName = "image/marioInvisible.png";
		super.special(surface);
	}

	/**
	 * Allows Mario to move, which doesn't allow the other Mario to attack(deal damage) to Bob
	 * @param obstacles - obstacles that Mario may encounter on the map 
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
