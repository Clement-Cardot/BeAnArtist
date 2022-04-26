package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public enum DTEllipseContient {
	DT1 (new Ellipse(10 , 10),new Coordonnees(0,0), false),
	DT2 (new Ellipse(10 , 10),new Coordonnees(5,0), true),
	DT3 (new Ellipse(10 , 10),new Coordonnees(0,5), true),
	DT4 (new Ellipse(10 , 10),new Coordonnees(5,5), true),
	DT5 (new Ellipse(10 , 10),new Coordonnees(0,0), false),
	DT6 (new Ellipse(),new Coordonnees(0,0), false),
	DT7 (new Ellipse(),new Coordonnees(0,0), false),
	DT8 (new Ellipse(),new Coordonnees(0,0), false),
	DT9 (new Ellipse(),new Coordonnees(0,0), false),
	DT10 (new Ellipse(),new Coordonnees(0,0), false),
	DT11 (new Ellipse(),new Coordonnees(0,0), false),
	DT12 (new Ellipse(),new Coordonnees(0,0), false),
	DT13 (new Ellipse(),new Coordonnees(0,0), false),
	DT14 (new Ellipse(),new Coordonnees(0,0), false),
	DT15 (new Ellipse(),new Coordonnees(0,0), false),
	DT16 (new Ellipse(),new Coordonnees(0,0), false),
	DT17 (new Ellipse(),new Coordonnees(0,0), false),
	DT18 (new Ellipse(),new Coordonnees(0,0), false),
	DT19 (new Ellipse(),new Coordonnees(0,0), false),
	DT20 (new Ellipse(),new Coordonnees(0,0), false),
	DT21 (new Ellipse(),new Coordonnees(0,0), false),
	DT22 (new Ellipse(),new Coordonnees(0,0), false),
	DT23 (new Ellipse(),new Coordonnees(0,0), false),
	DT24 (new Ellipse(),new Coordonnees(0,0), false),
	DT25 (new Ellipse(),new Coordonnees(0,0), false);
	
	public Ellipse testedEllipse;
	public Coordonnees testedCoordonnees;
	public boolean expectedAnswer;
	
	DTEllipseContient(Ellipse testedEllipse, Coordonnees testedCoordonnees, boolean expectedAnswer){
		this.testedEllipse = testedEllipse;
		this.testedCoordonnees = testedCoordonnees;
		this.expectedAnswer = expectedAnswer;
	}
	
}
