package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class PolylineArray {
	private final int pointCapacity;
	private Point array[];
	private int newIndex;
	
	public PolylineArray(int capacity) {
		if(capacity<=0) {
			throw new IllegalArgumentException();
		}
		this.array=new Point[capacity];
		this.pointCapacity=capacity;
		this.newIndex=0;
	}
	
	public boolean contains(Point p1) {
		Objects.requireNonNull(p1);
		for (Point p : this.array) {
			if(p.equals(p1)) {
				return true;
			}
		}
		return false;
	}
	
	public void add(Point p) {
		Objects.requireNonNull(p);
		if(this.pointCapacity<=this.newIndex) {
			throw new IllegalStateException();
		}
		this.array[this.newIndex]=p;
		++this.newIndex;
	}
	
	public int pointCapacity() {
		return this.pointCapacity;
	}
	
	public int nbPoints() {
		return this.array.length;
	}
	

}
