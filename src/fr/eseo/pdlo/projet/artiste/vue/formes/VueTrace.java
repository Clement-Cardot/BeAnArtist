package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;

@SuppressWarnings("serial")
public class VueTrace extends VueForme{

	public VueTrace(Trace trace) {
		super(trace);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Trace trace = (Trace) this.getForme();
		
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		
		for(int i = 0; i < trace.getPixels().size()-1; i++) {
			int x1 = (int)Math.round(trace.getPixels().get(i).getAbscisse());
			int x2 = (int)Math.round(trace.getPixels().get(i+1).getAbscisse());
			
			int y1 = (int)Math.round(trace.getPixels().get(i).getOrdonnee());
			int y2 = (int)Math.round(trace.getPixels().get(i+1).getOrdonnee());
			g2d.drawLine(x1, y1, x2, y2);
		}
		
		g2d.setColor(couleurSauvegarde);
	}

}
