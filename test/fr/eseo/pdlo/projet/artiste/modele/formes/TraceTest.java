package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class TraceTest {
	@Test
	public void testConstructeur0() {
		Trace testTrace = new Trace();
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT ,testTrace.getPosition().getAbscisse());
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT ,testTrace.getPosition().getOrdonnee());
		assertEquals(Forme.HAUTEUR_PAR_DEFAUT, testTrace.getHauteur());
	}
	
	
	@Test
	public void testPixels() {
		Trace testTrace = new Trace();
		ArrayList<Coordonnees> pixels = new ArrayList<Coordonnees>();
		pixels.add(new Coordonnees());
		testTrace.setPixels(pixels);
		assertTrue(testTrace.getPixels().equals(pixels));
	}
	
	@Test
	public void testAire() {
		Trace testTrace = new Trace();
		assertEquals(0, testTrace.aire());
	}
	
	@Test
	public void testPerimetre() {
		Trace testTrace = new Trace();
		assertEquals(0, testTrace.perimetre());
	}
	
	@Test
	public void testPerimetre2() {
		Trace testTrace = new Trace();
		assertEquals(3, testTrace.perimetre(new Coordonnees(1,2), new Coordonnees(1,5)));
	}
	
	@Test
	public void testContient() {
		Trace testTrace = new Trace();
		ArrayList<Coordonnees> pixels = new ArrayList<Coordonnees>();
		pixels.add(new Coordonnees(0,0));
		pixels.add(new Coordonnees(2,2));
		testTrace.setPixels(pixels);
		assertTrue(testTrace.contient(new Coordonnees(1,1)));
		assertFalse(testTrace.contient(new Coordonnees(5,5)));
	}
	
	@Test
	public void testDeplacerVers() {
		Trace testTrace = new Trace();
		
		ArrayList<Coordonnees> pixels = new ArrayList<Coordonnees>();
		pixels.add(new Coordonnees(0,0));
		pixels.add(new Coordonnees(2,2));
		testTrace.setPixels(pixels);
		
		testTrace.deplacerVers(9, 5);
		assertEquals(9 ,testTrace.getPosition().getAbscisse());
		assertEquals(5 ,testTrace.getPosition().getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		Trace testTrace = new Trace();
		
		ArrayList<Coordonnees> pixels = new ArrayList<Coordonnees>();
		pixels.add(new Coordonnees(0,0));
		pixels.add(new Coordonnees(2,2));
		testTrace.setPixels(pixels);
		
		testTrace.deplacerDe(9, 5);
		assertEquals(9 ,testTrace.getPosition().getAbscisse());
		assertEquals(5 ,testTrace.getPosition().getOrdonnee());
	}
	
	@Test
	public void testGetCadre() {
		Trace testTrace = new Trace();
		
		ArrayList<Coordonnees> pixels = new ArrayList<Coordonnees>();
		pixels.add(new Coordonnees(0,0));
		pixels.add(new Coordonnees(2,2));
		testTrace.setPixels(pixels);
		
		assertEquals(0 ,testTrace.getCadreMinX());
		assertEquals(0 ,testTrace.getCadreMinY());
		assertEquals(2 ,testTrace.getCadreMaxX());
		assertEquals(2 ,testTrace.getCadreMaxY());
	}
}
