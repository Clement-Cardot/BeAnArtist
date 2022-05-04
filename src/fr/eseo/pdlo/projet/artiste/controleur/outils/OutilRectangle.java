package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilRectangle extends OutilForme{
	
	protected VueForme creerVueForme() {
		double largeur;
		double hauteur;
		Coordonnees position = this.getDebut();
		
		if(this.getDebut().getAbscisse() == this.getFin().getAbscisse() && this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			largeur = Rectangle.LARGEUR_PAR_DEFAUT;
			hauteur = Rectangle.HAUTEUR_PAR_DEFAUT;
		}
		else {
			largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();		
			hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
			
			double abscisse;
			double ordonnee;
			
			if( hauteur < 0) {
				ordonnee = this.getFin().getOrdonnee();
			}
			else ordonnee = this.getDebut().getOrdonnee();
			
			if( largeur < 0) {
				abscisse = this.getFin().getAbscisse();
			}
			else abscisse = this.getDebut().getAbscisse();
			
			position = new Coordonnees(abscisse, ordonnee);
			
			
		}
		largeur = Math.abs(largeur);
		hauteur = Math.abs(hauteur);
		
		Rectangle rectangle = new Rectangle(position, largeur, hauteur);
		rectangle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueRectangle(rectangle);
	}
}
