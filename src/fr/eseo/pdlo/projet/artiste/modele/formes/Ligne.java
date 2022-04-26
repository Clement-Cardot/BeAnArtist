package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {
	
	public static final double EPSILON = 0.2; // Temporaire remettre 0.1 après
	
	// Constructeurs
	public Ligne(Coordonnees position, double largeur, double hauteur){
		super(position, largeur, hauteur);
	}
	
	public Ligne(Coordonnees position){
		super(position);
	}
	
	public Ligne(double largeur, double hauteur){
		super(largeur, hauteur);
	}
	
	public Ligne(){
		super();
	}

	// Accesseurs
	public Coordonnees getC1(){
		return this.getPosition();
	}
	
	public Coordonnees getC2(){
		double c2x = this.getC1().getAbscisse() + this.getLargeur();
		double c2y = this.getC1().getOrdonnee() + this.getHauteur();
		
		// Evite de retourner la valeur "-0.000"
		if (c2x > - 0.0009 && c2x < 0) c2x = -c2x;
		if (c2y > - 0.0009 && c2y < 0) c2y = -c2y;
		
		return new Coordonnees(c2x, c2y);
	}
	
	public void setC1(Coordonnees p1) {
		this.setHauteur(this.getHauteur() + (this.getC1().getOrdonnee() - p1.getOrdonnee()));
		this.setLargeur(this.getLargeur() + (this.getC1().getAbscisse() - p1.getAbscisse()));
		this.deplacerVers(p1.getAbscisse(), p1.getOrdonnee());
	}
	
	public void setC2(Coordonnees p2) {
		this.setHauteur(this.getHauteur() + (p2.getOrdonnee() - this.getC2().getOrdonnee()));
		this.setLargeur(this.getLargeur() + (p2.getAbscisse() - this.getC2().getAbscisse()));
	}
	
	// Méthodes
	public double aire() {
		return 0;
	}
	
	public double perimetre() {
		return Math.sqrt(Math.pow(getLargeur(), 2) + Math.pow(getHauteur(), 2));
	}
	
	public boolean contient(Coordonnees coordonnees) {
		double distanceC1 = Math.abs(this.getC1().distanceVers(coordonnees));
		double distanceC2 = Math.abs(this.getC2().distanceVers(coordonnees));
		return (distanceC1+ distanceC2-this.perimetre() <= EPSILON);
	}
	
	public double angle() {
		double coteOppose = this.getC2().getOrdonnee() - this.getC1().getOrdonnee();
		double coteAdjacent = this.getC2().getAbscisse() - this.getC1().getAbscisse();
		double tan = Math.atan2(coteOppose, coteAdjacent);
		double deg = Math.toDegrees(tan);
		
		if(this.getC2().getOrdonnee()>=this.getC1().getOrdonnee()) {
			return deg;
		}
		else return 360 + deg;
	}
	
	public String toString() {
		DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(Locale.getDefault());
		String pattern = "##0.0#";
		decimalFormat.applyPattern(pattern);
		String txt = "[" + this.getClass().getSimpleName() + "] "
			 + "c1 : (" + decimalFormat.format(this.getC1().getAbscisse()) 
			 + " , " + decimalFormat.format(this.getC1().getOrdonnee()) + ") "
			 + "c2 : (" + decimalFormat.format(this.getC2().getAbscisse()) 
			 + " , " + decimalFormat.format(this.getC2().getOrdonnee()) 
			 + ") longueur : " + decimalFormat.format(this.perimetre())
			 + " angle : " + decimalFormat.format(this.angle()) + '\u00B0';
		if(Locale.getDefault().getLanguage().equals("fr")) {
			txt += " couleur = R" + this.getCouleur().getRed()
						   + ",V" + this.getCouleur().getGreen()
						   + ",B" + this.getCouleur().getBlue();
		}
		else if (Locale.getDefault().getLanguage().equals("en")) {
			txt += " couleur = R" + this.getCouleur().getRed()
						   + ",G" + this.getCouleur().getGreen()
						   + ",B" + this.getCouleur().getBlue();
		}
		else System.out.println(Locale.getDefault().getLanguage());
		
		return txt;
	}
}

