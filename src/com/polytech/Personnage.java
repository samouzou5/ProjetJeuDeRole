package com.polytech;

import java.util.List;
import java.util.ArrayList;

public abstract class Personnage {

	private String nom;
	private int pointsVie;
	private int vitesse;
	private int niveau;
	private List<Arme> armesPersonnages = new ArrayList<Arme>();
	
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

	public void setArmesPersonnages(List<Arme> armesPersonnages) {		
		this.armesPersonnages = armesPersonnages;
	}

	public Personnage() {
		
	}
	
	public Personnage(String nom, int pointsVie, int vitesse, int niveau) {
		this.nom = nom;
		this.pointsVie = pointsVie;
		this.vitesse = vitesse;
		this.niveau = niveau;
	}
	
	public void ajouterArme(Arme arme) {
		this.armesPersonnages.add(arme);
	}
	
	public abstract void attaquer(Personnage p);
}