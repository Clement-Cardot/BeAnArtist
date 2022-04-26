package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CoordonneesTest {
	@Test
	public void testConstructeur0() {
		Coordonnees coord = new Coordonnees();
		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, coord.getAbscisse());
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, coord.getOrdonnee());
	}
	
	@Test
	public void testConstructeur2() {
		Coordonnees coord = new Coordonnees(7.2, 4.6);
		assertEquals(7.2, coord.getAbscisse());
		assertEquals(4.6, coord.getOrdonnee());
		
		Coordonnees coord2 = new Coordonnees(8, 0);
		assertEquals(8, coord2.getAbscisse());
		assertEquals(0, coord2.getOrdonnee());
		
		Coordonnees coord3 = new Coordonnees(-13.99, 100.0001);
		assertEquals(-13.99, coord3.getAbscisse());
		assertEquals(100.0001, coord3.getOrdonnee());
	}
	
	@Test
	public void testDeplacerDe() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerDe(1, 2);
		assertEquals(new Coordonnees(1, 2).toString(), coord.toString());
		coord.deplacerDe(-1, -2);
		assertEquals(new Coordonnees(0,0).toString(), coord.toString());
	}
	
	@Test
	public void testDeplacerVers() {
		Coordonnees coord = new Coordonnees();
		coord.deplacerVers(5, -4);
		assertEquals(new Coordonnees(5, -4).toString(), coord.toString());
	}
	
	@Test
	public void testDistanceVers() {
		Coordonnees coord = new Coordonnees();
		assertEquals(5, coord.distanceVers(new Coordonnees(0,5)));
		assertEquals(5, coord.distanceVers(new Coordonnees(0,-5)));
	}
	
	@Test
	public void testAngleVers() {
		Coordonnees coord = new Coordonnees();
		assertEquals(0, coord.angleVers(new Coordonnees(1,0)));
		assertEquals(Math.PI, coord.angleVers(new Coordonnees(-1,0)));
	}
	
	@Test
	public void testToString() {
		Coordonnees coord = new Coordonnees(8.5 , 4.6);
		assertEquals("(8,5 , 4,6)", coord.toString());
	}
}
