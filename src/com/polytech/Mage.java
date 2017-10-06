package com.polytech;

public class Mage extends Personnage {

	public Mage(String nom, int pointsVie, int vitesse, int niveau) {
		super(nom, pointsVie, vitesse, niveau);
	}
	
	public void lancerAttaque(Personnage p) {
		System.out.println("Le mage " + this.getNom() + " attaque " + p.getNom());
		
		int degatsPointsVie = super.attaquerPerso(p);
		p.setPointsVie(p.getPointsVie() - degatsPointsVie);
		
		System.out.println("L'attaque a fait " + degatsPointsVie + " a " + p.getNom() + ". Il lui reste "
				+ p.getPointsVie() + " points de vie");
	}
}
