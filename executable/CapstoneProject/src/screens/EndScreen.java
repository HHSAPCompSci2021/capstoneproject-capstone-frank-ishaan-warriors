package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;
import processing.core.PImage;

public class EndScreen extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;
	private boolean win;

	public EndScreen(DrawingSurface surface, boolean win) {
		super(800,600);
		this.surface = surface;
		this.win = win;
		button = new Rectangle(350, 500, 100,100);
	}

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
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(2);
	}

}