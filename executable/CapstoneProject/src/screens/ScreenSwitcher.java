package screens;

/**
 * 
 * @author Ishaan Musunuri
 *@version 05/11/22
 */
public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	/**
	 * Implementation of switchScreen method
	 * @param i - screen number - 1
	 */
	public void switchScreen(int i);
}
