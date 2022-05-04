package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Shape;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EtoileTest {
	@Test
	public void testConstructeur0() {
		Etoile testEtoile = new Etoile(5);
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT ,testEtoile.getPosition().getAbscisse());
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT ,testEtoile.getPosition().getOrdonnee());
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, testEtoile.getHauteur());
	}
	
	@Test
	public void testConstructeur1() {
		Etoile testEtoile = new Etoile(new Coordonnees(9,9),5);
		assertEquals(9 ,testEtoile.getPosition().getAbscisse());
		assertEquals(9 ,testEtoile.getPosition().getOrdonnee());
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, testEtoile.getHauteur());
	}
	
	@Test
	public void testConstructeur2() {
		Etoile testEtoile = new Etoile(6,4);
		assertEquals(6, testEtoile.getHauteur());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Etoile(-4,5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable diametre", exception1.getMessage());

	}
	
	@Test
	public void testConstructeur3() {
		Etoile testEtoile = new Etoile(new Coordonnees(9,9), 6, 4);
		assertEquals(9 ,testEtoile.getPosition().getAbscisse());
		assertEquals(9 ,testEtoile.getPosition().getOrdonnee());
		assertEquals(6, testEtoile.getHauteur());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Etoile(new Coordonnees(9,9), -4,5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable diametre", exception1.getMessage());

	}
	
	@Test
	public void testSetLargeur() {
		Etoile testEtoile = new Etoile(5);
		testEtoile.setLargeur(10);
		assertEquals(10, testEtoile.getHauteur());
		assertEquals(10, testEtoile.getLargeur());
		
		testEtoile.setHauteur(20);
		assertEquals(20, testEtoile.getHauteur());
		assertEquals(20, testEtoile.getLargeur());
	}
	
	@Test
	public void testNumCote() {
		Etoile testEtoile = new Etoile(5);
		assertEquals(5, testEtoile.getNumRays());
		testEtoile.setNumRays(9);
		assertEquals(9, testEtoile.getNumRays());
		
	}
	
	@Test
	public void testShape() {
		Etoile testEtoile = new Etoile(5);
		Shape shape = OutilEtoile.createStar(0, 0, 5, 10, 5, 0);
		testEtoile.setFormeEtoile(shape);
		assertTrue(shape.equals(testEtoile.getFormeEtoile()));
	}
	
	@Test
	public void testRemplissage() {
		Etoile testEtoile = new Etoile(5);
		assertEquals(Remplissage.AUCUNE, testEtoile.getRemplissage());
		testEtoile.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, testEtoile.getRemplissage());
	}
	
	@Test
	public void testAire() {
		Etoile testEtoile = new Etoile(5);
		assertEquals(0, testEtoile.aire());
	}
	
	@Test
	public void testPerimetre() {
		Etoile testEtoile = new Etoile(5);
		assertEquals(0, testEtoile.perimetre());
	}
	
	@Test
	public void testContient() {
		Etoile testEtoile = new Etoile(5);
		Shape shape = OutilEtoile.createStar(0, 0, 5, 10, 5, 0);
		testEtoile.setFormeEtoile(shape);
		assertTrue(testEtoile.contient(new Coordonnees()));
		assertFalse(testEtoile.contient(new Coordonnees(5,5)));
	}
	
	@Test
	public void testDeplacerVers() {
		Etoile testEtoile = new Etoile(5);
		testEtoile.deplacerVers(9, 5);
		assertEquals(9 ,testEtoile.getPosition().getAbscisse());
		assertEquals(5 ,testEtoile.getPosition().getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		Etoile testEtoile = new Etoile(5);
		Shape shape = OutilEtoile.createStar(0, 0, 5, 10, 5, 0);
		testEtoile.setFormeEtoile(shape);
		testEtoile.deplacerDe(9, 5);
		assertEquals(9 ,testEtoile.getPosition().getAbscisse());
		assertEquals(5 ,testEtoile.getPosition().getOrdonnee());
	}
	
	@Test
	public void testGetCadre() {
		Etoile testEtoile = new Etoile(5);
		Shape shape = OutilEtoile.createStar(0, 0, 5, 10, 5, 0);
		testEtoile.setFormeEtoile(shape);
		assertEquals(shape.getBounds().getMinX() ,testEtoile.getCadreMinX());
		assertEquals(shape.getBounds().getMinY() ,testEtoile.getCadreMinY());
		assertEquals(shape.getBounds().getMaxX() ,testEtoile.getCadreMaxX());
		assertEquals(shape.getBounds().getMaxY() ,testEtoile.getCadreMaxY());
	}
}
