package com.polytech;

import java.util.Random;

public class ArmeMagique extends Arme {
	
	private int nbMana;
	
	public int getNbMana() {
		return nbMana;
	}

	public void setNbMana(int nbMana) {
		this.nbMana = nbMana;
	}

	public ArmeMagique(String nom, int degat, int nbMana) {
		super(nom, degat);
		this.nbMana = nbMana;
	}
	
	public int attaquer() {
		
		int nbInfliges = 0;

		// Quantite de mana entre 1 et 10;
		Random randomMana = new Random();
		int quantiteManaLancee = randomMana.nextInt(2) + 1;

		// Si on a pas assez de flèches on envoie les flèches restantes
		if (this.nbMana < quantiteManaLancee) {
			quantiteManaLancee = this.nbMana;
		}

		// On inflige le nombre de dégats
		nbInfliges += quantiteManaLancee * super.getDegats();

		// On retire le nombre de fleches
		this.nbMana -= quantiteManaLancee;

		// On renvoie le nombre de points de dégats
		return nbInfliges;
	}
}
