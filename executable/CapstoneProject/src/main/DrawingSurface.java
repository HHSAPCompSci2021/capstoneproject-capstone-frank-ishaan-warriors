package main;
import java.util.ArrayList;
import java.awt.*;

import processing.core.PApplet;
import processing.event.MouseEvent;
import screens.*;

/**
 * DrawingSurface class represents the screen or window in which the game is drawn upon which switches the screen based on user input and clicking.
 * The class holds all the screens in a ArrayList and the class can switch screens, set it back to default height and width limits, draw, figure out
 * if a key is pressed or released, figure out if anything happens to the mouse, switch from assumed coordinates to actual coordinates and vise versa.
 * 
 * @author Ishaan Musunuri and Frank An
 * @version 05/23/22
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher
{
	
public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	/**
	 * Initializes a DrawingSurface with an ArrayList of the 4 screens and the keys for the screens and the activeScreen.
	 * 
	 */
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
	
	/**
	 * Switches to a certain screen that is wanted.
	 *  
	 * @param i the number of Screen that you want to switch to - 1
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
	
	/**
	 * Sets the screen back to default settings.
	 *  
	 */
	public void settings() {
		  size(800, 600);
	}
	
	/**
	 * Draws the screen onto the window.
	 *  
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	/**
	 * If escape key is pressed, once the method is run, the program doesn't close.
	 *  
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
	}

	/**
	 *  Removes the key pressed from the key list if the key is released.
	 *  
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}
	
	/**
	 *  Checks if a certain key is pressed.
	 *  
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 *  Checks if left mouse is clicked.
	 *  
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 *  Checks if mouse moved.
	 *  
	 */
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	/**
	 *  Checks if mouse is held down and moved (dragged).
	 *  
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	/**
	 *  Checks if mouse is released from click.
	 *  
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/**
	 *  Gets the point from the default coordinates to the new border setting coordinates.
	 *  
	 *  @param assumed the assumed coordinates of the window with its coordinates
	 *  @return the point on the default coordinates of the window
	 *  
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}
	/**
	 *  Gets the point from the new border setting coordinates to the default coordinates.
	 *  
	 *  @param the point on the default coordinates of the window
	 *  @return assumed the assumed coordinates of the window with its coordinates
	 *  
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

}