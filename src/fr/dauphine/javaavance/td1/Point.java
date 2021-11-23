package fr.dauphine.javaavance.td1;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this.x=3;
		this.y=4;
	}
	
	public void method() {
		Point p = new Point();
		System.out.println(p.x + " " + p.y);
	}

}
