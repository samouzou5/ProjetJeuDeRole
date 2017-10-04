package com.polytech;

public class Joueur {
	
	private String nom;
	private int nbVictoires;
	private int nbDefaites;
	private int nbParties;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbVictoires() {
		return nbVictoires;
	}
	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}
	public int getNbDefaites() {
		return nbDefaites;
	}
	public void setNbDefaites(int nbDefaites) {
		this.nbDefaites = nbDefaites;
	}
	public int getNbParties() {
		return nbParties;
	}
	public void setNbParties(int nbParties) {
		this.nbParties = nbParties;
	}
	
	public Joueur(String nom, int nbVictoires, int nbDefaites, int nbParties) {
		this.nom = nom;
		this.nbVictoires = nbVictoires;
		this.nbDefaites = nbDefaites;
		this.nbParties = nbParties;
	}
}
