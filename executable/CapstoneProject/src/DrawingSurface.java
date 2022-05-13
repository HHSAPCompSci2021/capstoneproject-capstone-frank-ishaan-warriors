import processing.core.PApplet;
import processing.event.MouseEvent;
import screens.ScreenSwitcher;

public class DrawingSurface extends PApplet implements ScreenSwitcher
{
	public void mouseReleased() 
	{
		//.move(mouseX, mouseY);
	}
	//This method enlarges the sun to th==e point where it becomes a red giant (then you can scroll down). It is called when you scroll. 
	public void mouseWheel(MouseEvent event) 
	{
		
	}
	//This method will be called when the left, right, up, and down arrow key are pressed.  
	public void keyPressed()
	{
//		if(key == CODED) 
//		{
//			if(keyCode == UP)//House scales up if UP arrow is pressed
//			{
//				scale += (float)0.1;
//			} 
//			else
//			{
//				if(keyCode == DOWN)///House scales down if DOWN arrow is pressed
//				{
//					scale -= (float) 0.1;
//				}
//			}
//			if(key == CODED) {
//				if(keyCode == LEFT)//Person moves 10 units to the left when LEFT arrow is pressed
//				{
//					person.move(-10);
//					
//				} 
//				else
//				{
//					if(keyCode == RIGHT)//Person moves 10 units to the right when RIGHT arrow is pressed. 
//					{
//						person.move(10);
//						
//					}
//				}
//				
//			}
//		}

	}
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}