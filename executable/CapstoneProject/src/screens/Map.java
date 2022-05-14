package screens;
import main.*;
import processing.core.PImage;

import java.awt.Rectangle;
import java.util.List;

import characters.*;
public class Map extends Screen
{
		
		private DrawingSurface surface;
		
		private Rectangle screenRect;

		private List<Sprite> obstacles;

		public Map(DrawingSurface surface) {
			super(800, 800);
			this.surface = surface;
		}


		// The statements in the setup() function 
		// execute once when the program begins
		public void setup() {
//			spawnNewMario();
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

		}

		

}