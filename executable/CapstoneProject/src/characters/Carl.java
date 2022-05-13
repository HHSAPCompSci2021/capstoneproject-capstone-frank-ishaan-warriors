package characters;

import java.util.List;

import processing.core.PImage;
import characters.Sprite;

public class Carl extends Sprite
{
	public static final int CARL_HEIGHT = 40;
	public static final int CARL_WIDTH = 60;
	int carlY, carlX;

	private double xVel, yVel;
	public Carl(PImage img, int x, int y) {
		carlY = y;
		carlX = x;
		super(img, carl, y, CARL_WIDTH, CARL_HEIGHT);
		xVel = 0;
		yVel = 0;
	}
			// METHODS
		public void walk(int dir) {
			
		}

		public void jump() {
			
		}

		public void act(List<Sprite> obstacles) {
			yVel += 0.2;
			
			x += xVel;
			y += yVel;
			
			for(Sprite s : obstacles) {
				if (s.intersects(this)) {
					yVel = 0;
					super.y = s.y - super.height;
				}
			}
			
		}
		public void moveX(int moveBy)
		{
			carlX += moveBy;
		}
		
		public void moveY(int moveBy)
		{
			carlY +=moveBy;
		}

}