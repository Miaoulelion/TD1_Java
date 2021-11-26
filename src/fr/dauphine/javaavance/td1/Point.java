package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	private static int cpt=0;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		++cpt;
	}
	
	public Point (Point p2) {
		Objects.requireNonNull(p2);
		this.x=p2.getX();
		this.y=p2.getY();
		++cpt;
	}
	
	public void method() {
		Point p = new Point(1,2);
		System.out.println(p.x + " " + p.y);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isSameAs(Point p) {
		Objects.requireNonNull(p);
		if(p.getX()==this.x && p.getY()==this.y) {
			return true;
		}
		return false;
	}
	
	public void translate(int dx, int dy) {
		this.x+=dx;
		this.y+=dy;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}

	public static int getcpt() {
		return cpt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	

}
