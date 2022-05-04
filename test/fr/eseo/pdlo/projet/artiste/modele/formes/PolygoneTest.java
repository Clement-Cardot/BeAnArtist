package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Polygon;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygone;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PolygoneTest {
	@Test
	public void testConstructeur0() {
		Polygone testPolygone = new Polygone(5);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT ,testPolygone.getPosition().getAbscisse());
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT ,testPolygone.getPosition().getOrdonnee());
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, testPolygone.getHauteur());
	}
	
	@Test
	public void testConstructeur1() {
		Polygone testPolygone = new Polygone(new Coordonnees(9,9),5);
		assertEquals(9 ,testPolygone.getPosition().getAbscisse());
		assertEquals(9 ,testPolygone.getPosition().getOrdonnee());
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, testPolygone.getHauteur());
	}
	
	@Test
	public void testConstructeur2() {
		Polygone testPolygone = new Polygone(6,4);
		assertEquals(6, testPolygone.getHauteur());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Polygone(-4,5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable diametre", exception1.getMessage());

	}
	
	@Test
	public void testConstructeur3() {
		Polygone testPolygone = new Polygone(new Coordonnees(9,9), 6, 4);
		assertEquals(9 ,testPolygone.getPosition().getAbscisse());
		assertEquals(9 ,testPolygone.getPosition().getOrdonnee());
		assertEquals(6, testPolygone.getHauteur());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Polygone(new Coordonnees(9,9), -4,5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable diametre", exception1.getMessage());

	}
	
	@Test
	public void testSetLargeur() {
		Polygone testPolygone = new Polygone(5);
		testPolygone.setLargeur(10);
		assertEquals(10, testPolygone.getHauteur());
		assertEquals(10, testPolygone.getLargeur());
		
		testPolygone.setHauteur(20);
		assertEquals(20, testPolygone.getHauteur());
		assertEquals(20, testPolygone.getLargeur());
	}
	
	@Test
	public void testNumCote() {
		Polygone testPolygone = new Polygone(5);
		assertEquals(5, testPolygone.getNumCote());
		testPolygone.setNumCote(9);
		assertEquals(9, testPolygone.getNumCote());
		
	}
	
	@Test
	public void testPolygon() {
		Polygone testPolygone = new Polygone(5);
		Polygon shape = new Polygon();
		testPolygone.setPolygone(shape);
		assertTrue(shape.equals(testPolygone.getPolygone()));
	}
	
	@Test
	public void testRemplissage() {
		Polygone testPolygone = new Polygone(5);
		assertEquals(Remplissage.AUCUNE, testPolygone.getRemplissage());
		testPolygone.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, testPolygone.getRemplissage());
	}
	
	@Test
	public void testAire() {
		Polygone testPolygone = new Polygone(5);
		assertEquals(0, testPolygone.aire());
	}
	
	@Test
	public void testPerimetre() {
		Polygone testPolygone = new Polygone(5);
		assertEquals(0, testPolygone.perimetre());
	}
	
	@Test
	public void testContient() {
		Polygone testPolygone = new Polygone(5);
		Polygon shape = OutilPolygone.createPolygone(0, 0, 5, 5, 0);
		testPolygone.setPolygone(shape);
		assertTrue(testPolygone.contient(new Coordonnees()));
		assertFalse(testPolygone.contient(new Coordonnees(5,5)));
	}
	
	@Test
	public void testDeplacerVers() {
		Polygone testPolygone = new Polygone(5);
		testPolygone.deplacerVers(9, 5);
		assertEquals(9 ,testPolygone.getPosition().getAbscisse());
		assertEquals(5 ,testPolygone.getPosition().getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		Polygone testPolygone = new Polygone(5);
		Polygon shape = OutilPolygone.createPolygone(0, 0, 5, 5, 0);
		testPolygone.setPolygone(shape);
		testPolygone.deplacerDe(9, 5);
		assertEquals(9 ,testPolygone.getPosition().getAbscisse());
		assertEquals(5 ,testPolygone.getPosition().getOrdonnee());
	}
}
