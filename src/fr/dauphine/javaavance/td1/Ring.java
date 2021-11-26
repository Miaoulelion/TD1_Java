package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Ring {
	private Circle inCircle;
	private Circle outCircle;
	
	public Ring(Point center, int inRadius, int outRadius) {
		if((inRadius<=0||outRadius<=0)||
				inRadius<outRadius) {
			throw new IllegalArgumentException();
		}
		Objects.requireNonNull(center);
		this.inCircle=new Circle(center, inRadius);
		this.outCircle=new Circle(center, outRadius);
	}

	@Override
	public String toString() {
		return "inCircle :" + this.inCircle.toString() + "\n"
				+ "outCircle :"+ this.outCircle.toString();
	}

	public boolean contains(Point p) {
		if(Circle.contains(p, this.outCircle)&&
				!Circle.contains(p, this.inCircle)){
			return true;
		}
		return false;
	}
	
	public static boolean contains(Point p, Ring...rings) {
		for(Ring r : rings) {
			if(r.contains(p)) {
				return true;
			}
		}
		return false;
	}
	
	

}
