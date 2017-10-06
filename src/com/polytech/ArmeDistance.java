package com.polytech;

import java.util.Random;

public class ArmeDistance extends Arme {

	private int nbFleches;

	public int getNbFleches() {
		return nbFleches;
	}

	public void setNbFleches(int nbFleches) {
		this.nbFleches = nbFleches;
	}

	public ArmeDistance(String nom, int degat, int nbFleches) {
		super(nom, degat);
		this.nbFleches = nbFleches;
	}
	
	/**
	 * 
	 */
	public int attaquer() {
		int nbInfliges = 0;

		// Nombre de fleche(s) entre 1 et 3;
		Random randomFleches = new Random();
		int nbFlechesLancees = randomFleches.nextInt(1) + 1;

		// Si on a pas assez de flèches on envoie les flèches restantes
		if (this.nbFleches < nbFlechesLancees) {
			nbFlechesLancees = this.nbFleches;
		}

		// On inflige le nombre de dégats
		nbInfliges += nbFlechesLancees * super.getDegats();

		// On retire le nombre de fleches
		this.nbFleches -= nbFlechesLancees;

		// On renvoie le nombre de points de dégats
		return nbInfliges;
	}
}
