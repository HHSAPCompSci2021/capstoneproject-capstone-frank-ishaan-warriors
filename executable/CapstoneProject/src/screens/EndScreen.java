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
		button = new Rectangle(200, 450, 300,100);
	}

	public void draw() {
		if (win) {
			PImage img;
			img = surface.loadImage("image/dubswin.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
		} else {
			PImage img;
			img = surface.loadImage("image/angrywin.jpg");
			img.resize(surface.width,surface.height);
			surface.background(img);
		}
	}

}