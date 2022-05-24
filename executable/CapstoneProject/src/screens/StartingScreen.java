package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;
import processing.core.PImage;
/**
 * 
 * @author Frank An and Ishaan Musunuri
 * @version 5/17/22
 * 
 *
 */
public class StartingScreen extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;
	/**
	 * Initializes a new screen
	 * @param surface -  The Processing PApplet on which to draw the Sprite.
	 */
	public StartingScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	/**
	 * Displays the starting screen of the program
	 */
	public void draw() {
		PImage img;
		img = surface.loadImage("image/warriorgame.jpg");
		img.resize(surface.width,surface.height);
		surface.background(img);
		surface.fill(255, 0, 0);
		surface.textAlign(surface.CENTER);
		surface.textSize(50);
		surface.text("ECLPISE WARRIORS", 400, 100);
		//surface.noFill();
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "2 Player Mode";
		surface.textSize(20);
		surface.fill(255);
		surface.text(str, button.x + button.width/2, button.y + button.height/2);
		
	}



	/**
	 * When the 2 Player Mode button is pressed, then the instructions screen will appear
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
	

}

