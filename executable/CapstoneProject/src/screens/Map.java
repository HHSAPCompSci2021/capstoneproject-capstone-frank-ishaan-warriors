package screens;
import main.*;

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
			
			// drawing stuff
			
			surface.background(0,255,255);   

		//	for (Sprite s : obstacles) {
//				s.draw(surface);
			//}

		//	mario.draw(surface);

			
			// modifying stuff

		/*	if (surface.isPressed(KeyEvent.VK_ESCAPE)) {
				surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
				return;
			}
			if (surface.isPressed(KeyEvent.VK_LEFT))
				mario.walk(-1);
			if (surface.isPressed(KeyEvent.VK_RIGHT))
				mario.walk(1);
			if (surface.isPressed(KeyEvent.VK_UP))
				mario.jump();

			mario.act(obstacles);

			if (!screenRect.intersects(mario))
				spawnNewMario();*/

		}

		

}