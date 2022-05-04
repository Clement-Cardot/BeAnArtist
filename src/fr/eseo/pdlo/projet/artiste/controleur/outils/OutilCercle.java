package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme{
	
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() >= 2) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}
	
	protected VueForme creerVueForme() {
		double diametre;
		double largeur;
		double hauteur;
		Coordonnees position = this.getDebut();
		
		if(this.getDebut().getAbscisse() == this.getFin().getAbscisse() && this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			diametre = Cercle.LARGEUR_PAR_DEFAUT;
		}
		else {
			diametre = Math.max(Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse()) , 
					   Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee()));
			
			largeur = this.getFin().getAbscisse() - this.getDebut().getAbscisse();		
			hauteur = this.getFin().getOrdonnee() - this.getDebut().getOrdonnee();
			
			double abscisse;
			double ordonnee;
			
			if( largeur < 0) {
				abscisse = this.getDebut().getAbscisse() - diametre;
			}
			else abscisse = this.getDebut().getAbscisse();
			
			if( hauteur < 0) {
				ordonnee = this.getDebut().getOrdonnee() - diametre;
			}
			else ordonnee = this.getDebut().getOrdonnee();
			
			
			
			position = new Coordonnees(abscisse, ordonnee);
		}

		Cercle cercle = new Cercle(position, diametre);
		cercle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueCercle(cercle);
	}
}
