package com.polytech;

import java.util.Random;

public class ArmeDistance extends Arme {

	private int nbFleches;
	private final static int NB_FLECHES_DEBUT = 10;

	public int getNbFleches() {
		return nbFleches;
	}

	public void setNbFleches(int nbFleches) {
		this.nbFleches = nbFleches;
	}

	public ArmeDistance(String nom, int degat) {
		super(nom, degat);
		this.nbFleches = NB_FLECHES_DEBUT;
	}
	
	/**
	 * On remet les fl�ches � z�ro � la fin d'un combat
	 */
	public void remiseAZero() {
		this.nbFleches = NB_FLECHES_DEBUT;
	}
	
	/**
	 * Renvoie les d�gats li�s � une arme distance
	 * Le nombre de fl�ches est al�atoire
	 */
	public int attaquer() {
		int nbInfliges = 0;

		// Nombre de fleche(s) entre 1 et 3;
		Random randomFleches = new Random();
		int nbFlechesLancees = randomFleches.nextInt(1) + 1;

		// Si on a pas assez de fl�ches on envoie les fl�ches restantes
		if (this.nbFleches < nbFlechesLancees) {
			nbFlechesLancees = this.nbFleches;
		}

		// On inflige le nombre de d�gats
		nbInfliges += nbFlechesLancees * super.getDegats();

		// On retire le nombre de fleches
		this.nbFleches -= nbFlechesLancees;

		// On renvoie le nombre de points de d�gats
		return nbInfliges;
	}
}
