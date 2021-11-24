package fr.dauphine.javaavance.td1;


import java.util.LinkedList;
import java.util.List;

public class Polyline {
	private LinkedList<Point> listPoints;
	private final int pointCapacity;
	
	//int array[]= new int[nbr];
	public Polyline(int pointCapacity) {
		listPoints=new LinkedList<Point>();
		this.pointCapacity=pointCapacity;
	}
	
	public void add(Point p) {
		if(this.listPoints.size()>=this.pointCapacity) {
			throw new IllegalArgumentException();
		}
		this.listPoints.add(p);
	}
	
	public void add(List<Point> listPoint) {
		if(this.listPoints.size()>=this.pointCapacity-listPoint.size()) {
			throw new IllegalArgumentException();
		}
		this.listPoints.addAll(listPoint);
	}
	
	public int pointCapacity() {
		return this.pointCapacity;
	}
	
	public int nbPoints() {
		return this.listPoints.size();
	}

}
