package fr.dauphine.javaavance.td1;

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
	
	public boolean contains(Point p, RingInheritence...rings) {
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
	

}
