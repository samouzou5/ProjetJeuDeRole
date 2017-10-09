package com.polytech;

public class Guerrier extends Personnage {

	public Guerrier(String nom, int pointsVie, int vitesse, int niveau) {
		super(nom, pointsVie, vitesse, niveau);
	}
	
	public void lancerAttaque(Personnage p, Arme a) {
		System.out.println("Le guerrier " + this.getNom() + " attaque " + p.getNom());
		
		int degatsPointsVie = super.attaquerPerso(p, a);
		p.setPointsVie(p.getPointsVie() - degatsPointsVie);
		
		System.out.println("L'attaque a fait " + degatsPointsVie + " a " + p.getNom() + ". Il lui reste "
				+ p.getPointsVie() + " points de vie");
	}
}