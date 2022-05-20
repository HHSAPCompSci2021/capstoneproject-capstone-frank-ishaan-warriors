package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;
import processing.core.PImage;

public class Instruction extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;

	public Instruction(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(200, 450, 300,100);
	}

	public void draw() {
		PImage img;
		img = surface.loadImage("image/Instruction.jpg");
		img.resize(surface.width,surface.height);
		surface.background(img);
		surface.fill(255, 0, 0);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "PLAY NOW";
		surface.textSize(50);
		surface.fill(255);
		surface.text(str, 225, 450 + 60);
	}



	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(2);
	}
	

}
