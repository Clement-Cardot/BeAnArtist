package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CarreTest {
	@Test
	public void testConstructeur0() {
		Carre testedCarre = new Carre();
		String expectedString = "[Carre aucune] : pos (0,0 , 0,0) cote 5,0 périmètre : 40,0 aire : 100,0 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCarre.toString());
	}
	
	@Test
	public void testConstructeur1() {
		Carre testedCarre = new Carre(20);
		String expectedString = "[Carre aucune] : pos (0,0 , 0,0) cote 10,0 périmètre : 80,0 aire : 400,0 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCarre.toString());
	}
	
	@Test
	public void testConstructeur2() {
		Carre testedCarre = new Carre(new Coordonnees(1,1));
		String expectedString = "[Carre aucune] : pos (1,0 , 1,0) cote 5,0 périmètre : 40,0 aire : 100,0 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCarre.toString());
	}
	
	@Test
	public void testConstructeur3() {
		Carre testedCarre = new Carre(new Coordonnees(1,1), 20);
		String expectedString = "[Carre aucune] : pos (1,0 , 1,0) cote 10,0 périmètre : 80,0 aire : 400,0 couleur = R51,V51,B51";
		assertEquals(expectedString, testedCarre.toString());
	}
	
	@Test
	public void testSetLargeur() {
		Carre testedCarre = new Carre();
		testedCarre.setLargeur(6);
		assertEquals(6, testedCarre.getLargeur());
	}
	
	@Test
	public void testSetHauteur() {
		Carre testedCarre = new Carre();
		testedCarre.setHauteur(6);
		assertEquals(6, testedCarre.getHauteur());
	}
	
	@Test
	public void testToString() {
		Carre testedCarre = new Carre(new Coordonnees(5,5), 5);
		assertEquals("[Carre aucune] : pos (5,0 , 5,0) cote 2,5 périmètre : 20,0 aire : 25,0 couleur = R51,V51,B51", 
					testedCarre.toString());
		
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Carre aucune] : pos (5.0 , 5.0) cote 2.5 périmètre : 20.0 aire : 25.0 couleur = R51,G51,B51", 
					testedCarre.toString());
		
		Locale.setDefault(Locale.GERMAN);
		assertEquals("[Carre aucune] : pos (5,0 , 5,0) cote 2,5 périmètre : 20,0 aire : 25,0", testedCarre.toString());
		
		Locale.setDefault(Locale.FRENCH);
	}
}
