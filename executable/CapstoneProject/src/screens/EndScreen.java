package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;
import processing.core.PImage;
/**
 * End screen of the game. Shown after one of the users has 0 health. There will be a play again button on the bottom of the screen. 
 * 
 * @author Frank An
 *@version 5/23/22
 */
public class EndScreen extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;
	private boolean win;
/**
		 * Initializes a screen with the dimensions 2000x2000
		 * @param surface The Processing PApplet on which to draw the Sprite.
		 * @param win - if Mario wins, win is true. If Bob wins, win is false
		 */
	public EndScreen(DrawingSurface surface, boolean win) {
		super(800,600);
		this.surface = surface;
		this.win = win;
		button = new Rectangle(350, 500, 100,100);
	}
/**
 * Draws the end screen of the game
 */
	public void draw() {
		if (win) {
			PImage img;
			img = surface.loadImage("image/dubswin.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
			surface.fill(0, 0, 255);
			surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
			String str = "AGAIN???";
			surface.textSize(20);
			surface.fill(255);
			surface.text(str, button.x, button.y + button.height/2);
		} else {
			PImage img;
			img = surface.loadImage("image/angrywin.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
			surface.fill(0, 0, 255);
			surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
			String str = "AGAIN???";
			surface.textSize(20);
			surface.fill(255);
			surface.text(str, button.x, button.y + button.height/2);
		}
	}
	/**
	 * When the 
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(2);
	}

}