package com.polytech.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.polytech.Guerrier;
import com.polytech.Personnage;

public class TestPersonnage {
	
	private Personnage perso;

	@Before
	public void setUp() throws Exception {
		this.perso = new Guerrier("Gandalf", 100, 2, 1);
	}

	@Test
	public void assertEqualsTestNom() {
		String nom = this.perso.getNom();
		
		assertEquals("Gandalf", nom);
	}
	
	@Test
	public void assertNotEqualsTestNom() {
		String nom = this.perso.getNom();
		
		assertNotEquals("Sarouman", nom);
	}
	
	@Test
	public void assertEqualsTestVie() {
		int vie = this.perso.getPointsVie();
		
		assertEquals(100, vie);
	}

	@Test
	public void assertNotEqualsTestVie() {
		int vie = this.perso.getPointsVie();
		
		assertNotEquals(10, vie);
	}
	
	@Test
	public void assertEqualsVitesse() {
		int vitesse = this.perso.getVitesse();
		
		assertEquals(2, vitesse);
	}
	
	@Test
	public void assertNotEqualsVitesse() {
		int vitesse = this.perso.getVitesse();
		
		assertNotEquals(0, vitesse);
	}
	
	@Test
	public void assertEqualsNiveau() {
		int niveau = this.perso.getNiveau();
		
		assertEquals(1, niveau);
	}
	
	@Test
	public void assertNotEqualsNiveau() {
		int niveau = this.perso.getNiveau();
		
		assertNotEquals(10, niveau);
	}
}