package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class RingInheritence extends Circle{
	private Circle outCircle;

	public RingInheritence(Point center, int inRadius, int outRadius) {
		super(center, inRadius);
		if((inRadius<=0||outRadius<=0)||
				inRadius>=outRadius) {
			throw new IllegalArgumentException("RingInheritence() : inRadius = "+inRadius + " outRadius="+outRadius);
		}
		this.outCircle= new Circle(center, outRadius);
	}
	
	public boolean contains(Point p) {
		if(Circle.contains(p, this.outCircle)&&
				!super.contains(p)) {
			return true;
		}
		return false;
	}
	
	public static boolean contains(Point p, RingInheritence...rings) {
		Objects.requireNonNull(p);
		Objects.requireNonNull(rings);
		for(RingInheritence r : rings) {
			if(r.contains(p)) {
				return true;
			}
		}
		return false;
	}
	
	public double area() {
		return this.outCircle.getradius()*2*Math.PI - super.area();
	}

	@Override
	public String toString() {
		return "RingInheritence [inRadius=" + super.getradius() + ", outRadius=" + this.outCircle.getradius() + ", area="+this.area() +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((outCircle == null) ? 0 : outCircle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RingInheritence other = (RingInheritence) obj;
		if (outCircle == null) {
			if (other.outCircle != null)
				return false;
		} else if (!outCircle.equals(other.outCircle))
			return false;
		return true;
	}
	
	

}
