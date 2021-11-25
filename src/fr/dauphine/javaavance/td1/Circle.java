package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Circle {
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius) {
		if(radius>=0) {
			throw new IllegalArgumentException();
		}
		Objects.requireNonNull(center);
		this.center=center;
		this.radius=radius;
	}

	public void translate(int dx, int dy) {
		this.center.translate(dx, dy);
	}
	
	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}
	
	

}
