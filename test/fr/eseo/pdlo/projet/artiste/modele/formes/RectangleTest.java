package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.dt.DTRectangleContient;

public class RectangleTest {

	@Test
	public void testConstructeur0() {
		Rectangle testRectangle = new Rectangle();
		String str = "[Rectangle aucune] : pos (0,0 , 0,0) petit cote 5,0 "
				+ "grand cote 5,0 périmètre : 40,0 aire : 100,0 couleur = R51,V51,B51";
		assertEquals(str, testRectangle.toString());
	}
	
	@Test
	public void testConstructeur1() {
		Rectangle testRectangle = new Rectangle(new Coordonnees(9,9));
		String str = "[Rectangle aucune] : pos (9,0 , 9,0) petit cote 5,0 "
				+ "grand cote 5,0 périmètre : 40,0 aire : 100,0 couleur = R51,V51,B51";
		assertEquals(str, testRectangle.toString());
	}
	
	@Test
	public void testConstructeur2() {
		Rectangle testRectangle = new Rectangle(6,4);
		String str = "[Rectangle aucune] : pos (0,0 , 0,0) petit cote 2,0 "
				+ "grand cote 3,0 périmètre : 20,0 aire : 24,0 couleur = R51,V51,B51";
		assertEquals(str, testRectangle.toString());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Rectangle(-4,0),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
		
		IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, 
				() -> new Rectangle(0,-5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception2.getMessage());

	}
	
	@Test
	public void testConstructeur3() {
		Rectangle testRectangle = new Rectangle(new Coordonnees(9,9), 6, 4);
		String str = "[Rectangle aucune] : pos (9,0 , 9,0) petit cote 2,0 "
				+ "grand cote 3,0 périmètre : 20,0 aire : 24,0 couleur = R51,V51,B51";
		assertEquals(str, testRectangle.toString());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Rectangle(new Coordonnees(9,9), -4,0),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
		
		IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, 
				() -> new Rectangle(new Coordonnees(9,9), 0,-5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception2.getMessage());
	}
	
	@ParameterizedTest
	@EnumSource()
	public void testContient(DTRectangleContient dt) {
		assertEquals(dt.expectedAnswer, dt.testedRectangle.contient( dt.testedCoordonnees));
	}
	
	@Test
	public void testSetLargeur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setLargeur(6);
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> rectangle.setLargeur(-6),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
	}
	
	@Test
	public void testSetHauteur() {
		Rectangle rectangle = new Rectangle();
		rectangle.setHauteur(6);
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> rectangle.setHauteur(-6),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception1.getMessage());
	}
	
	@Test
	public void testGetGrandRayon() {
		Rectangle rectangle = new Rectangle(8,4);
		assertEquals(4, rectangle.getGrandCote());
		rectangle = new Rectangle(4,8);
		assertEquals(4, rectangle.getGrandCote());
	}
	
	@Test
	public void testToString() {
		Rectangle testedRectangle = new Rectangle(new Coordonnees(5,5), 5, 5);
	assertEquals("[Rectangle aucune] : pos (5,0 , 5,0) petit cote 2,5 grand cote 2,5 périmètre : 20,0 aire : 25,0 couleur = R51,V51,B51",
					testedRectangle.toString());
		
		Locale.setDefault(Locale.ENGLISH);
	assertEquals("[Rectangle aucune] : pos (5.0 , 5.0) petit cote 2.5 grand cote 2.5 périmètre : 20.0 aire : 25.0 couleur = R51,G51,B51",
					testedRectangle.toString());
		
		Locale.setDefault(Locale.GERMAN);
	assertEquals("[Rectangle aucune] : pos (5,0 , 5,0) petit cote 2,5 grand cote 2,5 périmètre : 20,0 aire : 25,0", testedRectangle.toString());
		
		Locale.setDefault(Locale.FRENCH);
	}
	
	@Test
	public void testSetRemplissage() {
		Rectangle testedRectangle = new Rectangle();
		testedRectangle.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, testedRectangle.getRemplissage());
	}
}
