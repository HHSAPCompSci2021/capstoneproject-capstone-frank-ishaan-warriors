package main;
import java.util.ArrayList;
import java.awt.*;

import processing.core.PApplet;
import processing.event.MouseEvent;
import screens.*;

/**
 * 
 * @author Ishaan Musunuri
 *@version 05/19/22
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher
{
	
public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	public DrawingSurface()
	{
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		
		StartingScreen screen1 = new StartingScreen(this);
		screens.add(screen1);
		
		Instruction screen2 = new Instruction(this);
		screens.add(screen2);
		
		Map screen3 = new Map(this);
		screens.add(screen3);
		
		EndScreen screen4 = new EndScreen(this, true);
		screens.add(screen4);
		
		EndScreen screen5 = new EndScreen(this, false);
		screens.add(screen5);
		
		activeScreen = screens.get(0);
	}
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	public void settings() {
		  size(800, 600);
	}
	
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

}