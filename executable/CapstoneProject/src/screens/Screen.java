package screens;
 /**
  * 
  * @author Ishaan Musunuri
  *@version 05/11/22
  */
public abstract class Screen {

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	/**
	 * Initializes a new screen with width w and height h
	 * @param width - width of screen
	 * @param height - height of screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	/**
	 * Implementation of setup method
	 */
	public void setup() {
		
	}
	/**
	 * Implementation of draw method
	 */
	public void draw() {
		
	}
	/**
	 * Implementation of mousePressed method
	 */
	public void mousePressed() {
		
	}
	/**
	 * Implementation of mouseMoved method
	 */
	public void mouseMoved() {
		
	}
	/**
	 * Implementation of mouseDragged method
	 */
	public void mouseDragged() {
		
	}
	/**
	 * Implementation of mouseReleased method
	 */
	public void mouseReleased() {
		
	}
	
	
	
}
