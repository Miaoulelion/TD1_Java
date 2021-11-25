package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Ring {
	private Point center;
	private int inRadius;
	private int outRadius;
	
	
	public Ring(Point center, int inRadius, int outRadius) {
		if((inRadius<=0||outRadius<=0)&&
				inRadius<outRadius) {
			throw new IllegalArgumentException();
		}
		Objects.requireNonNull(center);
		this.center=center;
		this.inRadius=inRadius;
		this.outRadius=outRadius;
	}


	@Override
	public String toString() {
		return "Ring [center=" + center + ", inRadius=" + inRadius + ", outRadius=" + outRadius + "]";
	}
	
	
	//vu la consigne, je suis sûr que ce n'est pas comme ça qu'il faut faire
	//j'utilise des objets, mais moi j'aurais créé dès le début des Circles au lieu
	//de mettre des inRadius et tout comme demandé... Je suppose qu'il faut faire
	//un truc avec l'héritage mais je ne vois pas quoi là, surtout qu'il faudrait ensuite
	//se retaper toutes les implémentations... 
	//Je mets quand même la méthode parce que la logique est la bonne :
	//"Pour être sur un anneau, faut être entre les deux cercles qui forment l'anneau".
	public boolean contains(Point p) {
		if((Circle.contains(p,new Circle(p, outRadius)))
				&&!(Circle.contains(p, new Circle(p, inRadius)))){
			return true;
		}
		return false;
	}
	
	

}
