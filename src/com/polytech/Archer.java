package com.polytech;

public class Archer extends Personnage {

	public Archer(String nom, int pointsVie, int vitesse, int niveau) {
		super(nom, pointsVie, vitesse, niveau);
	}
	
	public void lancerAttaque(Personnage p) {
		System.out.println("L'archer " + this.getNom() + " attaque " + p.getNom());
		
		int degatsPointsVie = super.attaquerPerso(p);
		p.setPointsVie(p.getPointsVie() - degatsPointsVie);
		
		System.out.println("L'attaque a fait " + degatsPointsVie + " a " + p.getNom() + ". Il lui reste "
				+ p.getPointsVie() + " points de vie");
	}
}