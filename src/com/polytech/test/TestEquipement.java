package com.polytech.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.polytech.Equipement;

public class TestEquipement {

	private Equipement equipement;
	
	@Before
	public void setUp() throws Exception {
		this.equipement = new Equipement("Bouclier", 0, 5);
	}
	
	@Test
	public void assertEqualsNom() {
		String nom = this.equipement.getNom();
		
		assertEquals("Bouclier", nom);
	}
	
	@Test
	public void assertNotEqualsNom() {
		String nom = this.equipement.getNom();
		
		assertNotEquals("Potion", nom);
	}
	
	@Test
	public void assertEqualsPointsAttaque() {
		int pointsAttaque = this.equipement.getPointsAttaque();
		
		assertEquals(0, pointsAttaque);
	}
	
	@Test
	public void assertNotEqualsPointsAttaque() {
		int pointsAttaque = this.equipement.getPointsAttaque();
		
		assertNotEquals(1, pointsAttaque);
	}
	
	@Test
	public void assertEqualsPointsDefense() {
		int pointsDefense = this.equipement.getPointsDefense();
		
		assertEquals(5, pointsDefense);
	}
	
	@Test
	public void assertNotEqualsPointsDefense() {
		int pointsDefense = this.equipement.getPointsDefense();
		
		assertNotEquals(10, pointsDefense);
	}

}
