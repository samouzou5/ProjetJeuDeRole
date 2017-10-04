package com.polytech;

public class ArmeMagique extends Arme {
	
	private int nbMana;
	
	public int getNbMana() {
		return nbMana;
	}

	public void setNbMana(int nbMana) {
		this.nbMana = nbMana;
	}

	public ArmeMagique(String nom, String type, int degat, int nbMana) {
		super(nom, type, degat);
		this.nbMana = nbMana;
	}
	
	public void attaquer() {
		
	}
}
