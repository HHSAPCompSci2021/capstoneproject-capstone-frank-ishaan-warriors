package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;
import processing.core.PImage;
/**
 * The instructions screen. Shown after the starting screen
 * 
 * @author Frank An
 *@version 05/23/22
 */
public class Instruction extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;
/**
 * Initializes a new screen
 * @param surface -  The Processing PApplet on which to draw the Sprite.
 */
	public Instruction(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(200, 475, 300,100);
	}
	/**
	 * Displays the instructions screen
	 */
	public void draw() {
		PImage img;
		img = surface.loadImage("image/Instruc.jpg");
		img.resize(surface.width,surface.height);
		surface.background(img);
		surface.fill(255, 0, 0);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "PLAY NOW";
		surface.textSize(50);
		surface.fill(255);
		surface.text(str, 225, 450 + 60 + 25);
	}



	/**
	 * When the Play Now button is pressed, the game will begin.
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(2);
	}
	

}
