package characters;

import java.awt.Color;

import processing.core.PApplet;

/**
 * The Shape class represents a double-precision Shape that can be drawn using the Processing library.The Shape class is a superclass for the other 3 classes.
 * 
 * This Version doesn't solve for vertical, horizontal, collinear, or parallel lines.
 * 
 * @author frank_an
 * @version 10/5/21
 *  */
public abstract class Shape {
	
	//FIELDS
	
	private double x1, y1;
	private Color fillColor, strokeColor;
	
	//CONSTRUCTORS
	
	/**
	 * Initializes a Shape with a given start point (x,y).
	 * 
	 * @param x X-coordinate of start point.
	 * @param y Y-coordinate of start point.
	 */
	public Shape(double x, double y) {
		x1 = x;
		y1 = y;
		
		this.fillColor = Color.WHITE;
		this.strokeColor = Color.BLACK;
	}
	
	
	
	//METHODS
	
	/**
	 * Draws a new instance of a Shape object with the x and y coordinate as its starting point.
	 *
	 * @param drawer The Processing PApplet on which to draw the Shape.
	 * @pre drawer must be null, and appropriate settings should have been selected (color, fill, etc.)
	 */
	public abstract void draw(PApplet drawer);
	
	/**
	 * Finds the area of the Shape.
	 * 
	 * @return A double that is the area of the Shape.
	 */
	public abstract double getArea();
	
	/**
	 * Finds the perimeter of the Shape.
	 * 
	 * @return A double that is the perimeter of the Shape.
	 */
	public abstract double getPerimeter();
	
	/**
	 * Tests whether this Shape intersects with the other Shape object.
	 * 
	 * @param other The other Rectangle to test intersection.
	 * @return True if the shape intersects with another Shape, false if it doesn't.
	 */
	public abstract boolean intersect(Shape other);
	
	/**
	 * Tests whether a point(x,y) is inside the Shape object.
	 * 
	 * @param x The x coordinate of the testing point.
	 * @param y The y coordinate of the testing point.
	 * @return True if the point is inside the Shape, false if it isn't inside the Shape.
	 */
	public abstract boolean isPointInside(double x, double y);
	
	/**
	 * Returns the x coordinate of the center of the Shape.
	 * 
	 * @return A double that is the X-coordinate of the Shape's center.
	 */
	public abstract double getCenterX();
	
	/**
	 * Returns the y coordinate of the center of the Shape.
	 * 
	 * @return A double that is the Y-coordinate of the Shape's center.
	 */
	public abstract double getCenterY();
	
	/**
	 * Returns a String containing debugging info for the Shape (the values of fields)
	 * 
	 * @return A String that prints out the fields, the x and y coordinate of the starting point and the Shape Fill and Stroke Color, to make debugging Shape easier.
	 */
	public String toString() {
		return "X: " + x1 + "\nY: " + y1 + "\nFill Color: " + this.fillColor + "\nStroke Color: " + this.strokeColor;
	}
	
	/**
	 * Changes both the fields of the Shape.
	 * 
	 * @param x The new X-coordinate of the starting point.
	 * @param y The new Y-coodinate of the starting point.
	 */
	public void setPoint(double x, double y) {
		x1 = x;
		y1 = y;
	}
	
	/**
	 * Returns the X-coordinate.
	 * 
	 * @return Double representing the starting x value.
	 */
	public double getX() {
		return x1;
	}
	
	/**
	 * Returns the Y-coordinate.
	 * 
	 * @return Double representing the starting y value.
	 */
	public double getY() {
		return y1;
	}
	
	/**
	 * Changes the Fill Color of the Shape.
	 * 
	 * @param c The color the new fill color is.
	 */
	public void setFillColor(Color c) {
		this.fillColor = c;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	/**
	 * Changes the Stroke Color of the Shape.
	 * 
	 * @param c The color the new stroke color is.
	 */
	public void setStrokeColor(Color c) {
		this.strokeColor = c;
	}
	
	public Color getStrokeColor() {
		return strokeColor;
	}
	
	public void moveBy(double x, double y)
	{
		x1 += x;
		y1 += y;
	}
}
