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
	
	// CONSTRUCTORS
	
	public Sprite(int x, int y, int w, int h, int health) {
		this(null, x, y, w, h, health);
	}
	
	public Sprite(PImage img, int x, int y, int w, int h, int health) {
		super(x,y,w,h);
		image = img;
		this.health = health;
	}
	
	
	// METHODS	
	public void moveToLocation(double x1, double y1) {

		x=x1;
		y=y1;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
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
	
	public void up() {
		moveByAmount(0, -15);
	}
	
	public void down() {
		moveByAmount(0, 15);
	}
	
	public void right() {
		moveByAmount(15, 0);
	}

	public void left() {
		moveByAmount(-15, 0);
	}
	
	public void special(PApplet surface) {
		image = surface.loadImage(specialImgName);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void attack(Sprite other) {
		// TODO Auto-generated method stub
		if (this.intersects(other)) {
			System.out.println("touch");
			other.health -= (int)(Math.random() * 10);
			System.out.println(other.health);
		}
	}
	
	public int getHealth() {
		return health;
	}
}

