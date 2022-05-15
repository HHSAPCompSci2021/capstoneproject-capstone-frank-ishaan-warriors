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

		public Map(DrawingSurface surface) {
			super(2000, 2000);
			this.surface = surface;
			screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
			obstacles = new ArrayList<Sprite>();
		//	a = new Mario(surface.loadImage("image/big3.jpg"),100,250);
		//	b = new Bob(surface.loadImage("image/pigs.png"), 500, 250);
		}

		public void spawnNewMario() {
			b = new Bob(surface.loadImage("image/pigs.png"), 500, 250);
			a = new Mario(surface.loadImage("image/mario.png"), 100,250);
		}

		// The statements in the setup() function 
		// execute once when the program begins
		public void setup() {
			spawnNewMario();
			System.out.println("setup OK");
		}

		// The statements in draw() are executed until the 
		// program is stopped. Each statement is executed in 
		// sequence and after the last line is read, the first 
		// line is executed again.
		public void draw() {
			PImage img;
			img = surface.loadImage("image/a.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
			// drawing stuff
			if (a == null) {
				a = new Mario(surface.loadImage("image/big3.jpg"),100,250);
		    }
			if (b == null) {
				b = new Bob(surface.loadImage("image/pigs.png"), 500, 250);
			}	
			a.draw(surface);
			b.draw(surface);
			
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
			
			if (surface.isPressed(KeyEvent.VK_E)) {
				a.special(surface);
			}
		}

		

}