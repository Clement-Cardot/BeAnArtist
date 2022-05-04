package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class Rectangle extends Forme implements Remplissable{
	
	private Remplissage remplissage = Remplissage.AUCUNE;
	
	public Rectangle(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
    	if(largeur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable largeur");
		}
    	if(hauteur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable hauteur");
		} 
	}

	public Rectangle(double largeur, double hauteur){
        super(largeur, hauteur);
        if(largeur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable largeur");
		}
    	if(hauteur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable hauteur");
		}
    }

    public Rectangle(Coordonnees position){
        super(position);
    }

    public Rectangle(){
        super();
    }
    
    //Méthodes
    public void setLargeur(double largeur) {
    	super.setLargeur(largeur);
    	if(largeur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable largeur");
		}
    }
    
    public void setHauteur(double hauteur) {
    	super.setHauteur(hauteur);
    	if(hauteur < 0) {
			throw new IllegalArgumentException("Valeur négative dans la variable hauteur");
		}
    }
    
    public double getPetitCote() {
    	return (this.getHauteur() < this.getLargeur())? this.getHauteur()/2 : this.getLargeur()/2;
    }
    
    public double getGrandCote() {
    	return (this.getHauteur() > this.getLargeur())? this.getHauteur()/2 : this.getLargeur()/2;
    }
    
    public double aire(){
        return this.getLargeur() * this.getHauteur();
    }
    
    public double perimetre(){
    	return 2 * (this.getHauteur() + this.getLargeur());
    }
    
    public boolean contient(Coordonnees coordonnees) {
    	double x = coordonnees.getAbscisse() - (this.getPosition().getAbscisse() + this.getLargeur()/2);
    	double y = coordonnees.getOrdonnee() - (this.getPosition().getOrdonnee() + this.getHauteur()/2);
    	return (((Math.pow(x, 2) / Math.pow(this.getLargeur()/2, 2)) + (Math.pow(y, 2) / Math.pow(this.getHauteur()/2, 2))) <= 1);	
    }
    
    public String toString() {
    	DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(Locale.getDefault());
		String pattern = "##0.0#";
		decimalFormat.applyPattern(pattern);
    	String txt = "[" + this.getClass().getSimpleName() + " " + this.getRemplissage().getMode() +  "] : pos " + this.getPosition().toString() 
    			+ " petit cote " + decimalFormat.format(this.getPetitCote()) + " grand cote " + decimalFormat.format(this.getGrandCote())
    			+ " périmètre : " + decimalFormat.format(this.perimetre()) + " aire : " + decimalFormat.format(this.aire());
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
    
    @Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}

	@Override
	public void setRemplissage(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
	}
    
    
}