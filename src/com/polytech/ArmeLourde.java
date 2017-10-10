package com.polytech;

public class ArmeLourde extends Arme {
	
	private int vitesse;
	
	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public ArmeLourde(String nom, int degats, int vitesse) {
		super(nom, degats);
		this.vitesse = vitesse;
	}
	
	/**
	 * Renvoie les dégats liés à une arme lourde
	 */
	public int attaquer() {
		int nbInfliges = 0;
		
		// On renvoie le nombre de points de dégats
		nbInfliges += super.getDegats();
		
		return nbInfliges;
	}
	
	public void remiseAZero() {
		
	}
}
