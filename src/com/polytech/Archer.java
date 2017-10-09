package com.polytech;

public class Archer extends Personnage {

	public Archer(String nom, int pointsVie, int vitesse, int niveau) {
		super(nom, pointsVie, vitesse, niveau);
	}
	
	public void lancerAttaque(Personnage p, Arme a) {
		System.out.println("L'archer " + this.getNom() + " attaque " + p.getNom());
		
		int degatsPointsVie = super.attaquerPerso(p, a);
		p.setPointsVie(p.getPointsVie() - degatsPointsVie);
		
		System.out.println("L'attaque a fait " + degatsPointsVie + " points de d�gats � " + p.getNom() + ". Il lui reste "
				+ p.getPointsVie() + " points de vie");
	}
}