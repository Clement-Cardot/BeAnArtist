package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class TestForme {

	@Test
	public void testGetCadreMinX() {
		Ligne ligne = new Ligne();
		assertEquals(0,ligne.getCadreMinX());
		
		ligne = new Ligne(-5,-5);
		assertEquals(-5,ligne.getCadreMinX());
	}
	
	@Test
	public void testGetCadreMinY() {
		Ligne ligne = new Ligne();
		assertEquals(0,ligne.getCadreMinY());
		
		ligne = new Ligne(-5,-5);
		assertEquals(-5,ligne.getCadreMinY());
	}
	
	@Test
	public void testGetCadreMaxX() {
		Ligne ligne = new Ligne();
		assertEquals(10,ligne.getCadreMaxX());

		ligne = new Ligne(-5,-5);
		assertEquals(0,ligne.getCadreMaxX());
	}
	
	@Test
	public void testGetCadreMaxY() {
		Ligne ligne = new Ligne();
		assertEquals(10,ligne.getCadreMaxY());
		
		ligne = new Ligne(-5,-5);
		assertEquals(0,ligne.getCadreMaxY());
	}
	
	@Test
	public void testSetPosition() {
		Ligne ligne = new Ligne();
		
		ligne.setPosition(new Coordonnees(5,5));
		assertEquals(new Coordonnees(5,5).toString(), ligne.getPosition().toString());
	
		ligne.setX(3);
		assertEquals(new Coordonnees(3,5).toString(), ligne.getPosition().toString());

		ligne.setY(7);
		assertEquals(new Coordonnees(3,7).toString(), ligne.getPosition().toString());

	}
	
	@Test
	public void testDeplacerDe() {
		Ligne ligne = new Ligne();
		
		ligne.deplacerDe(2, 2);
		assertEquals(new Coordonnees(2,2).toString(), ligne.getPosition().toString());
	
		ligne.deplacerDe(-2, -1);
		assertEquals(new Coordonnees(0,1).toString(), ligne.getPosition().toString());

	}
	
	@Test
	public void testSetCouleur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleur(Color.cyan);
		
		assertEquals(Color.cyan, ellipse.getCouleur());
	}
	
	
}
