package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{

	public Cercle(Coordonnees position, double largeur){
		super(position, largeur, largeur);

	}
	
	public Cercle(Coordonnees position){
		super(position, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double largeur){
		super(largeur, largeur);
	}
	
	public Cercle(){
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	//Méthodes

	public void setLargeur(double largeur) {
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
    public double aire(){
        return Math.pow(this.getLargeur()/2, 2) * Math.PI;
    }

    public double perimetre(){
        return 2*Math.PI * this.getLargeur()/2;
    }
    
    public String toString() {
    	DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(Locale.getDefault());
		String pattern = "##0.0#";
		decimalFormat.applyPattern(pattern);
    	String txt = "[" + this.getClass().getSimpleName() + " " + this.getRemplissage().getMode() + "] : pos " + this.getPosition().toString() 
    			+ " rayon " + decimalFormat.format(this.getLargeur()/2) + " périmètre : " + decimalFormat.format(this.perimetre())
    			+ " aire : " + decimalFormat.format(this.aire());
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
		
		return txt;
    }
}
