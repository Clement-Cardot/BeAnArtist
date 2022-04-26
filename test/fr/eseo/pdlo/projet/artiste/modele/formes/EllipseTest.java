package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.dt.DTEllipseContient;

public class EllipseTest {
	@Test
	public void testConstructeur0() {
		Ellipse testEllipse = new Ellipse();
		String str = "[Ellipse aucune] : pos (0,0 , 0,0) petit rayon 5,0 "
				+ "grand rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51";
		assertEquals(str, testEllipse.toString());
	}
	
	@Test
	public void testConstructeur1() {
		Ellipse testEllipse = new Ellipse(new Coordonnees(9,9));
		String str = "[Ellipse aucune] : pos (9,0 , 9,0) petit rayon 5,0 "
				+ "grand rayon 5,0 périmètre : 31,42 aire : 78,54 couleur = R51,V51,B51";
		assertEquals(str, testEllipse.toString());
	}
	
	@Test
	public void testConstructeur2() {
		Ellipse testEllipse = new Ellipse(6,4);
		String str = "[Ellipse aucune] : pos (0,0 , 0,0) petit rayon 2,0 "
				+ "grand rayon 3,0 périmètre : 15,87 aire : 18,85 couleur = R51,V51,B51";
		assertEquals(str, testEllipse.toString());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Ellipse(-4,0),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
		
		IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, 
				() -> new Ellipse(0,-5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception2.getMessage());

	}
	
	@Test
	public void testConstructeur3() {
		Ellipse testEllipse = new Ellipse(new Coordonnees(9,9), 6, 4);
		String str = "[Ellipse aucune] : pos (9,0 , 9,0) petit rayon 2,0 "
				+ "grand rayon 3,0 périmètre : 15,87 aire : 18,85 couleur = R51,V51,B51";
		assertEquals(str, testEllipse.toString());
		
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> new Ellipse(new Coordonnees(9,9), -4,0),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
		
		IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, 
				() -> new Ellipse(new Coordonnees(9,9), 0,-5),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception2.getMessage());
	}
	
	@ParameterizedTest
	@EnumSource()
	public void testContient(DTEllipseContient dt) {
		assertEquals(dt.expectedAnswer, dt.testedEllipse.contient( dt.testedCoordonnees));
	}
	
	@Test
	public void testSetLargeur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setLargeur(6);
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> ellipse.setLargeur(-6),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable largeur", exception1.getMessage());
	}
	
	@Test
	public void testSetHauteur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setHauteur(6);
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, 
				() -> ellipse.setHauteur(-6),
				"IllegalArgumentException expected");
		assertEquals("Valeur négative dans la variable hauteur", exception1.getMessage());
	}
	
	@Test
	public void testGetGrandRayon() {
		Ellipse ellipse = new Ellipse(8,4);
		assertEquals(4, ellipse.getGrandRayon());
		ellipse = new Ellipse(4,8);
		assertEquals(4, ellipse.getGrandRayon());
	}
	
	@Test
	public void testToString() {
		Ellipse testedEllipse = new Ellipse(new Coordonnees(5,5), 5, 5);
	assertEquals("[Ellipse aucune] : pos (5,0 , 5,0) petit rayon 2,5 grand rayon 2,5 périmètre : 15,71 aire : 19,63 couleur = R51,V51,B51",
					testedEllipse.toString());
		
		Locale.setDefault(Locale.ENGLISH);
	assertEquals("[Ellipse aucune] : pos (5.0 , 5.0) petit rayon 2.5 grand rayon 2.5 périmètre : 15.71 aire : 19.63 couleur = R51,G51,B51",
					testedEllipse.toString());
		
		Locale.setDefault(Locale.GERMAN);
	assertEquals("[Ellipse aucune] : pos (5,0 , 5,0) petit rayon 2,5 grand rayon 2,5 périmètre : 15,71 aire : 19,63", testedEllipse.toString());
		
		Locale.setDefault(Locale.FRENCH);
	}
	
	@Test
	public void testSetRemplissage() {
		Ellipse testedEllipse = new Ellipse();
		testedEllipse.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, testedEllipse.getRemplissage());
	}
	
}
