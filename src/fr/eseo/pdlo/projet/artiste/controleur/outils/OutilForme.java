package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	
	private VueForme formeEnCours;
	
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() >= 2) {
			this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			this.getPanneauDessin().repaint();
		}
	}

	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(),event.getY()));
		this.setFin(new Coordonnees(event.getX(),event.getY()));
		// A tester Avec Assignment center
		this.formeEnCours = this.creerVueForme();
		this.formeEnCours.getForme().setCouleur(this.getPanneauDessin().getCouleurCourante());
		this.getPanneauDessin().ajouterVueForme(this.formeEnCours);
	}
	
	public void mouseReleased(MouseEvent event) {
		if( ( this.getDebut().getAbscisse() == this.getFin().getAbscisse() 
			&& this.getDebut().getOrdonnee() == this.getFin().getOrdonnee())) {
			
			this.getPanneauDessin().getVueFormes().remove(this.formeEnCours);
			this.getPanneauDessin().repaint();
		}

	}
	
	
	public void mouseDragged(MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(),event.getY()));
		
		int i = this.getPanneauDessin().getVueFormes().indexOf(this.formeEnCours);
		this.formeEnCours = this.creerVueForme();
		this.formeEnCours.getForme().setCouleur(this.getPanneauDessin().getCouleurCourante());
		this.getPanneauDessin().getVueFormes().set(i, this.formeEnCours);
		this.getPanneauDessin().repaint();
	}
	
	abstract protected VueForme creerVueForme();
}
