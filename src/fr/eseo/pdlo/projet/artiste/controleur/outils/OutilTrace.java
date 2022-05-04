package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueTrace;

public class OutilTrace extends OutilForme{

	private VueTrace vueTraceEnCours;
	
	@Override
	protected VueForme creerVueForme() {
		
		return new VueTrace(new Trace());
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		this.vueTraceEnCours = (VueTrace) this.creerVueForme();
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		this.getPanneauDessin().getVueFormes().remove(vueTraceEnCours);
		
		Trace traceEnCours = (Trace) this.vueTraceEnCours.getForme();
		traceEnCours.getPixels().add(new Coordonnees(event.getX(),event.getY()));
		
		traceEnCours.setLargeur(traceEnCours.getCadreMaxX() - traceEnCours.getCadreMinX());
		traceEnCours.setHauteur(traceEnCours.getCadreMaxY() - traceEnCours.getCadreMinY());
		
		//Rubber Banding
		this.getPanneauDessin().ajouterVueForme(vueTraceEnCours);
		this.getPanneauDessin().repaint();
	}
}
