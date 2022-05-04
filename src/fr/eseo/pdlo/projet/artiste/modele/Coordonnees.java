package fr.eseo.pdlo.projet.artiste.modele;

import java.util.Locale;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class Coordonnees implements Serializable{
	// Constantes de classe
	public static final double ABSCISSE_PAR_DEFAUT = 0;
	public static final double ORDONNEE_PAR_DEFAUT = 0;
	
    // Variables de classe

    // Variables d'instances
    double abscisse;
    double ordonnee;


    // Constructeurs
    public Coordonnees(){
        this.abscisse = ABSCISSE_PAR_DEFAUT;
        this.ordonnee = ORDONNEE_PAR_DEFAUT;
    }

    public Coordonnees(double abscisse, double ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    // Accesseurs & Mutateurs
    public double getAbscisse(){
        return this.abscisse;
    }

    public double getOrdonnee(){
        return this.ordonnee;
    }
    
    public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}
    
    public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

 // Méthodes
    public void deplacerVers(double newAbscisse, double newOrdonnee){
        this.setAbscisse(newAbscisse);
        this.setOrdonnee(newOrdonnee);
    }

    public void deplacerDe(double deltaAbscisse, double deltaOrdonnee){
        this.abscisse += deltaAbscisse;
        this.ordonnee += deltaOrdonnee;
    }

    public double distanceVers(Coordonnees coord){
        return Math.sqrt( Math.pow( this.abscisse - coord.getAbscisse(), 2) + Math.pow( this.ordonnee - coord.getOrdonnee(), 2 ) );
    }

    public double angleVers(Coordonnees coord){
        return Math.atan2( coord.getOrdonnee()- this.ordonnee, coord.getAbscisse() - this.abscisse );
    }
    
	public String toString() {
		DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance(Locale.getDefault());
		String pattern = "##0.0#";
		decimalFormat.applyPattern(pattern);
		
		return "(" + decimalFormat.format(this.abscisse) + " , " + decimalFormat.format(this.ordonnee) + ")";
	}
}
