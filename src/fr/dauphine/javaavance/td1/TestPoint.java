package fr.dauphine.javaavance.td1;

public class TestPoint {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(1,2);
		p.method();
		
		//Does not function because x & y are private
		//System.out.println(p.x + " "+ p.y);
		
		System.out.println(p.getX() + " " + p.getY());

	}
}
