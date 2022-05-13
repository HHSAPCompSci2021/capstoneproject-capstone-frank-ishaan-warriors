package main;
import java.util.ArrayList;
import java.awt.*;

import processing.core.PApplet;
import processing.event.MouseEvent;
import screens.Screen;
import screens.ScreenSwitcher;

public class DrawingSurface extends PApplet implements ScreenSwitcher
{
	
public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}