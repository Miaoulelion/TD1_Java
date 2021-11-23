package fr.dauphine.javaavance.td1;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point (Point p2) {
		this.x=p2.getX();
		this.y=p2.getY();
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
	
	
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}


}
