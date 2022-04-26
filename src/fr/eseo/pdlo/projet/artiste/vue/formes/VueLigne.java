package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme{
	
	public VueLigne(Ligne ligne) {
		super(ligne);
	}
	
	public void affiche(Graphics2D g2d) {
		
		Color couleurSauvegarde = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		
		Ligne l = (Ligne)this.forme;
		int x1 = (int)Math.round(l.getC1().getAbscisse());
		int y1 = (int)Math.round(l.getC1().getOrdonnee());
		int x2 = (int)Math.round(l.getC2().getAbscisse());
		int y2 = (int)Math.round(l.getC2().getOrdonnee());
		g2d.drawLine(x1, y1, x2, y2);
		
		g2d.setColor(couleurSauvegarde);
	}
}
