package characters;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;

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
	 * @param x - x coordinate of location
	 * @param y - y coordinate of location
	 */
	public void moveToLocation(double x, double y) {

		super.x=x;
		super.y=y;
	}
	/**
	 * Moves sprite by x and y amount
	 * @param x - amount that should be moved on the x axis. 
	 * @param y
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	/**
	 * Sets the limits of a window
	 * @param windowWidth - width of the window
	 * @param windowHeight - height of the window 
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	/**
	 * Moves sprite up
	 */
	public void up() {
		moveByAmount(0, -15);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * Moves sprite down
	 */
	public void down() {
		moveByAmount(0, 15);
		applyWindowLimits(2000, 2000);
	}
	/**
	 * moves sprite to the write
	 */
	public void right() {
		moveByAmount(15, 0);
		applyWindowLimits(2000, 2000);
	}
/**
 * moves sprite to the left
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
 * Special move of the sprite; invisiblity. Changes the sprite's image to an "invisible" version
 * @param surface
 */
	public void special(PApplet surface) {
		image = surface.loadImage(specialImgName);
		invis = true;
	}
	/**
	 * gets x value
	 * @return - x: x-value
	 */
	public double getX() {
		return x;
	}
	/**
	 * gets y value
	 * @return - y: y-value
	 */
	public double getY() {
		return y;
	}
	/**
	 * Method for sprite attacks
	 * @param other - the sprite that is being attacked
	 */
	public void attack(Sprite other) 
	{
		// TODO Auto-generated method stub
		if (this.intersects(other) && (other instanceof Mario || other instanceof Bob)) {
		//	System.out.println("touch");
			other.health -= (int)(Math.random() * 10);
			//System.out.println(other.health);
		}
		
		if (!weaponUsed && other instanceof Weapon) {
			System.out.println("touch");
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
	
	public boolean getW() {
		return this.hasW;
	}
	
	public void setW(boolean w) {
		this.hasW = w;
	}
}

