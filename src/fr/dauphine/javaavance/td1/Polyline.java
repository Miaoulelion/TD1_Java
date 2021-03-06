package fr.dauphine.javaavance.td1;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Polyline {
	private LinkedList<Point> listPoints;


	public Polyline(List<Point> listPoint) {
		Objects.requireNonNull(listPoint);
		this.listPoints =new LinkedList<Point>();
		this.add(listPoint);
	}
	
	public Polyline(Point p) {
		Objects.requireNonNull(p);
		this.listPoints =new LinkedList<Point>();
		this.add(p);
	}
	
	public Polyline() {
		this.listPoints =new LinkedList<Point>();
	}
	
	public void add(Point p) {
		Objects.requireNonNull(p);
		this.listPoints.add(p);
	}
	
	public void add(List<Point> listPoint) {
		Objects.requireNonNull(listPoint);
		this.listPoints.addAll(listPoint);
	}
	
	
	public int nbPoints() {
		return this.listPoints.size();
	}
	
	public boolean contains(Point p1) {
		Objects.requireNonNull(p1);
		return this.listPoints.contains(p1);
	}

}
