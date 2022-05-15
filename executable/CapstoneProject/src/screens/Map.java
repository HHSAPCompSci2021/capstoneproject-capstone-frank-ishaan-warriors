package screens;
import main.*;
import processing.core.PImage;
import characters.*;

import java.awt.Rectangle;
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
			super(800, 800);
			this.surface = surface;
			screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
			obstacles = new ArrayList<Sprite>();
		}

		public void spawnNewMario() {
			a = new Mario(surface.loadImage("image/mario.png"), DRAWING_WIDTH/2-Mario.MARIO_WIDTH/2,50);
		}

		// The statements in the setup() function 
		// execute once when the program begins
		public void setup() {
		//	spawnNewMario();
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
			a = new Mario(surface.loadImage("image/big3.jpg"),100,250);
			a.draw(surface);
			b = new Bob(surface.loadImage("image/pigs.png"), 500, 250);
			b.draw(surface);
		}

		

}