package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.dt.DTLigneAngle;
import fr.eseo.pdlo.projet.artiste.modele.formes.dt.DTLigneConstructeur;
import fr.eseo.pdlo.projet.artiste.modele.formes.dt.DTLigneContient;

public class LigneTest {
	@Test
	public void testConstructeur0() {
		Ligne testedLigne = new Ligne();
		String str = "[Ligne] c1 : (0,0 , 0,0) c2 : (10,0 , 10,0) longueur : 14,14 angle : 45,0° couleur = R51,V51,B51";
		assertEquals(str, testedLigne.toString());
		
	}
	
	@Test
	public void testConstructeur1() {
		Ligne testedLigne = new Ligne(new Coordonnees(4,-2));
		assertEquals(new Coordonnees(4,-2).toString(), testedLigne.getC1().toString());
		assertEquals(new Coordonnees(14, 8).toString(), testedLigne.getC2().toString());
		assertEquals(10, testedLigne.getLargeur());
		assertEquals(10, testedLigne.getHauteur());
	}
	
	@ParameterizedTest
	@EnumSource()
	public void testConstructeur(DTLigneConstructeur dt) {
		Ligne testedLigne = new Ligne(dt.c1Coord, dt.largeur, dt.hauteur);
		assertEquals(dt.c1Coord.toString(), testedLigne.getC1().toString());
		assertEquals(dt.c2Coord.toString(), testedLigne.getC2().toString());
		assertEquals(dt.largeur, testedLigne.getLargeur());
		assertEquals(dt.hauteur, testedLigne.getHauteur());
	}
	
	@Test
	public void testSetC1() {
		Ligne testedLigne = new Ligne();
		testedLigne.setC1(new Coordonnees(4,6));
		assertEquals(new Coordonnees(4,6).toString(), testedLigne.getC1().toString());
	}
	
	@Test
	public void testSetC2() {
		Ligne testedLigne = new Ligne();
		testedLigne.setC2(new Coordonnees(4,6));
		assertEquals(new Coordonnees(4,6).toString(), testedLigne.getC2().toString());	
	}
	
	@Test
	public void testGetC2() {
		Ligne testedLigne = new Ligne(new Coordonnees(0,0), -0.0005, -0.0005);
		assertEquals(new Coordonnees(0,0).toString(), testedLigne.getC2().toString());	
	}
	
	@Test
	public void testAire() {
		Ligne testedLigne = new Ligne();
		assertEquals(0, testedLigne.aire());
	}
	
	@ParameterizedTest
	@EnumSource()
	public void testAngle(DTLigneAngle dt) {
		Ligne testedLigne = new Ligne(dt.testedLargeur, dt.testedHauteur);
		assertEquals(dt.expectedAngle, Math.round(testedLigne.angle()));
	}
	
	@ParameterizedTest
	@EnumSource()
	public void testContient(DTLigneContient dt) {
		assertEquals(dt.expectedAnswer, dt.testedLigne.contient( dt.testedCoordonnees));
	}
	
	@Test
	public void testToString() {
		Ligne testedLigne = new Ligne(new Coordonnees(5,5), 5, 5);
		assertEquals("[Ligne] c1 : (5,0 , 5,0) c2 : (10,0 , 10,0) longueur : 7,07 angle : 45,0° couleur = R51,V51,B51", 
					testedLigne.toString());
		
		Locale.setDefault(Locale.ENGLISH);
		assertEquals("[Ligne] c1 : (5.0 , 5.0) c2 : (10.0 , 10.0) longueur : 7.07 angle : 45.0° couleur = R51,G51,B51", 
					testedLigne.toString());
		
		Locale.setDefault(Locale.GERMAN);
		assertEquals("[Ligne] c1 : (5,0 , 5,0) c2 : (10,0 , 10,0) longueur : 7,07 angle : 45,0°", testedLigne.toString());
		
		Locale.setDefault(Locale.FRENCH);
	}
}
