package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest {
	
	@Test
	public void testConstructeur0() {
		Cercle testedCercle = new Cercle();
		String expectedString = "[Cercle aucune] : pos (0,0 , 0,0) rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCercle.toString());
	}
	
	@Test
	public void testConstructeur1() {
		Cercle testedCercle = new Cercle(20);
		String expectedString = "[Cercle aucune] : pos (0,0 , 0,0) rayon 10,0 périmètre : 62,83 aire : 314,16 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCercle.toString());
	}
	
	@Test
	public void testConstructeur2() {
		Cercle testedCercle = new Cercle(new Coordonnees(1,1));
		String expectedString = "[Cercle aucune] : pos (1,0 , 1,0) rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCercle.toString());
	}
	
	@Test
	public void testConstructeur3() {
		Cercle testedCercle = new Cercle(new Coordonnees(1,1), 20);
		String expectedString = "[Cercle aucune] : pos (1,0 , 1,0) rayon 10,0 périmètre : 62,83 aire : 314,16 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCercle.toString());
	}
	
	@Test
	public void testSetLargeur() {
		Cercle testedCercle = new Cercle();
		testedCercle.setLargeur(6);
		assertEquals(6, testedCercle.getLargeur());
	}
	
	@Test
	public void testSetHauteur() {
		Cercle testedCercle = new Cercle();
		testedCercle.setHauteur(6);
		assertEquals(6, testedCercle.getHauteur());
	}
	
	@Test
	public void testToString() {
		Cercle testedCercle = new Cercle(new Coordonnees(5,5), 5);
		assertEquals("[Cercle aucune] : pos (5,0 , 5,0) rayon 2,5 périmètre : 15,71 aire : 19,63 couleur = R51,V51,B51", 
					testedCercle.toString());
		
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Cercle aucune] : pos (5.0 , 5.0) rayon 2.5 périmètre : 15.71 aire : 19.63 couleur = R51,G51,B51", 
					testedCercle.toString());
		
		Locale.setDefault(Locale.GERMAN);
		assertEquals("[Cercle aucune] : pos (5,0 , 5,0) rayon 2,5 périmètre : 15,71 aire : 19,63", testedCercle.toString());
		
		Locale.setDefault(Locale.FRENCH);
	}
}
