package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() >= 2) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(),event.getY()));
	}
	
	public void mouseReleased(MouseEvent event) {
		
		this.setFin(new Coordonnees(event.getX(),event.getY()));
		
		if( !( this.getDebut().getAbscisse() == this.getFin().getAbscisse() 
			&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee())) {
			
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}
	
	abstract protected VueForme creerVueForme();
}
