package com.polytech;

public abstract class Arme {
	
	private String nomArme;
	private String typeArme;
	private int degat;
	
	public String getNomArme() {
		return nomArme;
	}
	
	public void setNomArme(String nomArme) {
		this.nomArme = nomArme;
	}
	
	public String getTypeArme() {
		return typeArme;
	}
	
	public void setTypeArme(String typeArme) {
		this.typeArme = typeArme;
	}
	
	public int getDegat() {
		return degat;
	}
	
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	public Arme(String nom, String type, int degat) {
		this.nomArme = nom;
		this.typeArme = type;
		this.degat = degat;
	}
	
	public abstract void attaquer();
}