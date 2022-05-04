package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public enum DTEllipseContient {
	DT1 (new Ellipse(10 , 10),new Coordonnees(0,0), false),
	DT2 (new Ellipse(10 , 10),new Coordonnees(5,0), true),
	DT3 (new Ellipse(10 , 10),new Coordonnees(0,5), true),
	DT4 (new Ellipse(10 , 10),new Coordonnees(5,5), true),
	DT5 (new Ellipse(10 , 10),new Coordonnees(0,0), false),
	DT6 (new Ellipse(),new Coordonnees(0,0), false);

	
	public Ellipse testedEllipse;
	public Coordonnees testedCoordonnees;
	public boolean expectedAnswer;
	
	DTEllipseContient(Ellipse testedEllipse, Coordonnees testedCoordonnees, boolean expectedAnswer){
		this.testedEllipse = testedEllipse;
		this.testedCoordonnees = testedCoordonnees;
		this.expectedAnswer = expectedAnswer;
	}
	
}
