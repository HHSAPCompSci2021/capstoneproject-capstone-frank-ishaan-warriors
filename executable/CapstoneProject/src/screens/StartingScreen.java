package screens;
import java.awt.Point;
import java.awt.Rectangle;
import main.DrawingSurface;

public class StartingScreen extends Screen {
	private DrawingSurface surface;
	
	private Rectangle button;

	public StartingScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(800/2-100,600/2-50,200,100);
	}


	public void draw() {
		String name = "ECLIPSE WARRIORS";
		surface.background(255,255,255);
		surface.fill(0);

		surface.text(name, 200,50);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "Click me!";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		
	}



	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
	

}

