package characters;

import processing.core.PApplet;

/**
 * The Line class represents a double-precision Line that can be drawn using the Processing library. It also focused on the ability to detect
 * intersections with other Lines.
 * 
 * This Version doesn't solve for vertical, horizontal, collinear, or parallel lines.
 * 
 * @author frank_an
 * @version 9/20/21
 *  */
public class Line extends Shape{
	// Constructs a line from (x1, y1) to (x2, y2)
	private double x2, y2;
	
	/**
	 * Initializes a line by using two points the start and end points
	 * 
	 * @param xOne X-coordinate of first point.
	 * @param yOne Y-coordinate of first point.
	 * @param xTwo X-coordinate of second point.
	 * @param yTwo Y-coordinate of second point.
	 */
	public Line(double xOne, double yOne, double xTwo, double yTwo) {
		super(xOne, yOne);
		x2 = xTwo;
		y2 = yTwo;
	}
	
	/**
	 * Creates a Line object that from a starting point and a angle and the length of the Line.
	 * 
	 * @param x1 The x value of the starting point of the Line.
	 * @param y1 The y value of the starting point of the Line.
	 * @param angle The angle of the Line and where it starts drawing.
	 * @param length How long the lines runs at a certain angle.
	 * @return A Line object created without a second point.
	 * 
	 * @pre The 3rd parameter has to be an angle length and the length has to be a positive length.
	 * @post A new line object will be created.
	 */
	public static Line constructLineFromAngle(double x1,double y1, double angle, double length) {
		Line l = new Line(x1, y1, x1 + Math.cos(angle)*length, y1 + Math.sin(angle)*length);
		return l;
	}
	
	
	// Sets this lines second point (x2, y2) to a new coordinate
	/**
	 * Sets this lines second point (x2, y2) to a new coordinate
	 * 
	 * @param x2 The new X-coordinate for the second point.
	 * @param y2 The new Y-coordinate for the second point.
	 * @post The Line object has a new second point.
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	/**
	 * Draws a new instance of a Line object with the PApplet and uses the two points of the Line object, with a stroke color based on the strokeColor of Shape.
	 *
	 * @param drawer The Processing PApplet on which to draw the Rectangle.
	 * @pre drawer must be null, and appropriate settings should have been selected (color, fill, etc.)
	 * 
	 */
	// Draws this line using the PApplet passed as an argument
	public void draw(PApplet drawer) {
		drawer.stroke(getStrokeColor().getRed(), getStrokeColor().getGreen(), getStrokeColor().getBlue());
		drawer.line((float)getX(), (float)getY(), (float)x2, (float)y2);
	}
	/**
	 * Returns the x coordinate of the intersection point of this line and the other line (assuming they continue forever)
	 * 
	 * @param other A Line object that the method finds the x-value of the point of Intersection between other Line and this Line.
	 * @return The x-value of the intersection point of the two Lines.
	 */
	// Returns the x coordinate of the intersection point of this line and the other line (assuming they continue forever)
	public double getIntersectionX(Line other) {
		double px = ((getX() * y2-getY()*x2)*(other.getX()-other.x2)-(getX()-x2)*(other.getX()*other.y2-other.getY()*other.x2))/((getX()-x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()-other.x2));
		//System.out.println("x" +px);
		return px;
	}
	
	/**
	 * Returns the y coordinate of the intersection point of this line and the other line (assuming they continue forever)
	 * 
	 * @param other A Line object that the method finds the y-value of the point of Intersection between other Line and this Line.
	 * @return The y-value of the intersection point of the two Lines.
	 */
	// Returns the y coordinate of the intersection point of this line and the other line (assuming they continue forever)
	public double getIntersectionY(Line other) {
		double py = ((getX() * y2-getY()*x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()*other.y2-other.getY()*other.x2))/((getX()-x2)*(other.getY()-other.y2)-(getY()-y2)*(other.getX()-other.x2));
		//System.out.println("y" + py);
		return py;
	}
	/**
	 * Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
	 * 
	 * @param other A Line object that is set as an argument.
	 * @return True if the Line other and this Line intersect each other within their given domains, false if they don't.
	 */
	// Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
	public boolean intersects(Line other) {
		if ((y2-getY())/(x2-getX()) == (other.y2 - other.getY())/(other.x2-other.getX())) {
			if (getX() == other.getX() && x2 == other.x2 && getY() == other.getY() && y2 == other.y2) {
				return true;
			}
			return false;
		}
		if (getX() <= x2 && other.getX() <= other.x2) {
			if (this.getIntersectionX(other) >= getX() && this.getIntersectionX(other) <= x2 && this.getIntersectionX(other) >= other.getX() && this.getIntersectionX(other) <= other.x2) {
				if (y2 >= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 >= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
			}
		}
		if (getX() >= x2 && other.getX() >= other.x2) {
			if (this.getIntersectionX(other) <= getX() && this.getIntersectionX(other) >= x2 && this.getIntersectionX(other) <= other.getX() && this.getIntersectionX(other) >= other.x2) {
				if (y2 >= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 >= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
			}
		}
		if (getX() >= x2 && other.getX() <= other.x2) {
			if (this.getIntersectionX(other) <= getX() && this.getIntersectionX(other) >= x2 && this.getIntersectionX(other) >= other.getX() && this.getIntersectionX(other) <= other.x2) {
				if (y2 >= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 >= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
			}
		}
		if (getX() <= x2 && other.getX() >= other.x2) {
			if (this.getIntersectionX(other) >= getX() && this.getIntersectionX(other) <= x2 && this.getIntersectionX(other) <= other.getX() && this.getIntersectionX(other) >= other.x2) {
				if (y2 >= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 >= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) >= getY() && this.getIntersectionY(other) <= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() <= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) >= other.getY() && this.getIntersectionY(other) <= other.y2)
						return true;
				}
				if (y2 <= getY() && other.getY() >= other.y2) {	
					if(this.getIntersectionY(other) <= getY() && this.getIntersectionY(other) >= y2 && this.getIntersectionY(other) <= other.getY() && this.getIntersectionY(other) >= other.y2)
						return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return Math.sqrt((getX() - x2) * (getX() - x2) + (getY() - y2) * (getY() - y2));
	}

	@Override
	public boolean intersect(Shape other) {
		// TODO Auto-generated method stub
		Line other2 = (Line) other;
		return this.intersect(other2);
	}

	@Override
	public boolean isPointInside(double x, double y) {
		// TODO Auto-generated method stub
		if (getX() < x && x < x2) {
			if (getY() < y && y < y2) {
				return true;
			}
			if (getY() > y && y > y2) {
				return true;
			}
		}
		if (getX() > x && x > x2) {
			if (getY() < y && y < y2) {
				return true;
			}
			if (getY() > y && y > y2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double getCenterX() {
		// TODO Auto-generated method stub
		return (getX() + x2)/2;
	}

	@Override
	public double getCenterY() {
		// TODO Auto-generated method stub
		return (getY() + x2)/2;
	}

}
