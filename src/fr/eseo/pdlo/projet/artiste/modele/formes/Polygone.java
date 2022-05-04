package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Polygon;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class Polygone extends Forme implements Remplissable{

	private Remplissage remplissage = Remplissage.AUCUNE;
	private Polygon formePolygone;
	private int numCote;
	
	public Polygone(Coordonnees position, double largeur, int numCote) {
		super(position, largeur, largeur);
		this.setNumCote(numCote);
		if(largeur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable diametre");
		}
	}
	
	public Polygone(int largeur, int numCote) {
		super(largeur, largeur);
		this.setNumCote(numCote);
		if(largeur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable diametre");
		}
	}
	
	public Polygone(Coordonnees position, int numCote) {
		super(position);
		this.setNumCote(numCote);
	}
	
	public Polygone(int numCote) {
		super();
		this.setNumCote(numCote);
	}
	
	public void setLargeur(double largeur) {
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
	public int getNumCote() {
		return numCote;
	}

	public void setNumCote(int numCote) {
		this.numCote = numCote;
	}

	public Polygon getPolygone() {
		return formePolygone;
	}
	

	public void setPolygone(Polygon newFormePolygone) {
		this.formePolygone = newFormePolygone;
	}

	
	@Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}

	@Override
	public void setRemplissage(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;		
	}

	@Override
	public double aire() {
		return 0;
	}

	@Override
	public double perimetre() {
		return 0;
	}

	@Override
	public boolean contient(Coordonnees coord) {
		return formePolygone.contains(coord.getAbscisse(), coord.getOrdonnee());
	}

	@Override
	public void deplacerVers(double nouvX, double nouvY) {
		this.getPosition().deplacerVers(nouvX, nouvY);
	}
	
	@Override
	public void deplacerDe(double deltaX, double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
		
		this.formePolygone.translate((int)deltaX, (int)deltaY);
	}
}
