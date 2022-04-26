package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public enum DTLigneConstructeur {
	DT1 (new Coordonnees(), new Coordonnees(1,1), 1, 1),
	DT2 (new Coordonnees(), new Coordonnees(7,-5), 7, -5),
	DT3 (new Coordonnees(2,-3), new Coordonnees(), -2, 3),
	DT4 (new Coordonnees(8,5), new Coordonnees(4,3), -4, -2),
	DT5 (new Coordonnees(), new Coordonnees(), 0, 0);
	
	public Coordonnees c1Coord;
	public Coordonnees c2Coord;
	public double largeur;
	public double hauteur;
	
	DTLigneConstructeur(Coordonnees c1Coord, Coordonnees c2Coord, double largeur, double hauteur){
		this.c1Coord = c1Coord;
		this.c2Coord = c2Coord;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
}
