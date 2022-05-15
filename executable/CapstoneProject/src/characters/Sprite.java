package characters;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;

public class Sprite extends Rectangle2D.Double
{
	/*private double health;
	private double damage;
	private int attackPow;
	private int defensePow;
	
	
	// FIELDS
		private PImage image;
		
		// CONSTRUCTORS
		
		public Sprite(int x, int y, int w, int h) {
			this(null, x, y, w, h);
		}
		
		public Sprite(PImage img, int x, int y, int w, int h) {
			super(x,y,w,h);
			image = img;
		}
		
	public Sprite(double health, double damage, int defensePow, int attackPow)
	{
		this.health = health;
		this.attackPow = attackPow;
		this.defensePow = defensePow;
		this.damage = damage;
	}
	
	public void doDamage() {
		damage -= 5;
	}
	/** 
	 * 
	 * @return health of the sprite
	 *//*
	 public double getHealth()
	 {
		 return health;
	 }
	 /** 
		 * 
		 * @return damage of the sprite
		 *//*
	 public double getDamage()
	 {
		 return health;
	 }
	 /** 
		 * 
		 * @return attack power of the sprite
		 *//*
	public int getAttackPow() {
		return attackPow;
	}
	/** 
	 * 
	 * @return defense power of the sprite
	 *//*
	public int getDefensePow() {
		return defensePow;
	}
	
	public void moveX(int moveBy)
	{
		
	}
	
	public void moveY(int moveBy)
	{
		
	}*/
	private PImage image;
	
	// CONSTRUCTORS
	
	public Sprite(int x, int y, int w, int h) {
		this(null, x, y, w, h);
	}
	
	public Sprite(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	
	// METHODS	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
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
}

