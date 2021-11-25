package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Circle {
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius) {
		if(radius<=0) {
			throw new IllegalArgumentException("Circle() : radius can't be negative.");
		}
		Objects.requireNonNull(center);
		this.center=new Point(center.getX(), center.getY());
		this.radius=radius;
	}

	public void translate(int dx, int dy) {
		this.center.translate(dx, dy);
	}
	
	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + ", area =" + this.area() + " ]";
	}
	
	public Point getCenter() {
		return new Point(this.center.getX(), this.center.getY());
	}
	
	public boolean contains(Point p) {
		double distance = Math.sqrt((Math.pow(p.getX()-center.getX(), 2.0)+Math.pow(p.getY()-center.getY(), 2.0)));
		if(distance>this.radius) { //radius is automatically casted into double.
			return false;
		}
		return true;
	}
	
	public static boolean contains(Point p, Circle...circles) {
		for(Circle c : circles) {
			if(c.contains(p)){
				return true;
			}
		}
		return false;
	}
	
	public double area() {
		return 2*Math.PI*this.radius;
	}
	
	

}
