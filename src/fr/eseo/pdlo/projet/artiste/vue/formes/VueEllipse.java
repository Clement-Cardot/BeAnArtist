package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme{
	
	public VueEllipse(Ellipse ellipse){
		super(ellipse);
	}
	
	public void affiche(Graphics2D g2d) {	
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		
		int x = (int)Math.round(this.forme.getPosition().getAbscisse());
		int y = (int)Math.round(this.forme.getPosition().getOrdonnee());
		
		int height = (int)Math.round(this.forme.getHauteur());
		int width = (int)Math.round(this.forme.getLargeur());
		
		Ellipse ellipse = (Ellipse) this.getForme();
		if(ellipse.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillOval(x, y, width, height);
			
		}
		
		g2d.drawOval(x, y, width, height);
		
		g2d.setColor(couleurSauvegarde);
	}
}
