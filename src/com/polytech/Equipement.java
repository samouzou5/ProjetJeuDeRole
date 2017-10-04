package com.polytech;

public class Equipement {
	
	private String nom;
	private int pointsAttaque;
	private int pointsDefense;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPointsAttaque() {
		return pointsAttaque;
	}
	public void setPointsAttaque(int pointsAttaque) {
		this.pointsAttaque = pointsAttaque;
	}
	public int getPointsDefense() {
		return pointsDefense;
	}
	public void setPointsDefense(int pointsDefense) {
		this.pointsDefense = pointsDefense;
	}
	
	public Equipement(String nom, int ptAttaque, int ptDefense) {
		this.nom = nom;
		this.pointsAttaque = ptAttaque;
		this.pointsDefense = ptDefense;
	}
}