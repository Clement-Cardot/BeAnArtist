package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public enum DTLigneContient {
	DT1 (new Ligne(10 , 10),new Coordonnees(0 , 0), true),
	DT2 (new Ligne(10 , 10),new Coordonnees(5 , 0), false),
	DT3 (new Ligne(10 , 10),new Coordonnees(0 , 5), false),
	DT4 (new Ligne(10 , 10),new Coordonnees(5 , 5), true),
	DT5 (new Ligne(10 , 10),new Coordonnees(10 , 10), true),
	DT6 (new Ligne(10 , 10),new Coordonnees(5 , 5.1), true),
	DT7 (new Ligne(10 , 10),new Coordonnees(5.1 , 5), true),
	DT8 (new Ligne(10 , 10),new Coordonnees(7 , 8), true),
	DT9 (new Ligne(10 , 10),new Coordonnees(6.2 , 5), true), // Limite de l'epsilon
	DT10 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(0,0), false),
	DT11 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(3,2), true),
	DT12 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(4,4), true),
	DT13 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(3.5,3), true),
	DT14 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(5,6), true),
	DT15 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(0,0), false),
	DT16 (new Ligne(new Coordonnees(2,0), 3, 6),new Coordonnees(0,0), false),
	DT17 (new Ligne(new Coordonnees(-5,-14), -5, -3),new Coordonnees(-5,-14), true),
	DT18 (new Ligne(new Coordonnees(-5,-14), -5, -3),new Coordonnees(-10,-17), true),
	DT19 (new Ligne(new Coordonnees(-5,-14), -5, -3),new Coordonnees(-8,-16), true),
	DT20 (new Ligne(new Coordonnees(-5,-14), -5, -3),new Coordonnees(-6,-14.5), true),
	DT21 (new Ligne(new Coordonnees(-5,-14), -5, -3),new Coordonnees(-15,-15), false);

	public Ligne testedLigne;
	public Coordonnees testedCoordonnees;
	public boolean expectedAnswer;
	
	DTLigneContient(Ligne testedLigne, Coordonnees testedCoordonnees, boolean expectedAnswer){
		this.testedLigne = testedLigne;
		this.testedCoordonnees = testedCoordonnees;
		this.expectedAnswer = expectedAnswer;
	}
}