package com.polytech;

import java.util.Random;

public class ArmeMagique extends Arme {
	
	private int nbMana;
	private final static int NB_MANA_DEBUT = 10;
	
	public int getNbMana() {
		return nbMana;
	}

	public void setNbMana(int nbMana) {
		this.nbMana = nbMana;
	}

	public ArmeMagique(String nom, int degat) {
		super(nom, degat);
		this.nbMana = NB_MANA_DEBUT;
	}
	
	public void remiseAZero() {
		this.nbMana = NB_MANA_DEBUT;
	}
	
	/**
	 * Renvoie les d�gats li�s � une arme magique
	 * Le nombre de points de mana utilis�s est al�atoire
	 */
	public int attaquer() {
		
		int nbInfliges = 0;

		// Quantite de mana entre 1 et 2;
		Random randomMana = new Random();
		int quantiteManaLancee = randomMana.nextInt(1) + 1;

		// Si on a pas assez de fl�ches on envoie les fl�ches restantes
		if (this.nbMana < quantiteManaLancee) {
			quantiteManaLancee = this.nbMana;
		}

		// On inflige le nombre de d�gats
		nbInfliges += quantiteManaLancee * super.getDegats();

		// On retire le nombre de fleches
		this.nbMana -= quantiteManaLancee;

		// On renvoie le nombre de points de d�gats
		return nbInfliges;
	}
}
