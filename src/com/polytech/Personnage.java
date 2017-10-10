package com.polytech;

import java.util.List;
import java.util.ArrayList;

public abstract class Personnage {

	private String nom;
	private int pointsVie;
	private int vitesse;
	private int niveau;
	private List<Arme> armesPersonnages = new ArrayList<Arme>();
	private Equipement equipement;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public void setPointsVie(int pointsVie) {
		this.pointsVie = pointsVie;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public List<Arme> getArmesPersonnages() {
		return armesPersonnages;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Personnage() {

	}

	public Personnage(String nom, int pointsVie, int vitesse, int niveau) {
		this.nom = nom;
		this.pointsVie = pointsVie;
		this.vitesse = vitesse;
		this.niveau = niveau;
	}

	/**
	 * Méthode d'ajout d'une arme utilisée lors de la création des personnages
	 * @param arme
	 */
	public void ajouterArme(Arme arme) {
		this.armesPersonnages.add(arme);
	}

	public void setArmesPersonnages(List<Arme> armesPersonnages) {
		this.armesPersonnages = armesPersonnages;
	}

	/**
	 * Calcul des points de dégats d'une attaque sur un personnage
	 * Va chercher les points générés pour l'arme dans la classe arme
	 * @param p
	 * @param a
	 * @return
	 */
	public int attaquerPerso(Personnage p, Arme a) {
		int nbDegats = 0;

		// On va chercher le nombre de points pour les armes
		nbDegats += a.attaquer();

		// On va chercher les points attaque de l'équipement
		int pointsEquipementAttaque = getEquipement().getPointsAttaque();
		// On va chercher les points de défense de l'équipement de l'adversaire
		int pointsDefenseAdversaire = p.getEquipement().getPointsDefense();

		nbDegats += pointsEquipementAttaque;
		nbDegats -= pointsDefenseAdversaire;
		
		// On prend en compte le niveau et la vitesse du personnage
		nbDegats += this.vitesse * 2;
		nbDegats += this.niveau * 2;
		
		// Arrondi à l'entier inférieur

		if (nbDegats < 0) {
			nbDegats = 0;
		}

		return nbDegats;
	}
	
	/**
	 * Permet de savoir si un personnage est mort ou en vie
	 * @return
	 */
	public boolean getMort() {
		if(this.pointsVie <= 0) {
			return true;
		}
		
		return false;
	}

	abstract void lancerAttaque(Personnage p, Arme a);
}