package fr.dauphine.javaavance.td1;

import java.util.ArrayList;

public class TestPoint {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(1,2);
		p1.method();
		Point p2=p1;
		
		//Does not function because x & y are private
		//System.out.println(p.x + " "+ p.y);
		
		System.out.println(p1.getX() + " " + p1.getY());
		Point p3 = new Point(new Point(1,2));
		
		System.out.println(Point.getcpt());
		
		System.out.println(p1==p2);
		System.out.println(p1==p3);
		
		
		ArrayList<Point> list = new ArrayList<>();
		list.add(p1);
		System.out.println(list.indexOf(p2));
		System.out.println(list.indexOf(p3));
		
		PolylineArray pLine = new PolylineArray(1);
		pLine.add(p1);
		//pLine.add(new Point(4,4));
		//pLine.add(null);
		
		Circle c=new Circle(new Point(1,2), 1);
		c.getCenter().translate(1,1); 
		System.out.println(c);

		RingInheritence r = new RingInheritence(p1, 2, 4);
		System.out.println(r);
		System.out.println(r.contains(new Point(1,5)));


	}
}
