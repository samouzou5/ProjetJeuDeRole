package com.polytech;

public class Partie {
	
	private Joueur joueurG;
	private Joueur joueurP;
	private int nbTours = 0;
	
	public Joueur getJoueurG() {
		return joueurG;
	}
	
	public void setJoueurG(Joueur joueurG) {
		this.joueurG = joueurG;
	}
	
	public Joueur getJoueurP() {
		return joueurP;
	}
	
	public void setJoueurP(Joueur joueurP) {
		this.joueurP = joueurP;
	}
	
	public int getNbTours() {
		return nbTours;
	}
	
	public Partie() {
		
	}
	
	public void incrementerTour() {
		this.nbTours++;
	}
}
