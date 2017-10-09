package com.polytech;

public abstract class Arme {
	
	private String nomArme;
	private int degats;
	
	public String getNomArme() {
		return nomArme;
	}
	
	public void setNomArme(String nomArme) {
		this.nomArme = nomArme;
	}
	
	public int getDegats() {
		return degats;
	}
	
	public void setDegats(int degat) {
		this.degats = degat;
	}
	
	public Arme(String nom, int degats) {
		this.nomArme = nom;
		this.degats = degats;
	}
	
	public Arme() {
		
	}
	
	abstract int attaquer();
}