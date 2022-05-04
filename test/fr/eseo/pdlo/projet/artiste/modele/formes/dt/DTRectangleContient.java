package fr.eseo.pdlo.projet.artiste.modele.formes.dt;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;

public enum DTRectangleContient {
	DT1 (new Rectangle(10 , 10),new Coordonnees(0,0), false),
	DT2 (new Rectangle(10 , 10),new Coordonnees(5,0), true),
	DT3 (new Rectangle(10 , 10),new Coordonnees(0,5), true),
	DT4 (new Rectangle(10 , 10),new Coordonnees(5,5), true),
	DT5 (new Rectangle(10 , 10),new Coordonnees(0,0), false),
	DT25 (new Rectangle(),new Coordonnees(0,0), false);
	
	public Rectangle testedRectangle;
	public Coordonnees testedCoordonnees;
	public boolean expectedAnswer;
	
	DTRectangleContient(Rectangle testedRectangle, Coordonnees testedCoordonnees, boolean expectedAnswer){
		this.testedRectangle = testedRectangle;
		this.testedCoordonnees = testedCoordonnees;
		this.expectedAnswer = expectedAnswer;
	}
}
