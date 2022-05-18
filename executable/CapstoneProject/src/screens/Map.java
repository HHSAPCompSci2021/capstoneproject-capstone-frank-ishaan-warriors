package screens;
import main.*;
import processing.core.PImage;
import characters.*;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Map extends Screen
{
		
		private DrawingSurface surface;
		
		private Rectangle screenRect;
		private Mario a;
		private Bob b;
		private List<Sprite> obstacles;
		private int aTime = 0, bTime = 0;
		private boolean aSpecial = false, bSpecial = false;
		private int aUse = 3, bUse = 3;
		private Weapon c;

		public Map(DrawingSurface surface) {
			super(2000, 2000);
			this.surface = surface;
			screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
			obstacles = new ArrayList<Sprite>();
		}

		public void spawnNewBob(int x, int y, int h) {
			b = new Bob(surface.loadImage("image/pigs.png"),x,y, h);
		}
		
		public void spawnNewMario(int x, int y, int h) {
			a = new Mario(surface.loadImage("image/big3.jpg"),x,y, h);
		}
		
		public void spawnWeapon(int x, int y) {
			c = new Weapon(surface.loadImage("image/taswer.png"), x, y, 1000);
		}

		// The statements in the setup() function 
		// execute once when the program begins
		public void setup() {
			spawnNewMario(500, 250, 1000);
			spawnNewBob(100, 250, 1000);
		}

		// The statements in draw() are executed until the 
		// program is stopped. Each statement is executed in 
		// sequence and after the last line is read, the first 
		// line is executed again.
		public void draw() {
			PImage img;
			img = surface.loadImage("image/ab.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
			// drawing stuff
			if (c == null)
				spawnWeapon(950, 970);
			if (a == null) {
				spawnNewMario(500, 250, 1000);
		    }
			if (b == null) {
				spawnNewBob(100, 250,1000);
			}
			surface.fill(0);
			surface.rect(165,0, 300, 200, 10, 10, 10, 10);
			Integer h1 = b.getHealth();
			String str = h1.toString();
			surface.fill(4, 150, 7);
			surface.textSize(100);
			surface.text(str, 185, 137);
			
			surface.fill(0);
			surface.rect(2000 - 165-300 - 20,0, 300, 200, 10, 10, 10, 10);
			Integer h2 = a.getHealth();
			String str2 = h2.toString();
			surface.fill(4, 150, 7);
			surface.textSize(100);
			surface.text(str2, 1000 + 500 + 50, 137);
			if (aSpecial) {
			    aTime++;
			    if (aTime == 200) {
			    	spawnNewMario((int)a.getX(), (int)a.getY(), a.getHealth());
			    	aSpecial = false;
			    	aUse--;
			    }
			}
			if (bSpecial) {
			    bTime++;
			    if (bTime == 200) {
			    	spawnNewBob((int)b.getX(), (int)b.getY(), b.getHealth());
			    	bSpecial = false;
			    	bUse--;
			    }
			}
			a.draw(surface);
			b.draw(surface);
			if (a.getHealth() < 500 || b.getHealth() < 500) {
				c.draw(surface);
		    }
			if (surface.isPressed(KeyEvent.VK_UP)) {
				b.up();
			}
			if (surface.isPressed(KeyEvent.VK_DOWN)) {
				b.down();
			}
			if (surface.isPressed(KeyEvent.VK_RIGHT)) {
				b.right();
			}
			if (surface.isPressed(KeyEvent.VK_LEFT)) {
				b.left();
			}
			
			if (surface.isPressed(KeyEvent.VK_W)) {
				a.up();
			}
			if (surface.isPressed(KeyEvent.VK_A)) {
				a.left();
			}
			if (surface.isPressed(KeyEvent.VK_S)) {
				a.down();
			}
			if (surface.isPressed(KeyEvent.VK_D)) {
				a.right();
			}
			if (surface.mousePressed && a.getW()) {
				System.out.println("a");
			}
			if(surface.isPressed(KeyEvent.VK_Q)) {
				if (!(b.getI())) {
					a.attack(b);
					a.attack(c);
					if (b.getHealth() <= 0)
						surface.switchScreen(3);
				}
			}
			
			if (surface.isPressed(KeyEvent.VK_CONTROL)) {
				if (!(a.getI())) {
					b.attack(a);
					b.attack(c);
					if (a.getHealth() <= 0)
						surface.switchScreen(4);
				}
			}
			
			if (surface.isPressed(KeyEvent.VK_E) && !aSpecial && aUse > 0) {
				a.special(surface);
				aTime = 0;
				aSpecial = true;
			}
			
			if (surface.isPressed(KeyEvent.VK_SHIFT) && !bSpecial && bUse > 0) {
				b.special(surface);
				bTime = 0;
				bSpecial = true;
			}
		}
}