package fr.eseo.pdlo.projet.artiste.controleur.outils;


import java.awt.Polygon;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Etoile;
import fr.eseo.pdlo.projet.artiste.modele.formes.Polygone;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VuePolygone;

public class OutilPolygone extends OutilForme{
	private int numCote;
	
	public OutilPolygone(int numCote) {
		this.numCote = numCote;
	}
	
	@Override
	protected VueForme creerVueForme() {
		double diametre;
		double largeur;
		double hauteur;
		Coordonnees position = this.getDebut();
		
		if(this.getDebut().getAbscisse() == this.getFin().getAbscisse() && this.getDebut().getOrdonnee() == this.getFin().getOrdonnee()) {
			diametre = Etoile.LARGEUR_PAR_DEFAUT;
		}
		else {
			diametre = Math.max(Math.abs(this.getFin().getAbscisse() - this.getDebut().getAbscisse()) , 
					   Math.abs(this.getFin().getOrdonnee() - this.getDebut().getOrdonnee()));
			
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
		
		
		Polygone polygone = new Polygone(position, diametre, this.numCote);
		double centerX = position.getAbscisse() + diametre/2;
		double centerY = position.getOrdonnee() + diametre/2;
		double radius = diametre/2;
		
		polygone.setPolygone(createPolygone(centerX, centerY, radius, this.numCote, 0));
		polygone.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VuePolygone(polygone);
	}
	
	public static Polygon createPolygone(double centerX, double centerY, double radius, int numCote, double startAngle) {
		
		//Xi = cx + R*cos(2.0*PI*i/n)
		//Yi = cy + R*sin(2.0*PI*i/n)
		
		int[] listX = new int[numCote];
		int[] listY = new int[numCote];
		
		for(int i = 0; i < numCote; i++) {
			listX[i] = (int) Math.round(centerX + radius*Math.cos(2*Math.PI*i/numCote));
			listY[i] = (int) Math.round(centerY + radius*Math.sin(2*Math.PI*i/numCote));
		}
	
		return new Polygon(listX, listY, numCote);
	}

}
