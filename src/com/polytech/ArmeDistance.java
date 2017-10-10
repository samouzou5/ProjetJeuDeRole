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
	 * On remet les flèches à zéro à la fin d'un combat
	 */
	public void remiseAZero() {
		this.nbFleches = NB_FLECHES_DEBUT;
	}
	
	/**
	 * Renvoie les dégats liés à une arme distance
	 * Le nombre de flèches est aléatoire
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
