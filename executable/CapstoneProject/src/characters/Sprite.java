package characters;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Ishaan Musunuri and Frank An
 * @version 05/21/22
 */
public class Sprite extends Rectangle2D.Double
{
	private PImage image;
	protected int health;
	protected String specialImgName;
	protected int use = 3;
	private boolean invis;
	private boolean hasW;
	private boolean weaponUsed;
	
	// CONSTRUCTORS
	
	public Sprite(int x, int y, int w, int h, int health) {
		this(null, x, y, w, h, health);
	}
	
	public Sprite(PImage img, int x, int y, int w, int h, int health) {
		super(x,y,w,h);
		image = img;
		this.health = health;
		invis = false;
		hasW = false;
		weaponUsed = false;
	}
	
	// METHODS	
	/**
	 * Moves Sprite to specified location
	 * 
	 * @pre x and y coordinates are inside the window limits set in the applyWindowLimits() method
	 * @param x - x coordinate of new location
	 * @param y - y coordinate of new location
	 */
	public void moveToLocation(double x, double y) {
		super.x=x;
		super.y=y;
	}
	
	/**
	 * Moves sprite by x and y amount
	 * @param x - amount that should be moved on the x axis. 
	 * @param y - amount that should be moved on the y axis.
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Sets the borders of the window
	 * 
	 * @param windowWidth - width of the window
	 * @param windowHeight - height of the window 
	 * @post the characters can't move outside the window
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	/**
	 * Draws the Sprite onto the DrawingSurface using the image field.
	 * 
	 * @param g The Processing PApplet on which to draw the Sprite.
	 */
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	
	/**
	 * Moves sprite up by 15
	 */
	public void up() {
		moveByAmount(0, -15);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * Moves sprite down by 15
	 */
	public void down() {
		moveByAmount(0, 15);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * Moves sprite to the right by 15
	 */
	public void right() {
		moveByAmount(15, 0);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * Moves sprite to the left by 15
	 */
	public void left() {
		moveByAmount(-15, 0);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * sets the health of the sprite
	 * @param h - health that is being set
	 */
	public void setHealth(int h)
	{
		health=h;
	}
	/**
	 * Special move of the sprite; invisiblity. Changes the sprite's image to an "invisible" version, where other Sprites can't attack it.
	 * @param surface - The Processing PApplet on which to draw the Sprite.
	 */
	public void special(PApplet surface) {
		image = surface.loadImage(specialImgName);
		invis = true;
	}
	/**
	 * gets x value of Sprite
	 * @return - x: x-value
	 */
	public double getX() {
		return x;
	}
	/**
	 * gets y value of Sprite
	 * @return - y: y-value
	 */
	public double getY() {
		return y;
	}
	/**
	 * Method for sprite attacks, where this Sprite deals a random amount of damage to the other Sprite from 1-10.
	 * If the other sprite is a Weapon, the weapon is transported into the hands of this Sprite and the Sprite can fire one laser shot.
	 * If the other sprite is a HealthBoost, this Sprite gains 50 health.
	 * 
	 * @post Other sprite changes image. 
	 * @post This sprite gains health or hasW turns to true.
	 * @param other - the sprite that is being attacked
	 */
	public void attack(Sprite other) 
	{
		if (this.intersects(other) && (other instanceof Mario || other instanceof Bob)) {
			other.health -= (int)(Math.random() * 10);
		}
		
		if (!weaponUsed && other instanceof Weapon) {
			if (this instanceof Mario) {
				other.moveToLocation(2000-50-50, 10);
				this.hasW = true;
			} else {
				other.moveToLocation(10, 10);
				this.hasW = true;
			}
			weaponUsed = true;
		}
		
		if (other instanceof HealthBoost) {
			other.moveToLocation(200 + (int)(Math.random() * 1600), 200 +(int)(Math.random() * 1600));
			this.health += 50;
		}
	}
	/**
	 * 
	 * @return - returns the health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * 
	 * @return - returns true if the sprite is invisible
	 */
	public boolean getI() {
		return invis;
	}
	
	/**
	 * 
	 * @return - returns true if the sprite has a weapon that can be fired
	 */
	public boolean getW() {
		return this.hasW;
	}
	/**
	 * @param w - sets hasW to true if the weapon has been acquired by this Sprite and sets to false if weapon has been fired
	 */
	public void setW(boolean w) {
		this.hasW = w;
	}
}

