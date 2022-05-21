package characters;


import processing.core.PApplet;
import processing.core.PImage;
import franklin.shapes.*;

public class Weapon extends Sprite {

	public static final int MARIO_WIDTH = 250;
	public static final int MARIO_HEIGHT = 300;

	private double xVel, yVel;

	public Weapon(PImage img, int x, int y, int health) {
		super(img, x, y, 100,75, health);
		xVel = 0;
		yVel = 0;
	}

	// METHODS
	
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
