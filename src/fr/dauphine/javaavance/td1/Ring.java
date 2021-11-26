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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inCircle == null) ? 0 : inCircle.hashCode());
		result = prime * result + ((outCircle == null) ? 0 : outCircle.hashCode());
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
		Ring other = (Ring) obj;
		if (inCircle == null) {
			if (other.inCircle != null)
				return false;
		} else if (!inCircle.equals(other.inCircle))
			return false;
		if (outCircle == null) {
			if (other.outCircle != null)
				return false;
		} else if (!outCircle.equals(other.outCircle))
			return false;
		return true;
	}
	
	

}
