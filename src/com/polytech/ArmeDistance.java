package com.polytech;

public class ArmeDistance extends Arme {
	
	private int nbFleche;

	public int getNbFleche() {
		return nbFleche;
	}

	public void setNbFleche(int nbFleche) {
		this.nbFleche = nbFleche;
	}
	
	public ArmeDistance(String nom, String type, int degat, int nbFleches) {
		super(nom, type, degat);
		this.nbFleche = nbFleches;
	}
	
	public void attaquer() {
		
	}
}
