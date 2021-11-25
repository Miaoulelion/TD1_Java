package fr.dauphine.javaavance.td1;

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

}
