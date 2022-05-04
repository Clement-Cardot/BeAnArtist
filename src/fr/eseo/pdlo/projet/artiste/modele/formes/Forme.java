package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;
import java.io.Serializable;

import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public abstract class Forme implements Coloriable, Serializable{

	public static final double LARGEUR_PAR_DEFAUT = 10;
	public static final double HAUTEUR_PAR_DEFAUT = 10;
	public static final Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");
	
	private double largeur;
	private double hauteur;
	private Coordonnees position;
	private Color couleur;
	
	
	// Contructeurs
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = COULEUR_PAR_DEFAUT;
	}
	
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	// Accesseurs
	public Coordonnees getPosition() {
		return this.position;
	}
	
	public double getLargeur() {
		return this.largeur;
	}
	
	public double getHauteur() {
		return this.hauteur;
	}
	
	public double getCadreMinX() {
		if (this.getLargeur() > 0) {
			return this.getPosition().getAbscisse();
		}
		else {
			return this.getPosition().getAbscisse() + this.getLargeur();
		}
	}
	
	public double getCadreMinY() {
		if (this.getHauteur() > 0) {
			return this.getPosition().getOrdonnee();
		}
		else {
			return this.getPosition().getOrdonnee() + this.getHauteur();
		}	
	}
	
	public double getCadreMaxX() {
		if (this.getLargeur() < 0) {
			return this.getPosition().getAbscisse();
		}
		else {
			return this.getPosition().getAbscisse() + this.getLargeur();
		}
	}
	
	public double getCadreMaxY() {
		if (this.getHauteur() < 0) {
			return this.getPosition().getOrdonnee();
		}
		else {
			return this.getPosition().getOrdonnee() + this.getHauteur();
		}	
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	// Mutateurs
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	public void setX(double x) {
		this.getPosition().setAbscisse(x);
	}
	
	public void setY(double y) {
		this.getPosition().setOrdonnee(y);
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	// Méthodes
	public void deplacerVers(double nouvX, double nouvY) {
		this.getPosition().deplacerVers(nouvX, nouvY);
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
	}
	
	public Remplissage getRemplissage() {
		return Remplissage.AUCUNE;
	}
	
	public void setRemplissage(Remplissage remplissage) {
	
	}
	
	public abstract double aire();
	public abstract double perimetre();
	public abstract boolean contient(Coordonnees coordonnees);
}
