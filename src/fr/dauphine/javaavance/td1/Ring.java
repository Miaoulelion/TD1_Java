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
	
	
	//vu la consigne, je suis s�r que ce n'est pas comme �a qu'il faut faire
	//j'utilise des objets, mais moi j'aurais cr�� d�s le d�but des Circles au lieu
	//de mettre des inRadius et tout comme demand�... Je suppose qu'il faut faire
	//un truc avec l'h�ritage mais je ne vois pas quoi l�, surtout qu'il faudrait ensuite
	//se retaper toutes les impl�mentations... 
	//Je mets quand m�me la m�thode parce que la logique est la bonne :
	//"Pour �tre sur un anneau, faut �tre entre les deux cercles qui forment l'anneau".
	public boolean contains(Point p) {
		if((Circle.contains(p,new Circle(p, outRadius)))
				&&!(Circle.contains(p, new Circle(p, inRadius)))){
			return true;
		}
		return false;
	}
	
	

}
